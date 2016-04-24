package com.chekvend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.chekvend.Model.Coin;
import com.chekvend.Model.Product;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private Machine machine;
    private TextView inserted_total, return_total,
            quantity_chips, quantity_cola, quantity_candy, display_message;
    DecimalFormat df;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        df = new DecimalFormat("0.00");

        machine = new Machine();
        setUpStaticUIElements();
        setUpDynamicUIElements();
        updateQuantities();
    }


    public void updateTotals() {
        double value = machine.getTotalInserted();
        inserted_total.setText(String.format(
                getResources().getString(R.string.money_format), df.format(value)));
        value = machine.getTotalReturning();
        return_total.setText(String.format(
                getResources().getString(R.string.money_format), df.format(value)));
    }

    public void updateQuantities() {
        quantity_chips.setText(String.valueOf(machine.getChips()));
        quantity_cola.setText(String.valueOf(machine.getColas()));
        quantity_candy.setText(String.valueOf(machine.getCandies()));
    }

    public void setUpDynamicUIElements() {
        return_total = (TextView) findViewById(R.id.return_total);
        inserted_total = (TextView) findViewById(R.id.display_inserted);
        display_message = (TextView) findViewById(R.id.display_message);
        quantity_chips = (TextView) findViewById(R.id.quantity_chips);
        quantity_cola = (TextView) findViewById(R.id.quantity_cola);
        quantity_candy = (TextView) findViewById(R.id.quantity_candy);
    }

    public void setUpStaticUIElements() {
        ImageView penny = (ImageView) findViewById(R.id.penny);
        ImageView nickel = (ImageView) findViewById(R.id.nickel);
        ImageView dime = (ImageView) findViewById(R.id.dime);
        ImageView quarter = (ImageView) findViewById(R.id.quarter);
        ImageView golden = (ImageView) findViewById(R.id.golden);
        Button return_coins = (Button) findViewById(R.id.return_coins);
        Button select_chips = (Button) findViewById(R.id.button_chips);
        Button select_cola = (Button) findViewById(R.id.button_cola);
        Button select_candy = (Button) findViewById(R.id.button_candy);

        penny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                machine.insertCoin(new Coin(Constants.PENNY));
                updateTotals();
                display_message.setText(R.string.insert_coins);
            }
        });

        nickel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                machine.insertCoin(new Coin(Constants.NICKEL));
                updateTotals();
                display_message.setText(R.string.insert_coins);
            }
        });

        dime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                machine.insertCoin(new Coin(Constants.DIME));
                updateTotals();
                display_message.setText(R.string.insert_coins);
            }
        });

        quarter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                machine.insertCoin(new Coin(Constants.QUARTER));
                updateTotals();
                display_message.setText(R.string.insert_coins);
            }
        });

        golden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                machine.insertCoin(new Coin(Constants.GOLDEN_DOLLAR));
                updateTotals();
                display_message.setText(R.string.insert_coins);
            }
        });

        select_candy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product candy = new Product(Constants.CANDY);

                if (!machine.haveEnoughToPurchase(candy))
                    display_message.setText(String.format(
                            getResources().getString(R.string.price), candy.priceToString()));
                else if (!machine.isProductInStock(candy))
                    display_message.setText(R.string.sold_out);
                else {
                    machine.purchase(candy);
                    display_message.setText(R.string.thank_you);
                    updateQuantities();
                    updateTotals();
                }
            }
        });

        select_cola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product cola = new Product(Constants.COLA);
                if (!machine.haveEnoughToPurchase(cola)) {
                    display_message.setText(String.format(
                            getResources().getString(R.string.price), cola.priceToString()));
                } else if (!machine.isProductInStock(cola)) {
                    display_message.setText(R.string.sold_out);
                } else {
                    machine.purchase(cola);
                    display_message.setText(R.string.thank_you);
                    updateQuantities();
                    updateTotals();
                }
            }
        });

        select_chips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product chips = new Product(Constants.CHIPS);

                if (!machine.haveEnoughToPurchase(chips)) {
                    display_message.setText(String.format(
                            getResources().getString(R.string.price), chips.priceToString()));
                } else if (!machine.isProductInStock(chips)) {
                    display_message.setText(R.string.sold_out);
                } else {
                    machine.purchase(chips);
                    display_message.setText(R.string.thank_you);
                    updateQuantities();
                    updateTotals();
                }
            }
        });

        return_coins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                machine.returnAllCoins();
                updateTotals();
                display_message.setText(R.string.insert_coins);
            }
        });
    }


}
