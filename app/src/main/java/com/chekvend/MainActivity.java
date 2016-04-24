package com.chekvend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.suitebuilder.TestSuiteBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.chekvend.Model.Coin;
import com.chekvend.Model.Machine;

public class MainActivity extends AppCompatActivity {

    private Machine machine;
    private TextView inserted_total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        machine = new Machine();

        ImageView penny = (ImageView) findViewById(R.id.penny);
        ImageView nickel = (ImageView) findViewById(R.id.nickel);
        ImageView dime = (ImageView) findViewById(R.id.dime);
        ImageView quarter = (ImageView) findViewById(R.id.quarter);
        ImageView golden = (ImageView) findViewById(R.id.golden);
        Button return_coins = (Button) findViewById(R.id.return_coins);
        Button select_chips = (Button) findViewById(R.id.button_chips);
        Button select_cola = (Button) findViewById(R.id.button_cola);
        Button select_candy = (Button) findViewById(R.id.button_candy);
        TextView return_total = (TextView) findViewById(R.id.return_total);
        inserted_total = (TextView) findViewById(R.id.display_inserted);
        TextView display_message = (TextView) findViewById(R.id.display_message);
        TextView quantity_chips = (TextView) findViewById(R.id.quantity_chips);
        TextView quantity_cola = (TextView) findViewById(R.id.quantity_cola);
        TextView quantity_candy = (TextView) findViewById(R.id.quantity_candy);

        penny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                machine.insertCoin(new Coin(Constants.PENNY));
                updateInsertedTotal();
            }
        });

        nickel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                machine.insertCoin(new Coin(Constants.NICKEL));
                updateInsertedTotal();
            }
        });

        dime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                machine.insertCoin(new Coin(Constants.DIME));
                updateInsertedTotal();
            }
        });

        quarter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                machine.insertCoin(new Coin(Constants.QUARTER));
                updateInsertedTotal();
            }
        });

        golden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                machine.insertCoin(new Coin(Constants.GOLDEN_DOLLAR));
                updateInsertedTotal();
            }
        });
    }

    public void updateInsertedTotal() {
        inserted_total.setText(machine.getTotalInsertedString());
    }

}
