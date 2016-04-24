package com.chekvend.test;

import android.test.AndroidTestCase;

import com.chekvend.Constants;
import com.chekvend.Model.Coin;

public class CoinTest extends AndroidTestCase {

    public void testValidPennyValues() {
        Coin penny = new Coin(Constants.PENNY);
        assertFalse(penny.isValidCoin());
    }

    public void testValidNickelValues() {
        Coin nickel = new Coin(Constants.NICKEL);
        assertEquals(nickel.getValue(), 0.05, 0);
    }

    public void testValidDimeValues() {
        Coin dime = new Coin(Constants.DIME);
        assertEquals(dime.getValue(), 0.1, 0);
    }

    public void testValidQuarterValues() {
        Coin quarter = new Coin(Constants.QUARTER);
        assertEquals(quarter.getValue(), 0.25, 0);
    }

    public void testIsValidCoin() {
        Coin silverDollar = new Coin(50);
        assertFalse(silverDollar.isValidCoin());
    }
}
