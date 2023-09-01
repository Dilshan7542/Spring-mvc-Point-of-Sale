package org.thogakade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.thogakade.dto.OrdersDTO;
import org.thogakade.repo.OrderDetailsRepo;
import org.thogakade.repo.OrdersRepo;
import org.thogakade.service.PurchaseOrderService;
import org.thogakade.util.ResponseUtil;

@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrdersController {

    @Autowired
    private PurchaseOrderService purchaseOrderService;

   @PostMapping
        public ResponseUtil saveOrder(@RequestBody OrdersDTO ordersDTO){
            return new ResponseUtil("OK","Successfully",purchaseOrderService.savePurchaseOrder(ordersDTO));
        }
        @PutMapping
    public ResponseUtil updateOrder(@RequestBody OrdersDTO ordersDTO){
        return new ResponseUtil("OK","Successfully",purchaseOrderService.updatePurchaseOrder(ordersDTO));
    }
    @GetMapping(path = "search",params = "orderID")
    public ResponseUtil searchOrder(@RequestParam("orderID") String id){
        return new ResponseUtil("OK","Successfully",purchaseOrderService.searchPurchaseOrder(id));
    }
    @GetMapping
    public ResponseUtil getAllOrders(){
        return new ResponseUtil("OK","Successfully",purchaseOrderService.getAllPurchaseOrder());
    }

}
