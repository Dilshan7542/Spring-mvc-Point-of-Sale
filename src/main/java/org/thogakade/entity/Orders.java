package org.thogakade.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Orders implements Serializable {
    @Id
    private String orderID;
    private LocalDate date;
    private LocalTime time;
    @ManyToOne
    private Customer customer;
    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orders", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<OrderDetail> orderDetailList;
}
