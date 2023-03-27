package com.codeup.codeupspringblog.controllers.model;

public class Product {
    private long id;
    private String name;
    private int priceInCents;

   public Product(){

   }

    public Product(long id, String name, int priceInCents) {
        this.id = id;
        this.name = name;
        this.priceInCents = priceInCents;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getPriceInCents() {
        return priceInCents;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPriceInCents(int priceInCents) {
        this.priceInCents = priceInCents;
    }
}
