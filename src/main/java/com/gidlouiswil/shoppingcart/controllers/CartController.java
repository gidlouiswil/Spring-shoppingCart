package com.gidlouiswil.shoppingcart.controllers;

import com.gidlouiswil.shoppingcart.model.Cart;
import com.gidlouiswil.shoppingcart.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CartController
{
    @Autowired
    private CartRepository cartRepository;

    @RequestMapping("cart")
    public String getProducts(Model model)
    {
        Cart cart = null;
        Iterable<Cart> carts = cartRepository.findAll();

        for (Cart a_cart:carts)
        {
            cart = a_cart;
        }

        model.addAttribute("products", cart.getProducts());
        return "cart";
    }
}
