package com.change.projects.book.service;

import com.change.projects.book.model.Cart;
import com.change.projects.book.repo.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CartService {
    @Autowired
    CartRepo repo;
    public void save(Cart cart){
        repo.save(cart);
    }

    public int ifExists(String username, int productid){
        return repo.ifExists(username,productid);
    }
    @Transactional
    public void update(String username, int productid, int q){
        repo.update(username,productid,q);
    }

    public List<Cart> getCart (String username){
        return repo.getCart(username);
    }
    public double getTotal(String username){
        return repo.getTotal(username);
    }
    public int getCartCount(String username){
        return repo.getCartCount(username);
    }

    @Transactional
    public void clearCart(String username){
       repo.clearCart(username);
   }


}
