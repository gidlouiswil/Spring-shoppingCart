package com.gidlouiswil.shoppingcart.controllers;

import com.gidlouiswil.shoppingcart.model.Cart;
import com.gidlouiswil.shoppingcart.model.Product;
import com.gidlouiswil.shoppingcart.repositories.CartRepository;
import com.gidlouiswil.shoppingcart.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController
{
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartRepository cartRepository;

    @RequestMapping(value={"", "/", "products_catalog"})
    public String getProducts(Model model)
    {
        model.addAttribute("products", productRepository.findAll());
        return "products_catalog";
    }

    @RequestMapping("product_details/{id}")
    public String getProduct(@PathVariable Long id,  Model model)
    {
        model.addAttribute("product", productRepository.findById(id).get());
        return "product_details";
    }

    @RequestMapping("add_to_cart/{id}")
    public String addProductToCart(@PathVariable Long id,  Model model)
    {
        Cart cart = null;
        Iterable<Cart> carts = cartRepository.findAll();

        for (Cart a_cart:carts)
        {
            cart = a_cart;
        }

        Product product = productRepository.findById(id).get();

        product.setCart(cart);

        productRepository.save(product);
        cartRepository.save(cart);

        model.addAttribute("products", productRepository.findAll());
        return "products_catalog";
    }
}
