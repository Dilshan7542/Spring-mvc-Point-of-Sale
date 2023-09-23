package org.thogakade.service.impl;


import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thogakade.dto.CustomerDTO;
import org.thogakade.entity.Customer;
import org.thogakade.repo.CustomerRepo;
import org.thogakade.service.CustomerService;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    ModelMapper mapper;

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        if(customerRepo.existsById(customerDTO.getCustomerID())){
            throw new RuntimeException("Customer Already Exist...!");
        }
        customerRepo.save(mapper.map(customerDTO, Customer.class));
        return customerDTO;

    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        if(!customerRepo.existsById(customerDTO.getCustomerID())){
            throw new RuntimeException("Customer Not Exist...!");
        }
        customerRepo.save(mapper.map(customerDTO, Customer.class));
        return customerDTO;
    }

    @Override
    public boolean deleteCustomer(String id) {
        if (!customerRepo.existsById(id)) {
            throw new RuntimeException("Customer Already Not Exist...!");
        }
         customerRepo.deleteById(id);
       return !customerRepo.existsById(id);
    }

    @Override
    public CustomerDTO searchCustomer(String id) {
        if(!customerRepo.existsById(id)){
            throw new RuntimeException("Customer Not Exist...!");
        }
        return mapper.map(customerRepo.findById(id).get(),CustomerDTO.class);
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        return mapper.map(customerRepo.findAll(),new TypeToken<List<CustomerDTO>>(){}.getType());
    }
}