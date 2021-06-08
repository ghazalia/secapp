package com.example.secapp.controller;

import com.example.secapp.product.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * MainPageController
 */
@Controller
public class MainPageController {
    @Autowired
    private ProductService prodService;

    @GetMapping("/product")
    public String listProducts(Model model)
    {
        model.addAttribute("products", prodService.listAllProducts());
        return "product/index";
    }



    
}