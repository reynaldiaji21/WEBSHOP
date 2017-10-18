/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.indocyber.controller;

import com.indocyber.model.Product;
import com.indocyber.service.ProductService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author user
 */
@Controller
@RequestMapping("/keranjangBelanja")
public class CartsController {
    @Autowired
    ProductService service;
    
    @RequestMapping()
    public String keranjang(HttpSession session, Model model){
    List<Product> listProd=(List<Product>) session.getAttribute("keranjang");
    List<Product> products=new ArrayList<>();
        for (Product product : listProd) {
            products.add(service.findById(product.getId()));
        }
        model.addAttribute("product",products);
        
        return "keranjangBelanja";
    }
}
