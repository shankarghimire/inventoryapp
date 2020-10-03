package com.sheridancollege.ghimirsh.springbootinventoryapp.controllers;

import com.sheridancollege.ghimirsh.springbootinventoryapp.model.Product;
import com.sheridancollege.ghimirsh.springbootinventoryapp.service.ProductService;
import org.hibernate.metamodel.spi.MetamodelImplementor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping("/new")
    public String goNewProduct(Model model){
        Product product = new Product();
        model.addAttribute("product",product);
        return "newProduct";
    }

    @RequestMapping(value="/save", method= RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product){
        productService.save(product);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductForm(@PathVariable(name="id") Long id){
        ModelAndView modelAndView = new ModelAndView("editProduct");
        Product product = productService.get(id);
        modelAndView.addObject("product",product);
        return modelAndView;
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name="id") Long id){
        productService.delete(id);
        return  "redirect:/";
    }
}
