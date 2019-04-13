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
import com.cosmiccoders.spacetraders.viewmodels.GetSetPlanetViewModel;

public class Buy extends AppCompatActivity {
    private EditShipViewModel shipViewModel;
    private EditAddPlayerViewModel playerViewModel;

    private Market market;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buy);


        playerViewModel = ViewModelProviders.of(this).get(EditAddPlayerViewModel.class);
        GetSetPlanetViewModel planetViewModel = ViewModelProviders.of(this).get(GetSetPlanetViewModel.class);
        shipViewModel = ViewModelProviders.of(this).get(EditShipViewModel.class);

        market = planetViewModel.getPlanet().getMarket();
        changePrices();
    }

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

    public void changeText(TextView text, String item) {
        String price;
        if(market.getGoodList().containsKey(item)) {
            price = market.getPrice(item) + "";
            text.setText(item + " costs:" + price);
        } else {
            text.setText("This item is unavailable");
        }
    }

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

    public void buyHelper(String item) {
        if(market.getGoodList().containsKey(item)) {
            int price = market.getGoodList().get(item);
            if(performChecks(1, price)) {
                playerViewModel.pay(price);
                shipViewModel.getMainShip().getCargoHold().putItem(item, 1);
                Log.i("Test buy", shipViewModel.getMainShip().getCargoHold().toString());
                Log.i("Testing sell", playerViewModel.getCurrency()+"");
            } else {
                Log.i("Test buy", "Oh no something went wrong :(((");
            }
        }
    }

    private boolean performChecks(int itemNum, int amount) {
        boolean one = playerViewModel.checkCurrency(amount);
        boolean two = shipViewModel.getMainShip().getCargoHold().putCheck(itemNum);
        if(!one) {
            Log.i("Buy performance check", "You don't have enough money!!!");
        }
        if(!two) {
            Log.i("Buy performance check", "You don't have enough space in cargo!!!");
        }
        return one && two;
    }
}
