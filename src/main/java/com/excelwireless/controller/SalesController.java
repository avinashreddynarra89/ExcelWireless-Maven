package com.excelwireless.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
@CrossOrigin(origins = {"*"})
public class SalesController {

//    @Autowired
//    SalesManager salesManager;
//
//    @RequestMapping(value = "/addTransaction", method = RequestMethod.POST, consumes = "application/json")
//    public void addTransactionToDB(@RequestBody TransactionDto transactionDto)
//    {
//        salesManager.addTransaction(transactionDto);
//    }
//
//    @RequestMapping(method = RequestMethod.POST, value = "/addTransactionLineItem", consumes = "application/json")
//    public void addTransactionLineItem(@RequestBody TransactionLineItemDto product)
//    {
//        salesManager.addTransactionLineItemToDB(product);
//    }
//
//    @RequestMapping(method = RequestMethod.GET, value = "/getTransactionLineItem", produces = "application/json")
//    public List<TransactionLineItemDto> getTransactionLineItem(@RequestParam String phoneNo)
//    {
//       return salesManager.getTransactionLineItemToDB(phoneNo);
//    }
//
//    @RequestMapping(method = RequestMethod.POST, value = "/deleteTransactionLineItem")
//    public boolean deleteTransactionLineItem(@RequestParam String phoneNo, @RequestParam String productNo)
//    {
//        return salesManager.deleteTransactionLineItem(phoneNo,productNo);
//    }
//
//    @RequestMapping(method = RequestMethod.POST, value = "/updateTransactionLineItem")
//    public boolean updateTransactionLineItem(@RequestParam String phoneNo, @RequestParam String productNo, @RequestParam int quantity)
//    {
//        return salesManager.updateTransactionLineItem(phoneNo,productNo,quantity);
//    }
//
//    @RequestMapping(method = RequestMethod.GET, value = "/getLastTransactionId", produces = "application/json")
//    public int getTransactionLineItem()
//    {
//        return salesManager.getLastTransactionId();
//    }
//
//    @RequestMapping(method = RequestMethod.POST, value = "/checkoutTransaction")
//    public boolean checkoutTransaction(@RequestBody TransactionDto transactionDto)
//    {
//        return salesManager.checkoutTransaction(transactionDto);
//    }
//
//    @RequestMapping(method = RequestMethod.POST, value = "/checkoutTransactionLineItem")
//    public boolean checkoutTransactionLineItem(@RequestBody List<TransactionLineItemDto> transactionLineItemDto)
//    {
//        return salesManager.checkoutTransactionLineItem(transactionLineItemDto);
//    }
//
//    //This needs to be done when customer place the final order cause i am storing unconfirmed transaction details into temp table so now after final order this details need to be deleted.
//    @RequestMapping(method = RequestMethod.POST, value = "/deleteAllTransactionLineItem")
//    public boolean deleteTransactionLineItemsForFinalOrder(@RequestParam String customerPhoneNo)
//    {
//        return salesManager.deleteTransactionLineItemsForFinalOrder(customerPhoneNo);
//    }


}
