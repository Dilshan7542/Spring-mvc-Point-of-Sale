package org.thogakade.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.thogakade.entity.Customer;


public interface CustomerRepo extends JpaRepository< Customer,String> {

}
