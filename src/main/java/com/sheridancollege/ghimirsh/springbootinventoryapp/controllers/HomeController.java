package com.sheridancollege.ghimirsh.springbootinventoryapp.controllers;

import com.sheridancollege.ghimirsh.springbootinventoryapp.model.Product;
import com.sheridancollege.ghimirsh.springbootinventoryapp.service.ProductService;
import org.hibernate.metamodel.spi.MetamodelImplementor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;
    @RequestMapping("/")
    public String goHome(Model model){
        List<Product> listProducts = productService.listAll();
        model.addAttribute("listProducts",listProducts);
        return "index";
    }
}
