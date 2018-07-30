package com.gidlouiswil.shoppingcart.bootstrap;

import com.gidlouiswil.shoppingcart.model.Cart;
import com.gidlouiswil.shoppingcart.model.Product;
import com.gidlouiswil.shoppingcart.repositories.CartRepository;
import com.gidlouiswil.shoppingcart.repositories.ProductRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>
{
    private CartRepository cartRepository;
    private ProductRepository productRepository;

    public DevBootstrap(CartRepository cartRepository, ProductRepository productRepository)
    {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent)
    {
        initData();
    }

    private void initData()
    {
        Product product1 = new Product("product 1", "Ut vulputate lobortis sapien ac condimentum.", 10, 1);
        Product product2 = new Product("product 2", "Donec neque ipsum, convallis ac ex in, mollis lobortis ipsum.", 20, 2);
        Product product3 = new Product("product 3", "Quisque at rutrum neque, tempus semper lacus. In ut commodo urna, volutpat tristique ante.", 30, 3);

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);

        Cart cart = new Cart();

        cartRepository.save(cart);
    }
}
