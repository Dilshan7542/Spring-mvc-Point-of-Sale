package org.thogakade.service;

import org.thogakade.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    ItemDTO saveItem(ItemDTO ItemDTO);
    ItemDTO updateItem(ItemDTO ItemDTO);
    boolean deleteItem(String id);
    ItemDTO searchItem(String id);
    List<ItemDTO> getAllItem();
}
