package com.excelwireless.controller;


import com.excelwireless.bl.UserManager;
import com.excelwireless.dto.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by asp5045 on 1/8/17.
 */

@RestController
@RequestMapping("")
@CrossOrigin(origins = {"*"})
public class UserController {

    @Autowired
    UserManager userManager;

    @RequestMapping(value = "/getUserLoginDetails", method = RequestMethod.GET)
    public UserLogin getUserLoginDetails(@RequestParam String username, @RequestParam String password) {

        return userManager.getUserLoginDetails(username,password);

    }
}
