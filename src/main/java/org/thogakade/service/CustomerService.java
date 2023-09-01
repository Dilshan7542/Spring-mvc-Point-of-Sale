package org.thogakade.service;

import org.thogakade.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    CustomerDTO updateCustomer(CustomerDTO customerDTO);
    boolean deleteCustomer(String id);
    CustomerDTO searchCustomer(String id);
    List<CustomerDTO> getAllCustomer();

}
