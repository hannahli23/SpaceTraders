package com.cosmiccoders.spacetraders.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.cosmiccoders.spacetraders.R;

/**
 * class that configures market page
 */
public class MarketPlace extends AppCompatActivity{

    @Override
    /*
      This function creates the planets and universe
      @param savedInstanceState The current state
     */

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.marketplace);
    }

    /**
     * Moves to buy page when buy button is pressed
     * @param view current view
     */
    public void onBuy(View view) {
        Button btn = findViewById(R.id.buyPageButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MarketPlace.this, Buy.class));
            }
        });
    }

    /**
     * Moves to sell page when sell button is pressed
     * @param view current view
     */
    public void onSell(View view) {
        Button btn = findViewById(R.id.sellPageButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MarketPlace.this, Sell.class));
            }
        });
    }
}
