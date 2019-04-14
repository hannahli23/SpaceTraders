package com.cosmiccoders.spacetraders.views;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.cosmiccoders.spacetraders.R;
import com.cosmiccoders.spacetraders.entity.Difficulty;
import com.cosmiccoders.spacetraders.entity.Player;
import com.cosmiccoders.spacetraders.entity.ShipYard;
import com.cosmiccoders.spacetraders.entity.Skills;
import com.cosmiccoders.spacetraders.viewmodels.EditAddPlayerViewModel;
import com.cosmiccoders.spacetraders.viewmodels.EditShipViewModel;
import com.cosmiccoders.spacetraders.viewmodels.GetAddCargoHoldViewModel;
import com.cosmiccoders.spacetraders.viewmodels.GetSetPlanetViewModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.Response;
import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.cosmiccoders.spacetraders.viewmodels.ViewAddSolarSystemViewModel;

import java.util.HashMap;
import java.util.Map;

public class ShipHome extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{

    private EditShipViewModel shipViewModel;
    private EditAddPlayerViewModel playerViewModel;
    private GetSetPlanetViewModel planetViewModel;
    private GetAddCargoHoldViewModel cargoHoldViewModel;
    private ViewAddSolarSystemViewModel solarSystemViewModel;
    private ShipYard shipYard;

    private Player testPlayer;
    //private Ship testShip;

    private RequestQueue requestQueue;  // This is our requests queue to process our HTTP requests.

