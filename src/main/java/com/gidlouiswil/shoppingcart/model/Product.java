package com.gidlouiswil.shoppingcart.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private double unit_price;
    private int quantity;

    public Product()
    {

    }

    public Product(String name, String description, double unit_price, int quantity)
    {
        this.name = name;
        this.description = description;
        this.unit_price = unit_price;
        this.quantity = quantity;
    }

    @ManyToOne
    @JoinTable(name="cart_products", joinColumns = @JoinColumn(name = "product_id"),
    inverseJoinColumns = @JoinColumn(name = "cart_id"))
    private Cart cart;

    public Cart getCart()
    {
        return cart;
    }

    public void setCart(Cart cart)
    {
        this.cart = cart;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public double getUnit_price()
    {
        return unit_price;
    }

    public void setUnit_price(double unit_price)
    {
        this.unit_price = unit_price;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }

    @Override
    public String toString()
    {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", unit_price=" + unit_price +
                ", quantity=" + quantity +
                '}';
    }
}
