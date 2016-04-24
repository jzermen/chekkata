package com.chekvend.Model;

import com.chekvend.Constants;

public class Coin {

    public final double value;
    public final String name;
    public final boolean isValid;

    public Coin(double weight) {
        if (weight == Constants.PENNY) {
            this.value = 0.01;
            this.name = "Penny";
            this.isValid = false;

        } else if (weight == Constants.NICKEL) {
            this.value = 0.05;
            this.name = "Nickel";
            this.isValid = true;
        } else if (weight == Constants.DIME) {
            this.value = 0.10;
            this.name = "Dime";
            this.isValid = true;
        } else if (weight == Constants.QUARTER) {
            this.value = 0.25;
            this.name = "Quarter";
            this.isValid = true;
        } else if (weight == Constants.GOLDEN_DOLLAR) {
            this.value = 1.0;
            this.name = "Golden Dollar";
            this.isValid = false;
        } else {
            this.value = 0;
            this.name = null;
            this.isValid = false;
        }
    }

    public double getValue() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }

    public boolean isValidCoin() {
        return this.isValid;
    }
}
