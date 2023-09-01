package org.thogakade.service.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thogakade.dto.OrdersDTO;

import org.thogakade.entity.Orders;
import org.thogakade.repo.OrderDetailsRepo;
import org.thogakade.repo.OrdersRepo;
import org.thogakade.service.PurchaseOrderService;

import java.util.List;

@Service
@Transactional
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
    @Autowired
    OrdersRepo ordersRepo;
    @Autowired
    OrderDetailsRepo orderDetailsRepo;

    @Autowired
    ModelMapper mapper;


    @Override
    public OrdersDTO savePurchaseOrder(OrdersDTO ordersDTO) {
        if (ordersRepo.existsById(ordersDTO.getOrderID())) {
            throw new RuntimeException("Order is already exists..!");
        }
         ordersRepo.save(mapper.map(ordersDTO, Orders.class));
         return ordersDTO;
    }

    @Override
    public OrdersDTO updatePurchaseOrder(OrdersDTO ordersDTO) {
        if (!ordersRepo.existsById(ordersDTO.getOrderID())) {
            throw new RuntimeException("Order is not exists..!");
        }
        ordersRepo.save(mapper.map(ordersDTO, Orders.class));
        return ordersDTO;
    }

    @Override
    public boolean deletePurchaseOrder(String id) {
        if (!ordersRepo.existsById(id)) {
            throw new RuntimeException("Order is not exists..!");
        }
        ordersRepo.deleteById(id);
        return !ordersRepo.existsById(id);
    }

    @Override
    public OrdersDTO searchPurchaseOrder(String id) {
        if (!ordersRepo.existsById(id)) {
            throw new RuntimeException("Order is not exists..!");
        }
        return mapper.map(ordersRepo.findById(id).get(),OrdersDTO.class);
    }

    @Override
    public List<OrdersDTO> getAllPurchaseOrder() {
        return mapper.map(ordersRepo.findAll(),new TypeToken<List<OrdersDTO>>(){}.getType());
    }
}
