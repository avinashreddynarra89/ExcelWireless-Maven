package com.excelwireless.controller;


import com.excelwireless.bl.CustomerManager;
import com.excelwireless.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
@CrossOrigin(origins = {"*"})
public class CustomerController {

    @Autowired
    CustomerManager customerManager;

    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST, consumes = "application/json")
    public void addCustomer(@RequestBody CustomerDto customerDto) {
        customerManager.addCustomerToDB(customerDto);
    }

//    @RequestMapping(value = "/sendEmail", method = RequestMethod.POST, consumes = "application/json")
//    public void sendEmail(@RequestBody CustomerDto customerDto) {
//        customerManager.sendEmail(customerDto);
//    }


}