package com.example.emart.cart_item;

import com.example.emart.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Integer> {

    public List<CartItem> findByUser(User user);
}
