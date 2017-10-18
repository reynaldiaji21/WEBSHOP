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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author user
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService ps;
    
////    @RequestMapping()
////    public String product(Model model){
////        model.addAttribute("pro","")
////    return "product";
//    }
    List<Product> keranjang = new ArrayList<>();
    
    @RequestMapping("/all")
    public String showAllProduct(HttpSession session){
    List<Product> product=ps.findAll();
    session.setAttribute("product",product);
    session.setAttribute("keranjang",keranjang);
    return "product";
    }
    
    @RequestMapping ("/{id}")
    public String showDetailProduct(@PathVariable Integer id,HttpSession session){
    Product product= ps.findById(id);
    session.setAttribute("prod",product);
    return "productDetail";
    }
    
    @RequestMapping("/addCarts")
    public String addToCarts(HttpSession session){
    List<Product> barang= (List<Product>) session.getAttribute("keranjang");
    barang.add((Product) session.getAttribute("prod"));
    session.removeAttribute("prod");
    return "keranjang";
    }
    
}
