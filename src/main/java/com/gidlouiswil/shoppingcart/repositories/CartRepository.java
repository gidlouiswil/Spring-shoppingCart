package com.gidlouiswil.shoppingcart.repositories;

import com.gidlouiswil.shoppingcart.model.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Long>
{
}
