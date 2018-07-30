package com.gidlouiswil.shoppingcart.repositories;

import com.gidlouiswil.shoppingcart.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long>
{
}
