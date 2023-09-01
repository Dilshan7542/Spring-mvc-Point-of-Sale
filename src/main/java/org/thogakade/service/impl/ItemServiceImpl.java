package org.thogakade.service.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thogakade.dto.ItemDTO;
import org.thogakade.entity.Item;
import org.thogakade.repo.ItemRepo;
import org.thogakade.service.ItemService;

import java.util.List;
@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemRepo itemRepo;
    @Autowired
    ModelMapper mapper;
    @Override
    public ItemDTO saveItem(ItemDTO itemDTO) {
        if (itemRepo.existsById(itemDTO.getItemCode())) {
            throw new RuntimeException("Item is already exists..!");
        }
        itemRepo.save(mapper.map(itemDTO, Item.class));
        return itemDTO;
    }

    @Override
    public ItemDTO updateItem(ItemDTO itemDTO) {
        if (!itemRepo.existsById(itemDTO.getItemCode())) {
            throw new RuntimeException("Item is not exists..!");
        }
        itemRepo.save(mapper.map(itemDTO, Item.class));
        return itemDTO;
    }

    @Override
    public boolean deleteItem(String id) {
        if (!itemRepo.existsById(id)) {
            throw new RuntimeException("Item is not exists..!");
        }
        itemRepo.deleteById(id);
        return !itemRepo.existsById(id);
    }

    @Override
    public ItemDTO searchItem(String id) {
        if (!itemRepo.existsById(id)) {
            throw new RuntimeException("Item is not exists..!");
        }
        return mapper.map(itemRepo.findById(id).get(),ItemDTO.class);
    }

    @Override
    public List<ItemDTO> getAllItem() {
        return mapper.map(itemRepo.findAll(),new TypeToken<List<ItemDTO>>(){}.getType());
    }
}
