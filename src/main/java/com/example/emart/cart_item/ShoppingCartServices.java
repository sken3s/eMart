package com.example.emart.cart_item;

import com.example.emart.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServices {

    @Autowired
    private CartItemRepository cartRepo;
    public List<CartItem> listCartItems(User user){
        return cartRepo.findByUser(user);
    }

}