    // This is the API base URL (GitHub API)
    private String baseUrl = "http://10.0.2.2:9080/myapi/player";
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ship_home);
        playerViewModel = ViewModelProviders.of(this).get(EditAddPlayerViewModel.class);
        planetViewModel = ViewModelProviders.of(this).get(GetSetPlanetViewModel.class);
        shipViewModel = ViewModelProviders.of(this).get(EditShipViewModel.class);
        solarSystemViewModel = ViewModelProviders.of(this).get(ViewAddSolarSystemViewModel.class);
        cargoHoldViewModel = ViewModelProviders.of(this).get(GetAddCargoHoldViewModel.class);
        requestQueue = Volley.newRequestQueue(this);
        shipYard = new ShipYard();

        Button btn = findViewById(R.id.go_places);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(ShipHome.this, v);
                popup.setOnMenuItemClickListener(ShipHome.this);
                popup.inflate(R.menu.go_places_menu);
                popup.show();
            }
        });
    }


    public void onMapPressed(View view) {
        Button btn = findViewById(R.id.view_map_button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShipHome.this, MapPage.class));
            }
        });
    }

    public void onExitPressed(View v) {
        Button changeButton = findViewById(R.id.save_button);
        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        Toast.makeText(this, "Selected Item: " + item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.go_market:
                Log.i("Testing: ", "Yay!");
                startActivity(new Intent(ShipHome.this, MarketPlace.class));
                return true;
            case R.id.go_ship:
                //Log.i("Testing", planetViewModel.getPlanet().toString());
                shipYard.sellFuel(playerViewModel.getPlayer(), shipViewModel.getMainShip());
                return true;
            case R.id.go_bank:
                // do your code
                return true;
            case R.id.go_police:
                // do your code
                return true;
            default:
                return false;
        }
    }

    public void viewStats(View view) {
        Button changeButton = findViewById(R.id.view_stats_button);
        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Player", playerViewModel.toString());
                Log.i("Player", playerViewModel.getId()+"");
                Log.i("Planet", planetViewModel.getPlanet().toString());
                Log.i("Ship", cargoHoldViewModel.toString());
                Log.i("Market", planetViewModel.getPlanet().getMarket().toString());
            }
        });
    }

    public void onSave(View view) {
        Button changeButton = findViewById(R.id.sell_goods_button);
        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateAPlayer();
                updateAShip();
                updateACargoHold();
                updateItems();
            }
        });
    }

    public void loadPlayer() {
        this.url = this.baseUrl + "/id/5";

        JsonArrayRequest arrReq = new JsonArrayRequest(Request.Method.GET, url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // Check the length of our response (to see if the user has any repos)
                        if (response.length() > 0) {
                            // The user does have repos, so let's loop through them all.
                            for (int i = 0; i < response.length(); i++) {
                                try {
                                    // For each repo, add a new line to our repo list.
                                    JSONObject jsonObj = response.getJSONObject(i);
                                    String player_name = jsonObj.get("player_name").toString();
                                    int currency = jsonObj.getInt("currency");
                                    String difficulty = jsonObj.get("difficulty").toString();
                                    int fp = jsonObj.getInt("fighter_points");
                                    int tp = jsonObj.getInt("trader_points");
                                    int ep = jsonObj.getInt("engineer_points");
                                    int pp = jsonObj.getInt("pilot_points");
                                    String currPlanet = jsonObj.get("curr_planet").toString();

                                    Difficulty d = Difficulty.NORMAL;
                                    switch(difficulty){
                                        case "easy":
                                            d = Difficulty.EASY;
                                            break;
                                        case "beginner":
                                            d = Difficulty.BEGINNER;
                                            break;
                                        case "hard":
                                            d = Difficulty.HARD;
                                        case "normal":
                                            d = Difficulty.NORMAL;
                                    }
                                    testPlayer = new Player(player_name, pp, fp, tp, ep, currency, d);
                                    playerViewModel.updatePlayer(testPlayer);
                                    planetViewModel.setPlanet(solarSystemViewModel.getPlanet(currPlanet));
                                    Log.i("Test", playerViewModel.toString());
                                    Log.i("Test", planetViewModel.getPlanet().toString());
                                } catch (JSONException e) {
                                    // If there is an error then output this to the logs.
                                    Log.e("Volley", "Invalid JSON Object.");
                                }
                                Log.i("Testing", i+"");
                            }
                        } else {
                            // The user didn't have any repos.
                            //setRepoListText("No repos found.");
                            Log.i("Test rest api", "No repos founds");
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // If there a HTTP error then add a note to our repo list.
                        //setRepoListText("The ID you are trying to find does not exist!");
                        Log.i("Test rest api", "The ID you are trying to find does not exist!");
                        Log.e("Volley", error.toString());
                    }
                }
        );
        // Add the request we just defined to our request queue.
        // The request queue will automatically handle the request as soon as it can.
        requestQueue.add(arrReq);
    }

    public void loadShip(){
        this.url = "http://10.0.2.2:9080/myapi/ship/id/1";

        // Next, we create a new JsonArrayRequest. This will use Volley to make a HTTP request
        // that expects a JSON Array Response.
        // To fully understand this, I'd recommend readng the office docs: https://developer.android.com/training/volley/index.html
        JsonArrayRequest arrReq = new JsonArrayRequest(Request.Method.GET, url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // Check the length of our response (to see if the user has any repos)
                        if (response.length() > 0) {
                            // The user does have repos, so let's loop through them all.
                            for (int i = 0; i < response.length(); i++) {
                                try {
                                    // For each repo, add a new line to our repo list.
                                    JSONObject jsonObj = response.getJSONObject(i);
                                    String shipname = jsonObj.get("ship_name").toString();
                                    int fuel = jsonObj.getInt("fuel");
                                    shipViewModel.setFuel(fuel);
                                    shipViewModel.setName(shipname);
                                } catch (JSONException e) {
                                    // If there is an error then output this to the logs.
                                    Log.e("Volley", "Invalid JSON Object.");
                                }
                                Log.i("Testing", i+"");
                            }
                        } else {
                            // The user didn't have any repos.
                            //setRepoListText("No repos found.");
                            Log.i("Test rest api", "No repos founds");
                        }

                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // If there a HTTP error then add a note to our repo list.
                        //setRepoListText("The ID you are trying to find does not exist!");
                        Log.i("Test rest api", "The ID you are trying to find does not exist!");
                        Log.e("Volley", error.toString());
                    }
                }
        );
        // Add the request we just defined to our request queue.
        // The request queue will automatically handle the request as soon as it can.
        requestQueue.add(arrReq);
    }

    public void loadCargoHold() {
        this.url = "http://10.0.2.2:9080/myapi/cargohold/id/5";

        // Next, we create a new JsonArrayRequest. This will use Volley to make a HTTP request
        // that expects a JSON Array Response.
        // To fully understand this, I'd recommend readng the office docs: https://developer.android.com/training/volley/index.html
        JsonArrayRequest arrReq = new JsonArrayRequest(Request.Method.GET, url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // Check the length of our response (to see if the user has any repos)
                        if (response.length() > 0) {
                            // The user does have repos, so let's loop through them all.
                            for (int i = 0; i < response.length(); i++) {
                                try {
                                    // For each repo, add a new line to our repo list.
                                    JSONObject jsonObj = response.getJSONObject(i);
                                    int max = jsonObj.getInt("maxsize");
                                    int curr = jsonObj.getInt("curr_size");

                                    cargoHoldViewModel.setCurrSize(curr);
                                } catch (JSONException e) {
                                    // If there is an error then output this to the logs.
                                    Log.e("Volley", "Invalid JSON Object.");
                                }
                                Log.i("Testing", i+"");
                            }
                        } else {
                            // The user didn't have any repos.
                            //setRepoListText("No repos found.");
                            Log.i("Test rest api", "No repos founds");
                        }

                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // If there a HTTP error then add a note to our repo list.
                        //setRepoListText("The ID you are trying to find does not exist!");
                        Log.i("Test rest api", "The ID you are trying to find does not exist!");
                        Log.e("Volley", error.toString());
                    }
                }
        );
        // Add the request we just defined to our request queue.
        // The request queue will automatically handle the request as soon as it can.
        requestQueue.add(arrReq);
    }

    public void loadItem() {
        this.url = "http://10.0.2.2:9080/myapi/items/id/5";
        JsonArrayRequest arrReq = new JsonArrayRequest(Request.Method.GET, url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Map<String, Integer> temp = new HashMap<>();

                        if (response.length() > 0) {
                            // The user does have repos, so let's loop through them all.
                            for (int i = 0; i < response.length(); i++) {
                                try {
                                    // For each repo, add a new line to our repo list.
                                    JSONObject jsonObj = response.getJSONObject(i);
                                    String item_name = jsonObj.get("item_name").toString();
                                    int amount = jsonObj.getInt("curr_amount");
                                    temp.put(item_name, amount);
                                } catch (JSONException e) {
                                    // If there is an error then output this to the logs.
                                    Log.e("Volley", "Invalid JSON Object.");
                                }
                                Log.i("Testing", i+"");
                            }
                            cargoHoldViewModel.setInventory(temp);
                        } else {
                            // The user didn't have any repos.
                        }

                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // If there a HTTP error then add a note to our repo list.
                        Log.e("Volley", error.toString());
                    }
                }
        );
        // Add the request we just defined to our request queue.
        // The request queue will automatically handle the request as soon as it can.
        requestQueue.add(arrReq);
    }

    private void updateAPlayer(){
        this.url = this.baseUrl;

        // Next, we create a new JsonArrayRequest. This will use Volley to make a HTTP request
        // that expects a JSON Array Response.
        // To fully understand this, I'd recommend readng the office docs: https://developer.android.com/training/volley/index.html
        HashMap<String, Object> params = new HashMap<>();
        params.put("user_id", playerViewModel.getId());
        params.put("player_name", playerViewModel.getName());
        params.put("currency", playerViewModel.getCurrency());
        params.put("difficulty", playerViewModel.getRepresentation());
        params.put("fighter_points", playerViewModel.getSkill(Skills.FIGHTER));
        params.put("trader_points", playerViewModel.getSkill(Skills.TRADER));
        params.put("engineer_points", playerViewModel.getSkill(Skills.ENGINEER));
        params.put("pilot_points", playerViewModel.getSkill(Skills.PILOT));
        params.put("curr_planet", planetViewModel.getPlanet().getName());
        JSONObject postparams = new JSONObject(params);
        Log.i("Test", postparams.toString());
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.PUT,
                url, new JSONObject(params),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("Volley", "You did it!");
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley", error.toString());
                    }
                });
        requestQueue.add(jsonObjReq);
    }

    private void updateAShip(){
        this.url = "http://10.0.2.2:9080/myapi/ship";

        // Next, we create a new JsonArrayRequest. This will use Volley to make a HTTP request
        // that expects a JSON Array Response.
        // To fully understand this, I'd recommend readng the office docs: https://developer.android.com/training/volley/index.html
        HashMap<String, Object> params = new HashMap<>();
        params.put("ship_name", shipViewModel.getShipName());
        params.put("fuel", shipViewModel.getFuel());
        params.put("user_id", playerViewModel.getId());

        JSONObject postparams = new JSONObject(params);
        Log.i("Test", postparams.toString());
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.PUT,
                url, new JSONObject(params),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("Volley Ship", "You did it!");
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley Ship", error.toString());
                    }
                });
        requestQueue.add(jsonObjReq);
    }

    private void updateACargoHold(){
        this.url = "http://10.0.2.2:9080/myapi/cargohold";

        HashMap<String, Object> params = new HashMap<>();
        params.put("curr_size", cargoHoldViewModel.getCurrSize());
        params.put("user_id", playerViewModel.getId());

        JSONObject postparams = new JSONObject(params);
        Log.i("Test", postparams.toString());
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.PUT,
                url, new JSONObject(params),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("Volley Ship", "You did it!");
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley Ship", error.toString());
                    }
                });
        requestQueue.add(jsonObjReq);
    }

    private void updateItems(){
        deleteItems();
        addItems();
    }



    public void addPlayer(){
        this.url = this.baseUrl;

        // Next, we create a new JsonArrayRequest. This will use Volley to make a HTTP request
        // that expects a JSON Array Response.
        // To fully understand this, I'd recommend readng the office docs: https://developer.android.com/training/volley/index.html
        HashMap<String, Object> params = new HashMap<>();
        params.put("user_id", 1);
        params.put("player_name", playerViewModel.getName());
        params.put("currency", playerViewModel.getCurrency());
        params.put("difficulty", playerViewModel.getRepresentation());
        params.put("fighter_points", playerViewModel.getSkill(Skills.FIGHTER));
        params.put("trader_points", playerViewModel.getSkill(Skills.TRADER));
        params.put("engineer_points", playerViewModel.getSkill(Skills.ENGINEER));
        params.put("pilot_points", playerViewModel.getSkill(Skills.PILOT));
        params.put("curr_planet", planetViewModel.getPlanet().getName());
        JSONObject postparams = new JSONObject(params);
        Log.i("Test", postparams.toString());
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                url, new JSONObject(params),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i("Volley", "You did it!");
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("Volley", error.toString());
                    }
                });
        requestQueue.add(jsonObjReq);
    }

    public void addShip(){
        this.url = "http://10.0.2.2:9080/myapi/ship";

        // Next, we create a new JsonArrayRequest. This will use Volley to make a HTTP request
        // that expects a JSON Array Response.
        // To fully understand this, I'd recommend readng the office docs: https://developer.android.com/training/volley/index.html
        HashMap<String, Object> params = new HashMap<>();
        params.put("ship_name", shipViewModel.getShipName());
        params.put("ship_type", "Gnat");
        params.put("hull_strength", shipViewModel.getHullStrength());
        params.put("weapon_slots", shipViewModel.getNumOfWeaponSlots());
        params.put("shield_slots", shipViewModel.getNumOfShieldSlots());
        params.put("gadget_slots", shipViewModel.getNumOfGadgetSlots());
        params.put("crew_quarters", shipViewModel.getNumOfCrewQuarters());
        params.put("travel_range", shipViewModel.getMaxTravelRange());
        params.put("escape_pod", "false");
        params.put("fuel", shipViewModel.getFuel());
        params.put("user_id", 1);

        JSONObject postparams = new JSONObject(params);
        Log.i("Test", postparams.toString());
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                url, new JSONObject(params),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("Volley Ship", "You did it!");
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley Ship", error.toString());
                    }
                });
        requestQueue.add(jsonObjReq);
    }

    public void addCargoHold(){
        this.url = "http://10.0.2.2:9080/myapi/cargohold";

        HashMap<String, Object> params = new HashMap<>();
        params.put("curr_size", cargoHoldViewModel.getCurrSize());
        params.put("maxsize", cargoHoldViewModel.getMax());
        params.put("user_id", 1);

        JSONObject postparams = new JSONObject(params);
        Log.i("Test", postparams.toString());
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                url, new JSONObject(params),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("Volley Ship", "You did it!");
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley Ship", error.toString());
                    }
                });
        requestQueue.add(jsonObjReq);
    }


    private void deleteItems() {
        this.url = "http://10.0.2.2:9080/myapi/items/delete";

        HashMap<String, Object> params = new HashMap<>();
        params.put("user_id", playerViewModel.getId());

        JSONObject postparams = new JSONObject(params);
        Log.i("Test", postparams.toString());
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                url, new JSONObject(params),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("Volley Ship", "You did it!");
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley Ship", error.toString());
                    }
                });
        requestQueue.add(jsonObjReq);
    }

    private void addItems() {
        this.url = "http://10.0.2.2:9080/myapi/items";
        Map<String, Integer> inventory = cargoHoldViewModel.getInventory();
        if(inventory.isEmpty()) {return;}
        for (java.util.Map.Entry<String, Integer> entry: inventory.entrySet()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("item_name", entry.getKey());
            params.put("curr_amount", entry.getValue());
            params.put("user_id", playerViewModel.getId());

            JSONObject postparams = new JSONObject(params);
            Log.i("Test", postparams.toString());
            JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                    url, new JSONObject(params),
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Log.e("Volley Ship", "You did it!");
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("Volley Ship", error.toString());
                        }
                    });
            requestQueue.add(jsonObjReq);
        }
    }

}
