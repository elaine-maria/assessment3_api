package co.newlabs.service;

import co.newlabs.dto.CustomerDTO;
import co.newlabs.repository.CustomerRepository;
import co.newlabs.repository.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {


    private CustomerRepository repository;

    @Autowired
    public CustomerService(CustomerRepository r) {
        this.repository = r;
    }


    public CustomerDTO getCustomerByOrderId(int orderid) {
        CustomerEntity c = repository.getCustomerByOrderId(orderid);
        return new CustomerDTO(c.getId(), c.getName(), c.getLat(), c.getLon());
    }

    public void updateOrderStatus(int orderid) {
        repository.updateOrderStatus(orderid);
    }

}
