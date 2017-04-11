package com.excelwireless.controller;


import com.excelwireless.bl.WebMenuManager;
import com.excelwireless.dto.MenuDto;
import com.excelwireless.dto.WebBrandDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by asp5045 on 11/17/16.
 */

@RestController
@RequestMapping("")
@CrossOrigin(origins = {"*"})
public class WebMenuController {

    @Autowired
    WebMenuManager webMenuManager;

    @RequestMapping(value = "/getWebMenu", method = RequestMethod.GET)
    public MenuDto getWebMenu() {
        return webMenuManager.getWebMenu();
    }

    @RequestMapping(value = "/getSideBardForParts", method = RequestMethod.GET)
    public List<WebBrandDto> getSideBardForParts() {
        return webMenuManager.getSideBardForParts();
    }



}
