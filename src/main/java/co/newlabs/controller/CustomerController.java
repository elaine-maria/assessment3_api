package co.newlabs.controller;

import co.newlabs.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService service;

    @Autowired
    public CustomerController(CustomerService s) {
        this.service = s;
    }


    @GetMapping(value = "/orderid/{orderid}", produces = "application/json")
    public ResponseEntity getCustomerByOrderId(@PathVariable int orderid) {
        log.info("order received in api");
        return ResponseEntity.status(HttpStatus.OK).body(service.getCustomerByOrderId(orderid));
    }

    @PutMapping(value = "/id/{id}", produces = "application/json")
    public ResponseEntity updateOrderStatus(@PathVariable int id) {
        service.updateOrderStatus(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}
