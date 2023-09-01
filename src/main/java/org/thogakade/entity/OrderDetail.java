package org.thogakade.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@IdClass(OrderDetail_PK.class)
public class OrderDetail{
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderID")
   Orders orders;
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "itemCode")
    Item item;
    private String description;
    private int qty;
    private double unitPrice;
    private int discount;
}
