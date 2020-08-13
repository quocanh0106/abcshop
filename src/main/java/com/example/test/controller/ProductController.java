package com.example.test.controller;


import com.example.test.entity.Product;
import com.example.test.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/")
    public String showProduct(Model model){
        List<Product> listProduct = service.getAllProducts();
        model.addAttribute("listProduct", listProduct);
        return "listProduct";
    }
    @GetMapping("addProduct")
    public String addProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product",product);
        return "addProduct";
    }
    @PostMapping("save")
    public String saveProduct(@ModelAttribute("product") Product product){
        service.save(product);
        return "redirect:/product/";
    }
    @GetMapping("sellProduct/{id}")
    public ModelAndView sellProduct(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("sellProduct");
        Product product = service.get(id);
        mav.addObject("product",product);
        return mav;
    }
    @GetMapping("delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/product/";
    }
}
