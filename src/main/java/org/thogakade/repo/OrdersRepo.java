package org.thogakade.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.thogakade.entity.Orders;

public interface OrdersRepo extends JpaRepository<Orders,String> {

}
