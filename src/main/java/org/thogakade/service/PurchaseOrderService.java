package org.thogakade.service;

import org.thogakade.dto.OrdersDTO;

import java.util.List;

public interface PurchaseOrderService {
    OrdersDTO savePurchaseOrder(OrdersDTO ordersDTO);

    OrdersDTO updatePurchaseOrder(OrdersDTO ordersDTO);

    boolean deletePurchaseOrder(String id);

    OrdersDTO searchPurchaseOrder(String id);

    List<OrdersDTO> getAllPurchaseOrder();
}
