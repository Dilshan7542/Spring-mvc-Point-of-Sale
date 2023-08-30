package org.thogakade.controller;

import org.springframework.web.bind.annotation.*;
import org.thogakade.dto.CustomerDTO;
import org.thogakade.util.ResponseUtil;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {

    @PostMapping
      public ResponseUtil saveCustomer(@ModelAttribute CustomerDTO customerDTO){
        if(customerDTO.getName()==null){
        throw new RuntimeException("Customer Exists...!!");
        }
        return new ResponseUtil("OK","Successfully",null);
      }
}
