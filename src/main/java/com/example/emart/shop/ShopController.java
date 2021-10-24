package com.example.emart.shop;

import com.example.emart.product.*;
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

     @Autowired
     private ShoeService shoeService;

        @GetMapping("/shop")
        public String showProductList(Model model){
            List<Product> listProducts = service.listAll();
            model.addAttribute("listProducts",listProducts);

            return "shop";
        }

    @GetMapping("/shop/shoe")
    public String showShoeList(Model model){
        List<Shoe> listShoes = shoeService.listAll();
        model.addAttribute("listShoes",listShoes);

        return "shop_shoes";
    }



}
