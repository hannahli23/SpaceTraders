package com.cosmiccoders.spacetraders.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.cosmiccoders.spacetraders.R;

public class MarketPlace extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.marketplace);
    }

    public void onBuy(View view) {
        Button btn = (Button) findViewById(R.id.buyPageButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MarketPlace.this, Buy.class));
            }
        });
    }

    public void onSell(View view) {
        Button btn = (Button) findViewById(R.id.sellPageButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MarketPlace.this, Sell.class));
            }
        });
    }
}
