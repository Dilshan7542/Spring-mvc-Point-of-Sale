package org.thogakade.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrdersDTO {
    private String orderID;
    private Date date;
    private Time time;
    private CustomerDTO customer;
    @ToString.Exclude
    private List<OrderDetailDTO> orderDetailList;
}
