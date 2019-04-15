package com.cosmiccoders.spacetraders.views;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import android.view.View;
import android.os.Bundle;


import com.cosmiccoders.spacetraders.R;
import com.cosmiccoders.spacetraders.entity.Market;
import com.cosmiccoders.spacetraders.viewmodels.EditAddPlayerViewModel;
import com.cosmiccoders.spacetraders.viewmodels.EditShipViewModel;
import com.cosmiccoders.spacetraders.viewmodels.GetAddCargoHoldViewModel;
import com.cosmiccoders.spacetraders.viewmodels.GetSetPlanetViewModel;

import java.util.Map;

/**
 * This class represents the buying activity within the market
 */
public class Buy extends AppCompatActivity {
    private EditShipViewModel shipViewModel;
    private EditAddPlayerViewModel playerViewModel;
    private GetAddCargoHoldViewModel cargoHoldViewModel;

    private Market market;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buy);


        playerViewModel = ViewModelProviders.of(this).get(EditAddPlayerViewModel.class);
        GetSetPlanetViewModel planetViewModel =
                ViewModelProviders.of(this).get(GetSetPlanetViewModel.class);
        shipViewModel = ViewModelProviders.of(this).get(EditShipViewModel.class);
        cargoHoldViewModel = ViewModelProviders.of(this).get(GetAddCargoHoldViewModel.class);

        market = planetViewModel.getMarket();
        changePrices();
    }

    /**
     * Changes the displayed prices of all goods
     */
    public void changePrices() {
        TextView text;
        text = findViewById(R.id.w_price);
        changeText(text, "Water");

        text = findViewById(R.id.fa_price);
        changeText(text, "Firearms");

        text = findViewById(R.id.g_price);
        changeText(text, "Games");

        text = findViewById(R.id.n_price);
        changeText(text, "Narcotics");

        text = findViewById(R.id.r_price);
        changeText(text, "Robots");

        text = findViewById(R.id.fur_price);
        changeText(text, "Furs");

        text = findViewById(R.id.o_price);
        changeText(text, "Ore");

        text = findViewById(R.id.food_price);
        changeText(text, "Food");

        text = findViewById(R.id.m_price);
        changeText(text, "Medicine");
    }

    /**
     * Finds the price of the input good, converts it to a string, and displays it to the user.
     * If the good is not found, tells the user that the good is unavailable.
     * @param text the text that you are displaying back to the user
     * @param item the good whose cost to display
     */
    public void changeText(TextView text, String item) {
        String price;
        Map<String, Integer> goodList = market.getGoodList();
        if(goodList.containsKey(item)) {
            price = market.getPrice(item) + "";
            text.setText(item + " costs:" + price);
        } else {
            text.setText("This item is unavailable");
        }
    }

    /**
     * Carries out the purchase made by a player
     * @param view the current view
     */
    public void buy(View view) {
        Button change = findViewById(view.getId());

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int price = 0;
                switch(v.getId()){
                    case R.id.water:
                        buyHelper("Water");
                        break;
                    case R.id.robots:
                        buyHelper("Robots");
                        break;
                    case R.id.food:
                        buyHelper("Food");
                        break;
                    case R.id.games:
                        buyHelper("Games");
                        break;
                    case R.id.firearms:
                        buyHelper("Firearms");
                        break;
                    case R.id.ore:
                        buyHelper("Ore");
                        break;
                    case R.id.narcotics:
                        buyHelper("Narcotics");
                        break;
                    case R.id.furs:
                        buyHelper("Furs");
                        break;
                    case R.id.medicine:
                        buyHelper("Medicine");
                        break;

                }
            }
        });
    }

    /**
     * Helper method for main buy method
     * @param item the item to buy
     */
    public void buyHelper(String item) {
        Map<String, Integer> goodList = market.getGoodList();
        if(goodList.containsKey(item)) {
            int price = goodList.get(item);
            if(performChecks(1, price)) {
                playerViewModel.pay(price);
                cargoHoldViewModel.putItem(item, 1);
                Log.i("Test buy", cargoHoldViewModel.toString());
                Log.i("Testing sell", playerViewModel.getCurrency()+"");
            } else {
                Log.i("Test buy", "Oh no something went wrong :(((");
            }
        }
    }

    /**
     * Checks to see if the player has enough money and space in their cargo to buy the item
     * @param itemNum the number of the item to buy
     * @param amount the price of the item
     */
    private boolean performChecks(int itemNum, int amount) {
        boolean one = playerViewModel.checkCurrency(amount);
        boolean two = cargoHoldViewModel.putCheck(itemNum);
        if(!one) {
            Log.i("Buy performance check", "You don't have enough money!!!");
        }
        if(!two) {
            Log.i("Buy performance check", "You don't have enough space in cargo!!!");
        }
        return one && two;
    }
}
