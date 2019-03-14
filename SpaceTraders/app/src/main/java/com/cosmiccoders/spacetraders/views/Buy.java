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

public class Buy extends AppCompatActivity {
    private EditShipViewModel shipViewModel;
    private EditAddPlayerViewModel playerViewModel;
    private GetSetPlanetViewModel planetViewModel;

    private Market market;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buy);

        playerViewModel = ViewModelProviders.of(this).get(EditAddPlayerViewModel.class);
        planetViewModel = ViewModelProviders.of(this).get(GetSetPlanetViewModel.class);
        shipViewModel = ViewModelProviders.of(this).get(EditShipViewModel.class);

        market = planetViewModel.getPlanet().getMarket();
        changePrices();
    }

    public void changePrices() {
        TextView text;
        String price = "";

        text = (TextView) findViewById(R.id.w_price);
        if(market.getGoodList().containsKey("Water")) {
            price = market.getPrice("Water") + "";
            text.setText("Water costs:" + price);
        } else {
            text.setText("This item is unavailable");
        }

        text = (TextView) findViewById(R.id.fa_price);
        if(market.getGoodList().containsKey("Firearms")) {
            price = market.getPrice("Firearms") + "";
            text.setText("Firearms cost:" + price);
        } else {
            text.setText("This item is unavailable");
        }

        text = (TextView) findViewById(R.id.g_price);
        if(market.getGoodList().containsKey("Games")) {
            price = market.getPrice("Games") + "";
            text.setText("Games cost:" + price);
        } else {
            text.setText("This item is unavailable");
        }

        text = (TextView) findViewById(R.id.n_price);
        if(market.getGoodList().containsKey("Narcotics")) {
            price = market.getPrice("Narcotics") + "";
            text.setText("Narcotics cost:" + price);
        } else {
            text.setText("This item is unavailable");
        }

        text = (TextView) findViewById(R.id.r_price);
        if(market.getGoodList().containsKey("Robots")) {
            price = market.getPrice("Robots") + "";
            text.setText("Robots cost:" + price);
        } else {
            text.setText("This item is unavailable");
        }

        text = (TextView) findViewById(R.id.fur_price);
        if(market.getGoodList().containsKey("Furs")) {
            price = market.getPrice("Furs") + "";
            text.setText("Fur costs:" + price);
        } else {
            text.setText("This item is unavailable");
        }

        text = (TextView) findViewById(R.id.o_price);
        if(market.getGoodList().containsKey("Ore")) {
            price = market.getPrice("Ore") + "";
            text.setText("An ore costs:" + price);
        } else {
            text.setText("This item is unavailable");
        }

        text = (TextView) findViewById(R.id.food_price);
        if(market.getGoodList().containsKey("Food")) {
            price = market.getPrice("Food") + "";
            text.setText("Food costs:" + price);
        } else {
            text.setText("This item is unavailable");
        }

        text = (TextView) findViewById(R.id.m_price);
        if(market.getGoodList().containsKey("Medicine")) {
            price = market.getPrice("Medicine") + "";
            text.setText("Medicine costs:" + price);
        } else {
            text.setText("This item is unavailable");
        }
    }

    public void buy(View view) {
        Button change = (Button) findViewById(view.getId());

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int price = 0;
                switch(v.getId()){
                    case R.id.water:
                        if(market.getGoodList().containsKey("Water")) {
                            //price = market.getGoodList().get("Water");
                            price = 10;
                            if(performChecks(1, price)) {
                                playerViewModel.getPlayer().pay(price);
                                shipViewModel.getMainShip().getCargoHold().putItem("Water", 1);
                                Log.i("Test buy", shipViewModel.getMainShip().getCargoHold().toString());
                                Log.i("Testing sell", playerViewModel.getPlayer().getCurrency()+"");
                            } else {
                                Log.i("Test buy", "Oh no something went wrong :(((");
                            }
                        }
                        break;
                    case R.id.robots:
                        if(market.getGoodList().containsKey("Robots")) {
                            price = market.getGoodList().get("Robots");
                            if(performChecks(1, price)) {
                                playerViewModel.getPlayer().pay(price);
                                shipViewModel.getMainShip().getCargoHold().putItem("Robots", 1);
                                Log.i("Test buy", shipViewModel.getMainShip().getCargoHold().toString());
                                Log.i("Testing sell", playerViewModel.getPlayer().getCurrency()+"");
                            } else {
                                Log.i("Test buy", "Oh no something went wrong :(((");
                            }
                        }
                        break;
                    case R.id.food:
                        if(market.getGoodList().containsKey("Food")) {
                            price = market.getGoodList().get("Food");
                            if(performChecks(1, price)) {
                                playerViewModel.getPlayer().pay(price);
                                shipViewModel.getMainShip().getCargoHold().putItem("Food", 1);
                                Log.i("Test buy", shipViewModel.getMainShip().getCargoHold().toString());
                                Log.i("Testing sell", playerViewModel.getPlayer().getCurrency()+"");
                            } else {
                                Log.i("Test buy", "Oh no something went wrong :(((");
                            }
                        }
                        break;
                    case R.id.games:
                        if(market.getGoodList().containsKey("Games")) {
                            price = market.getGoodList().get("Games");
                            if(performChecks(1, price)) {
                                playerViewModel.getPlayer().pay(price);
                                shipViewModel.getMainShip().getCargoHold().putItem("Games", 1);
                                Log.i("Test buy", shipViewModel.getMainShip().getCargoHold().toString());
                                Log.i("Testing sell", playerViewModel.getPlayer().getCurrency()+"");
                            } else {
                                Log.i("Test buy", "Oh no something went wrong :(((");
                            }
                        }
                        break;
                    case R.id.firearms:
                        if(market.getGoodList().containsKey("Firearms")) {
                            price = market.getGoodList().get("Firearms");
                            if(performChecks(1, price)) {
                                playerViewModel.getPlayer().pay(price);
                                shipViewModel.getMainShip().getCargoHold().putItem("Firearms", 1);
                                Log.i("Test buy", shipViewModel.getMainShip().getCargoHold().toString());
                                Log.i("Testing sell", playerViewModel.getPlayer().getCurrency()+"");
                            } else {
                                Log.i("Test buy", "Oh no something went wrong :(((");
                            }
                        }
                        break;
                    case R.id.ore:
                        if(market.getGoodList().containsKey("Ore")) {
                            price = market.getGoodList().get("Ore");
                            if(performChecks(1, price)) {
                                playerViewModel.getPlayer().pay(price);
                                shipViewModel.getMainShip().getCargoHold().putItem("Ore", 1);
                                Log.i("Test buy", shipViewModel.getMainShip().getCargoHold().toString());
                                Log.i("Testing sell", playerViewModel.getPlayer().getCurrency()+"");
                            } else {
                                Log.i("Test buy", "Oh no something went wrong :(((");
                            }
                        }
                        break;
                    case R.id.narcotics:
                        if(market.getGoodList().containsKey("Narcotics")) {
                            price = market.getGoodList().get("Narcotics");
                            if(performChecks(1, price)) {
                                playerViewModel.getPlayer().pay(price);
                                shipViewModel.getMainShip().getCargoHold().putItem("Narcotics", 1);
                                Log.i("Test buy", shipViewModel.getMainShip().getCargoHold().toString());
                                Log.i("Testing sell", playerViewModel.getPlayer().getCurrency()+"");
                            } else {
                                Log.i("Test buy", "Oh no something went wrong :(((");
                            }
                        }
                        break;
                    case R.id.furs:
                        if(market.getGoodList().containsKey("Furs")) {
                            price = market.getGoodList().get("Furs");
                            if(performChecks(1, price)) {
                                playerViewModel.getPlayer().pay(price);
                                shipViewModel.getMainShip().getCargoHold().putItem("Furs", 1);
                                Log.i("Test buy", shipViewModel.getMainShip().getCargoHold().toString());
                                Log.i("Testing sell", playerViewModel.getPlayer().getCurrency()+"");
                            } else {
                                Log.i("Test buy", "Oh no something went wrong :(((");
                            }
                        }
                        break;
                    case R.id.medicine:
                        if(market.getGoodList().containsKey("Medicine")) {
                            price = market.getGoodList().get("Medicine");
                            if(performChecks(1, price)) {
                                playerViewModel.getPlayer().pay(price);
                                shipViewModel.getMainShip().getCargoHold().putItem("Medicine", 1);
                                Log.i("Test buy", shipViewModel.getMainShip().getCargoHold().toString());
                                Log.i("Testing sell", playerViewModel.getPlayer().getCurrency()+"");
                            } else {
                                Log.i("Test buy", "Oh no something went wrong :(((");
                            }
                        }
                        break;

                }
            }
        });
    }

    private boolean performChecks(int itemNum, int amount) {
        boolean one = playerViewModel.getPlayer().checkCurrency(amount);
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
