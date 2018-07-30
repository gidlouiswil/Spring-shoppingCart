package com.gidlouiswil.shoppingcart.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Cart
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "cart")
    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts()

    {
        return products;
    }

    public void setProducts(List<Product> products)
    {
        this.products = products;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Objects.equals(id, cart.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }

}
