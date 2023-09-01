package org.thogakade.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Customer {
    @Id
    private String customerID;
    private String name;
    private String email;
    private String phone;
    private double salary;
    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
   private List<Orders> orderDetailList;
}
