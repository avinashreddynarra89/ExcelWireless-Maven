package com.excelwireless.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by asp5045 on 1/8/17.
 */

@RestController
@RequestMapping("")
@CrossOrigin(origins = {"*"})
public class UserController {

//    @Autowired
//    UserManager userManager;
//
//    @RequestMapping(value = "/getUserLoginDetails", method = RequestMethod.GET)
//    public UserLogin getUserLoginDetails(@RequestParam String username, @RequestParam String password) {
//
//        return userManager.getUserLoginDetails(username,password);
//
//    }
}
