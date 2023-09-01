package org.thogakade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.thogakade.dto.ItemDTO;
import org.thogakade.entity.Item;
import org.thogakade.service.ItemService;
import org.thogakade.util.ResponseUtil;

@RestController
@CrossOrigin
@RequestMapping("/item")
public class ItemController {
    @Autowired
    ItemService itemService;
    @PostMapping
    public ResponseUtil saveItem(@ModelAttribute ItemDTO itemDTO){
        return new ResponseUtil("OK","Successfully",itemService.saveItem(itemDTO));
     }
     @PostMapping(path = "json")
     public ResponseUtil saveItemJSON(@RequestBody ItemDTO itemDTO){
         return new ResponseUtil("OK","Successfully",itemService.saveItem(itemDTO));
     }
     @PutMapping
     public ResponseUtil updateItem(@RequestBody ItemDTO itemDTO){
         return new ResponseUtil("OK","Successfully",itemService.updateItem(itemDTO));
     }
     @GetMapping(path ="search" ,params = "itemCode")
     public ResponseUtil searchItem(@RequestParam String itemCode){
         return new ResponseUtil("OK","Successfully",itemService.searchItem(itemCode));
     }

     @GetMapping
     public ResponseUtil getAllItem(){
         return new ResponseUtil("OK","Successfully",itemService.getAllItem());
     }
}

