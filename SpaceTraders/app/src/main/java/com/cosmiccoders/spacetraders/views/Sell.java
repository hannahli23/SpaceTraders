package com.cosmiccoders.spacetraders.views;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.os.Bundle;


import com.cosmiccoders.spacetraders.R;
import com.cosmiccoders.spacetraders.entity.Market;
import com.cosmiccoders.spacetraders.viewmodels.EditAddPlayerViewModel;
import com.cosmiccoders.spacetraders.viewmodels.EditShipViewModel;
import com.cosmiccoders.spacetraders.viewmodels.GetSetPlanetViewModel;

public class Sell extends AppCompatActivity {
    private EditShipViewModel shipViewModel;
    private EditAddPlayerViewModel playerViewModel;

    private Market market;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sell);

        playerViewModel = ViewModelProviders.of(this).get(EditAddPlayerViewModel.class);
        GetSetPlanetViewModel planetViewModel = ViewModelProviders.of(this).get(GetSetPlanetViewModel.class);
        shipViewModel = ViewModelProviders.of(this).get(EditShipViewModel.class);
        market = planetViewModel.getPlanet().getMarket();

        changeNum();
    }

    public void changeNum() {
        TextView text;
        int numItem = 0;

        text = (TextView) findViewById(R.id.w_price);
        if(market.getCanSell("Water")) {
            numItem = shipViewModel.getMainShip().getCargoHold().getNumOfItem("Water");
            text.setText("You have " + numItem + " water(s)");
        } else {
            text.setText("This item is unavailable for sale");
        }

        text = (TextView) findViewById(R.id.fa_price);
        if(market.getCanSell("Firearms")) {
            numItem = shipViewModel.getMainShip().getCargoHold().getNumOfItem("Firearms");
            text.setText("You have " + numItem + " firearm(s)");
        } else {
            text.setText("This item is unavailable");
        }

        text = (TextView) findViewById(R.id.g_price);
        if(market.getCanSell("Games")) {
            numItem = shipViewModel.getMainShip().getCargoHold().getNumOfItem("Games");
            text.setText("You have " + numItem + " game(s)");
        } else {
            text.setText("This item is unavailable");
        }

        text = (TextView) findViewById(R.id.n_price);
        if(market.getCanSell("Narcotics")) {
            numItem = shipViewModel.getMainShip().getCargoHold().getNumOfItem("Narcotics");
            text.setText("You have " + numItem + " narcotic(s)");
        } else {
            text.setText("This item is unavailable");
        }

        text = (TextView) findViewById(R.id.r_price);
        if(market.getCanSell("Robots")) {
            numItem = shipViewModel.getMainShip().getCargoHold().getNumOfItem("Robots");
            text.setText("You have " + numItem + " robot(s)");
        } else {
            text.setText("This item is unavailable");
        }

        text = (TextView) findViewById(R.id.fur_price);
        if(market.getCanSell("Furs")) {
            numItem = shipViewModel.getMainShip().getCargoHold().getNumOfItem("Furs");
            text.setText("You have " + numItem + " fur(s)");
        } else {
            text.setText("This item is unavailable");
        }

        text = (TextView) findViewById(R.id.o_price);
        if(market.getCanSell("Ore")) {
            numItem = shipViewModel.getMainShip().getCargoHold().getNumOfItem("Ore");
            text.setText("You have " + numItem + " Ore(s)");
        } else {
            text.setText("This item is unavailable");
        }

        text = (TextView) findViewById(R.id.food_price);
        if(market.getCanSell("Food")) {
            numItem = shipViewModel.getMainShip().getCargoHold().getNumOfItem("Food");
            text.setText("You have " + numItem + " food");
        } else {
            text.setText("This item is unavailable");
        }

        text = (TextView) findViewById(R.id.m_price);
        if(market.getCanSell("Medicine")) {
            numItem = shipViewModel.getMainShip().getCargoHold().getNumOfItem("Medicine");
            text.setText("You have " + numItem + " medicine");
        } else {
            text.setText("This item is unavailable");
        }
    }

    public void sell(View view) {
        final Button change = (Button) findViewById(view.getId());
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
        final TextView changeText = (TextView) findViewById(temp);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int price = 0;
                int num = 0;
                switch(v.getId()){
                    case R.id.water:
                        if(performChecks(1, "Water")) {
                            price = market.getPrice("Water");
                            playerViewModel.getPlayer().getPaid(price);
                            shipViewModel.getMainShip().getCargoHold().takeItem("Water", 1);
                            Log.i("Testing sell", playerViewModel.getPlayer().getCurrency()+"");
                            Log.i("Testing sell", shipViewModel.getMainShip().getCargoHold().toString());

                            num = shipViewModel.getMainShip().getCargoHold().getNumOfItem("Water");
                            changeText.setText("You have " + num + " water(s)");
                        }
                        break;
                    case R.id.robots:
                        if(performChecks(1, "Robots")) {
                            price = market.getPrice("Robots");
                            playerViewModel.getPlayer().getPaid(price);
                            shipViewModel.getMainShip().getCargoHold().takeItem("Robots", 1);
                            Log.i("Testing sell", playerViewModel.getPlayer().getCurrency()+"");
                            Log.i("Testing sell", shipViewModel.getMainShip().getCargoHold().toString());

                            num = shipViewModel.getMainShip().getCargoHold().getNumOfItem("Robots");
                            changeText.setText("You have " + num + " robot(s)");
                        }
                        break;
                    case R.id.food:
                        if(performChecks(1, "Food")) {
                            price = market.getPrice("Food");
                            playerViewModel.getPlayer().getPaid(price);
                            shipViewModel.getMainShip().getCargoHold().takeItem("Food", 1);
                            Log.i("Testing sell", playerViewModel.getPlayer().getCurrency()+"");
                            Log.i("Testing sell", shipViewModel.getMainShip().getCargoHold().toString());

                            num = shipViewModel.getMainShip().getCargoHold().getNumOfItem("Food");
                            changeText.setText("You have " + num + " food");
                        }
                        break;
                    case R.id.games:
                        if(performChecks(1, "Games")) {
                            price = market.getPrice("Games");
                            playerViewModel.getPlayer().getPaid(price);
                            shipViewModel.getMainShip().getCargoHold().takeItem("Games", 1);
                            Log.i("Testing sell", playerViewModel.getPlayer().getCurrency()+"");
                            Log.i("Testing sell", shipViewModel.getMainShip().getCargoHold().toString());

                            num = shipViewModel.getMainShip().getCargoHold().getNumOfItem("Games");
                            changeText.setText("You have " + num + " game(s)");
                        }
                        break;
                    case R.id.firearms:
                        if(performChecks(1, "Firearms")) {
                            price = market.getPrice("Firearms");
                            playerViewModel.getPlayer().getPaid(price);
                            shipViewModel.getMainShip().getCargoHold().takeItem("Firearms", 1);
                            Log.i("Testing sell", playerViewModel.getPlayer().getCurrency()+"");
                            Log.i("Testing sell", shipViewModel.getMainShip().getCargoHold().toString());

                            num = shipViewModel.getMainShip().getCargoHold().getNumOfItem("Firearms");
                            changeText.setText("You have " + num + " firearm(s)");
                        }
                        break;
                    case R.id.ore:
                        if(performChecks(1, "Ore")) {
                            price = market.getPrice("Ore");
                            playerViewModel.getPlayer().getPaid(price);
                            shipViewModel.getMainShip().getCargoHold().takeItem("Ore", 1);
                            Log.i("Testing sell", playerViewModel.getPlayer().getCurrency()+"");
                            Log.i("Testing sell", shipViewModel.getMainShip().getCargoHold().toString());

                            num = shipViewModel.getMainShip().getCargoHold().getNumOfItem("Ore");
                            changeText.setText("You have " + num + " ore(s)");
                        }
                        break;
                    case R.id.narcotics:
                        if(performChecks(1, "Narcotics")) {
                            price = market.getPrice("Narcotics");
                            playerViewModel.getPlayer().getPaid(price);
                            shipViewModel.getMainShip().getCargoHold().takeItem("Narcotics", 1);
                            Log.i("Testing sell", playerViewModel.getPlayer().getCurrency()+"");
                            Log.i("Testing sell", shipViewModel.getMainShip().getCargoHold().toString());

                            num = shipViewModel.getMainShip().getCargoHold().getNumOfItem("Narcotics");
                            changeText.setText("You have " + num + " narcotic(s)");
                        }
                        break;
                    case R.id.furs:
                        if(performChecks(1, "Furs")) {
                            price = market.getPrice("Furs");
                            playerViewModel.getPlayer().getPaid(price);
                            shipViewModel.getMainShip().getCargoHold().takeItem("Furs", 1);
                            Log.i("Testing sell", playerViewModel.getPlayer().getCurrency()+"");
                            Log.i("Testing sell", shipViewModel.getMainShip().getCargoHold().toString());

                            num = shipViewModel.getMainShip().getCargoHold().getNumOfItem("Furs");
                            changeText.setText("You have " + num + " fur(s)");
                        }
                        break;
                    case R.id.medicine:
                        if(performChecks(1, "Medicine")) {
                            price = market.getPrice("Medicine");
                            playerViewModel.getPlayer().getPaid(price);
                            shipViewModel.getMainShip().getCargoHold().takeItem("Medicine", 1);
                            Log.i("Testing sell", playerViewModel.getPlayer().getCurrency()+"");
                            Log.i("Testing sell", shipViewModel.getMainShip().getCargoHold().toString());

                            num = shipViewModel.getMainShip().getCargoHold().getNumOfItem("Medicine");
                            changeText.setText("You have " + num + " medicine)");
                        }
                        break;

                }
            }
        });
    }

    private boolean performChecks(int itemNum, String good) {
        boolean one = shipViewModel.getMainShip().getCargoHold().takeCheck(good, itemNum);
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