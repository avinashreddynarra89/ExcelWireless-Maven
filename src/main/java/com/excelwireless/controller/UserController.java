package com.excelwireless.controller;


import com.excelwireless.bl.UserManager;
import com.excelwireless.dto.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

/**
 * Created by asp5045 on 1/8/17.
 */

@RestController
@RequestMapping("")
@CrossOrigin(origins = "https://firstproject-159400.appspot.com")
public class UserController {

    @Autowired
    UserManager userManager;

    @RequestMapping(value = "/getUserLoginDetails", method = RequestMethod.GET)
    public UserLogin getUserLoginDetails(@RequestParam String username, @RequestParam String password) throws SQLException {

        return userManager.getUserLoginDetails(username,password);

    }
}
