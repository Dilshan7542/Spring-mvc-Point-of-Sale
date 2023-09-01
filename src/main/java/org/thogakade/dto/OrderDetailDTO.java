package org.thogakade.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.thogakade.entity.Item;
import org.thogakade.entity.Orders;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailDTO {
   private Orders orders;
   private Item item;
   private String description;
   private int qty;
   private double unitPrice;
   private int discount;
}
