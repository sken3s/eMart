package com.example.emart.shop;

import com.example.emart.product.Product;
import com.example.emart.product.ProductNotFoundException;
import com.example.emart.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ShopController {


     @Autowired
        private ProductService service;

        @GetMapping("/shop")
        public String showUserList(Model model){
            List<Product> listProducts = service.listAll();
            model.addAttribute("listProducts",listProducts);
            return "shop";
        }




}
