package com.chekvend.Model;

import com.chekvend.Constants;

public class Product {

    private final char id;
    private final String name;
    private final double price;

    public Product(char id) {
        this.id = id;

        if (id == Constants.COLA) {
            this.name = "Cola";
            this.price = 1.0;
        } else if (id == Constants.CHIPS) {
            this.name = "Chips";
            this.price = 0.5;
        } else if (id == Constants.CANDY) {
            this.name = "Dime";
            this.price = 0.65;
        } else {
            this.name = null;
            this.price = 0;
        }
    }

    public char getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String priceToString() {
        return "$" + price;
    }

}
