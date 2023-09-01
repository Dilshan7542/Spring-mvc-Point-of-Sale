package org.thogakade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.thogakade.dto.CustomerDTO;
import org.thogakade.service.CustomerService;
import org.thogakade.util.ResponseUtil;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {
@Autowired
  CustomerService customerService;
    @PostMapping
      public ResponseUtil saveCustomerForm(@ModelAttribute CustomerDTO customerDTO){
       return new ResponseUtil("200","successfully",customerService.saveCustomer(customerDTO));
      }

      @PostMapping(path = "json")
    public ResponseUtil saveCustomerJSON(@RequestBody CustomerDTO customerDTO){
        System.out.println("JSON ");
       return new ResponseUtil("200","successfully",customerService.saveCustomer(customerDTO));
    }

    @PutMapping
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO customerDTO){
        return new ResponseUtil("200","Successfully",customerService.updateCustomer(customerDTO));
    }
    @GetMapping(path = "search",params = "customerID")
    public ResponseUtil searchCustomer(@RequestParam String id){
        return new ResponseUtil("200","Successfully",customerService.searchCustomer(id));
    }
      @GetMapping
      public List<CustomerDTO> getAllCustomer(){
       return customerService.getAllCustomer();
      }

      @GetMapping(path = "param",produces ={MediaType.APPLICATION_JSON_VALUE} )
      public List<CustomerDTO> sendCustomerJSON(){
          System.out.println("param");
        return customerService.getAllCustomer();
      }
      @DeleteMapping(path = "delete",params = "customerID")
      public ResponseUtil deleteCustomer(@RequestParam String customerID){
          return new ResponseUtil("200","Successfully",customerService.deleteCustomer(customerID));
      }

}
