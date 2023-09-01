package org.thogakade.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.thogakade.entity.OrderDetail;
import org.thogakade.entity.OrderDetail_PK;

import java.io.Serializable;

public interface OrderDetailsRepo extends JpaRepository<OrderDetail, OrderDetail_PK> {
}
