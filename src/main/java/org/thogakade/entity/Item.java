package org.thogakade.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item implements Serializable {
   @Id
   private String itemCode;
   private String description;
   private int qty;
   private double unitPrice;
   @ToString.Exclude
   @OneToMany(fetch = FetchType.EAGER,orphanRemoval = true,mappedBy = "item")
  private List<OrderDetail> orderDetailList;
}
