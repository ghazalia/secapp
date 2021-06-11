package com.example.secapp.controller;

import com.example.secapp.product.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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
    public String listProducts(Model model, Authentication authentication)
    {
        model.addAttribute("userLogged", authentication.getName());
        model.addAttribute("products", prodService.listAllProducts());
        return "product/index";
    }

    @GetMapping("/product/new")
//    pre-authorize
//    post-authorize
    public String productForm(Model model) {
        return "product/create";
    }



    
}