package com.chekvend.test;


import android.test.AndroidTestCase;

import com.chekvend.Constants;
import com.chekvend.Model.Product;

public class ProductTest extends AndroidTestCase {

    public void testValidProductValues() {
        Product product = new Product(Constants.COLA);
        assertEquals("Cola", product.getName());
    }

}