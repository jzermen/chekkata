package com.chekvend.Model;

import com.chekvend.Constants;
import com.chekvend.Model.Coin;
import com.chekvend.Model.Product;

public class Machine {

    private double totalInserted;
    private double totalReturning;
    private int chips, colas, candies;
    private double totalChangeInMachine;

    public Machine() {
        this.totalInserted = 0;
        this.totalReturning = 0;
        this.chips = 4;
        this.colas = 1;
        this.candies = 8;
    }

    public double insertCoin(Coin coin) {
        double value = coin.getValue();

        if (coin.isValidCoin()) {
            this.totalInserted += value;
            return value;
        } else {
            this.totalReturning += value;
            return Constants.INVALID_COIN;
        }
    }

    public boolean haveEnoughToPurchase(Product product) {
        return product.getPrice() <= totalInserted;
    }

    public boolean willNeedChange(Product product) {
        return product.getPrice() < totalInserted;
    }

    public boolean purchase(Product product) {
        if (haveEnoughToPurchase(product) && isProductInStock(product)) {
            if (willNeedChange(product))
                totalReturning += totalInserted - product.getPrice();
            totalInserted = 0;
            takeProduct(product);
            return true;
        } else
            return false;
    }

    public double collectChange() {
        double change = totalReturning;
        totalReturning = 0;
        return change;
    }

    public double changeNeeded(Product product) {
        return product.getPrice() - totalInserted;
    }

    public void takeProduct(Product product) {
        switch (product.getId()) {
            case Constants.CANDY:
                this.candies -= 1;
                break;
            case Constants.COLA:
                this.colas -= 1;
                break;
            case Constants.CHIPS:
                this.chips -= 1;
                break;
        }
    }

    public void stockProduct(Product product) {
        switch (product.getId()) {
            case Constants.CANDY:
                candies += 1;
                break;
            case Constants.COLA:
                colas += 1;
                break;
            case Constants.CHIPS:
                chips += 1;
                break;
        }
    }

    public boolean isProductInStock(Product product) {
        if (product.getId() == Constants.CHIPS && chips == 0)
            return false;
        else if (product.getId() == Constants.CANDY && candies == 0)
            return false;
        else if (product.getId() == Constants.COLA && colas == 0)
            return false;
        else
            return true;
    }

    public double returnAllCoins() {
        double returning = totalReturning + totalInserted;
        totalReturning = 0;
        totalInserted = 0;
        return returning;
    }

    public double getTotalInserted() {
        return totalInserted;
    }

    public String getTotalInsertedString() {
        return "$" + totalInserted;
    }

    public void setTotalInserted(double totalInserted) {
        this.totalInserted = totalInserted;
    }

    public double getTotalReturning() {
        return totalReturning;
    }

    public void setTotalReturning(double totalReturning) {
        this.totalReturning = totalReturning;
    }

    public int getChips() {
        return chips;
    }

    public void setChips(int chips) {
        this.chips = chips;
    }

    public int getColas() {
        return colas;
    }

    public void setColas(int colas) {
        this.colas = colas;
    }

    public int getCandies() {
        return candies;
    }

    public void setCandies(int candies) {
        this.candies = candies;
    }

}
