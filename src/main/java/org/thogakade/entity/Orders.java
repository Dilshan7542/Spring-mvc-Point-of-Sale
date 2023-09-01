package org.thogakade.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Orders implements Serializable {
    @Id
    private String orderID;
    private Date date;
    private Time time;
    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;
    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orders", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<OrderDetail> orderDetailList;
}
