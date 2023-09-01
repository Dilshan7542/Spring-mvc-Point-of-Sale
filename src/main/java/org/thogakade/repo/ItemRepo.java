package org.thogakade.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.thogakade.entity.Item;

public interface ItemRepo extends JpaRepository<Item,String> {

}
