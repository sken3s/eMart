package com.example.emart.cart_item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShoppingCartController {

    @Autowired
    private ShoppingCartServices cartServices;

    @GetMapping("/cart")
    public String showShoppingCart(Model model, @AuthenticationPrincipal Authentication authentication){
        return "shopping_cart";
    }
}
