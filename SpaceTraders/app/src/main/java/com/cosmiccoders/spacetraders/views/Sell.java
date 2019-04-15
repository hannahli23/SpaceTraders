package com.cosmiccoders.spacetraders.views;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import android.view.View;
import android.os.Bundle;


import com.cosmiccoders.spacetraders.R;
import com.cosmiccoders.spacetraders.entity.CargoHold;
import com.cosmiccoders.spacetraders.entity.Market;
import com.cosmiccoders.spacetraders.viewmodels.EditAddPlayerViewModel;
import com.cosmiccoders.spacetraders.viewmodels.EditShipViewModel;
import com.cosmiccoders.spacetraders.viewmodels.GetAddCargoHoldViewModel;
import com.cosmiccoders.spacetraders.viewmodels.GetSetPlanetViewModel;

public class Sell extends AppCompatActivity {
    private EditShipViewModel shipViewModel;
    private EditAddPlayerViewModel playerViewModel;
    private GetAddCargoHoldViewModel cargoHoldViewModel;

    private Market market;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sell);

        playerViewModel = ViewModelProviders.of(this).get(EditAddPlayerViewModel.class);
        GetSetPlanetViewModel planetViewModel = ViewModelProviders.of(this).get(
                GetSetPlanetViewModel.class);
        shipViewModel = ViewModelProviders.of(this).get(EditShipViewModel.class);
        cargoHoldViewModel = ViewModelProviders.of(this).get(GetAddCargoHoldViewModel.class);
        market = planetViewModel.getPlanet().getMarket();


        changeNum();
    }

    private void changeNum() {
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

    private void changeText(TextView text, String item) {
        int numItem;
        if(market.getCanSell(item)) {
            numItem = cargoHoldViewModel.getNumOfItem(item);
            text.setText("You have " + numItem + " " + item+ "(s)");
        } else {
            text.setText("This item is unavailable for sale");
        }
    }

    public void sell(View view) {
        final Button change = findViewById(view.getId());
        int temp = 0;
        switch(view.getId()) {
            case R.id.water:
               temp = R.id.w_price;
               break;
            case R.id.firearms:
                temp = R.id.fa_price;
                break;
            case R.id.food:
                temp = R.id.food_price;
                break;
            case R.id.furs:
                temp = R.id.fur_price;
                break;
            case R.id.robots:
                temp = R.id.r_price;
                break;
            case R.id.narcotics:
                temp = R.id.n_price;
                break;
            case R.id.medicine:
                temp = R.id.m_price;
                break;
            case R.id.games:
                temp = R.id.g_price;
                break;
            case R.id.ore:
                temp = R.id.o_price;
                break;

        }
        final TextView changeText = findViewById(temp);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.water:
                        sellHelper(changeText, "Water");
                        break;
                    case R.id.robots:
                        sellHelper(changeText, "Robots");
                        break;
                    case R.id.food:
                        sellHelper(changeText, "Food");
                        break;
                    case R.id.games:
                        sellHelper(changeText, "Games");
                        break;
                    case R.id.firearms:
                        sellHelper(changeText, "Firearms");
                        break;
                    case R.id.ore:
                        sellHelper(changeText, "Ore");
                        break;
                    case R.id.narcotics:
                        sellHelper(changeText, "Narcotics");
                        break;
                    case R.id.furs:
                        sellHelper(changeText, "Furs");
                        break;
                    case R.id.medicine:
                        sellHelper(changeText, "Medicine");
                        break;

                }
            }
        });
    }

    private void sellHelper(TextView changeText, String item) {
        int price;
        if(performChecks(1, item)) {
            price = market.getPrice(item);
            playerViewModel.getPaid(price);
            cargoHoldViewModel.takeItem(item, 1);

            setResults(item, changeText);
        }
    }

    private void setResults(String item, TextView changeText) {
        Log.i("Testing sell", playerViewModel.getCurrency()+"");
        Log.i("Testing sell", cargoHoldViewModel.toString());

        int num = cargoHoldViewModel.getNumOfItem(item);
        changeText.setText("You have " + num + " " +item+ "(s)");
    }

    private boolean performChecks(int itemNum, String good) {
        boolean one = cargoHoldViewModel.takeCheck(good, itemNum);
        boolean two = market.getCanSell(good);
        if(!one) {
            Log.i("Performance check", ":(( You do not have enough " + good);
        }
        if(!two) {
            Log.i("Sell performance check", "You cannot sell this item!!!");
        }
        return one && two;
    }
}