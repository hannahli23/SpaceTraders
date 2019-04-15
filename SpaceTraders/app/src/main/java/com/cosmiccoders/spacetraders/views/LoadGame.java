package com.cosmiccoders.spacetraders.views;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import com.cosmiccoders.spacetraders.R;
import com.cosmiccoders.spacetraders.entity.CargoHold;
import com.cosmiccoders.spacetraders.entity.Difficulty;
import com.cosmiccoders.spacetraders.entity.Planets.*;
import com.cosmiccoders.spacetraders.entity.Player;
//import com.cosmiccoders.spacetraders.entity.ShipYard;
import com.cosmiccoders.spacetraders.entity.Ships.Gnat;
import com.cosmiccoders.spacetraders.entity.Ships.Ship;
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
import com.android.volley.toolbox.Volley;
import com.cosmiccoders.spacetraders.viewmodels.ViewAddSolarSystemViewModel;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to load the game upon starting
 */
public class LoadGame extends AppCompatActivity {

    private EditShipViewModel shipViewModel;
    private EditAddPlayerViewModel playerViewModel;
    private GetSetPlanetViewModel planetViewModel;
    private ViewAddSolarSystemViewModel solarSystemViewModel;
    private GetAddCargoHoldViewModel cargoHoldViewModel;
    //private ShipYard shipYard;

    private Player testPlayer;
    private Ship testShip;
    //private CargoHold cargoHold;
    private RequestQueue requestQueue;  // This is our requests queue to process our HTTP requests.

    // This is the API base URL (GitHub API)
    private final String baseUrl = "http://10.0.2.2:9080/myapi";
    private String url;

    @Override
    /**
     * This function creates the planets and universe
     * @param savedInstanceState The current state
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.load_game);
        playerViewModel = ViewModelProviders.of(this).get(EditAddPlayerViewModel.class);
        planetViewModel = ViewModelProviders.of(this).get(GetSetPlanetViewModel.class);
        shipViewModel = ViewModelProviders.of(this).get(EditShipViewModel.class);
        solarSystemViewModel = ViewModelProviders.of(this).get(ViewAddSolarSystemViewModel.class);
        cargoHoldViewModel = ViewModelProviders.of(this).get(GetAddCargoHoldViewModel.class);

        requestQueue = Volley.newRequestQueue(this);

        testPlayer = new Player();
        testShip = new Gnat();
        cargoHold = new CargoHold(20);

        addPlanets();

        printPlanets();

        setMainPlanet();
    }
    /**
     * This function sets the player's main planet
     */
    private void setMainPlanet() {
        planetViewModel.setPlanet(solarSystemViewModel.getPlanet("Rolling Hills"));
        Log.i("Test", planetViewModel.toPlanetString());
    }
    /**
     * This function prints the planets in the solar system
     */
    private void printPlanets() {
        for (Map.Entry<String, PlanetTemp> entry : solarSystemViewModel.getPlanetMap().entrySet()) {
            Log.i("Planet name", entry.getKey());
            Log.i("Test", entry.getValue().toString());
        }
    }
    /**
     * This function adds planets to the solar system
     */
    private void addPlanets() {
        solarSystemViewModel.setSolarSystem();
    }

    /**
     * Loads all elements of the game when load is clicked
     * @param v current view
     */
    public void onLoadClicked(View v) {
        Button changeButton = findViewById(R.id.load_button);
        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView id = findViewById(R.id.id_field);
                if(!id.getText().toString().matches(".*[a-zA-Z]+.*")) {
                    Log.i("Test", id.getText().toString());
                    int user_id = Integer.parseInt(id.getText().toString());
                    loadPlayer(user_id);
                    loadShip(user_id);
                    loadCargoHold(user_id);
                    loadItem(user_id);
                    //playerViewModel.updatePlayer(testPlayer);
                    //playerViewModel.setId(user_id);
                    shipViewModel.setMainShip(testShip);

                    //Log.i("Test Load Ship", cargoHoldViewModel.toString());

                    startActivity(new Intent(LoadGame.this, ShipHome.class));

                } else {
                    Log.i("Error", "The user id you have entered is not valid!");
                }

            }
        });
    }

    /**
     * This function loads the player of the game
     * @param user_id The players ID that will be loaded upon their selection of load game
     */
    private void loadPlayer(final int user_id) {
        this.url = this.baseUrl + "/player/id/" + user_id;

        JsonArrayRequest arrReq = new JsonArrayRequest(Request.Method.GET, url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        if (response.length() > 0) {
                            for (int i = 0; i < response.length(); i++) {
                                try {
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
                                    testPlayer = new Player(player_name,
                                            pp, fp, tp, ep, currency, d);
                                    playerViewModel.updatePlayer(testPlayer);
                                    playerViewModel.setId(user_id);
                                    planetViewModel.setPlanet(
                                            solarSystemViewModel.getPlanet(currPlanet));

                                    Log.i("Player", playerViewModel.getId()+"");
                                    Log.i("Test Load P", playerViewModel.toString());

                                    //Log.i("Test", playerViewModel.toString());
                                    //Log.i("Test", planetViewModel.getPlanet().toString());
                                } catch (JSONException e) {
                                    Log.e("Volley", "Invalid JSON Object.");
                                }
                                Log.i("Testing", i+"");
                            }
                        } else {
                            Log.i("Test rest api", "No repos founds");
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("Test rest api", "The ID you are trying to find does not exist!");
                        Log.e("Volley", error.toString());
                    }
                }
        );
        requestQueue.add(arrReq);
    }
    /**
     * This function loads the ship of the player
     * @param user_id The players ID number
     */
    private void loadShip(int user_id){
        this.url = baseUrl + "/ship/id/" + user_id;

        // Next, we create a new JsonArrayRequest. This will use Volley to make a HTTP request
        // that expects a JSON Array Response.
        // To fully understand this, I'd recommend reading the office docs:
        // https://developer.android.com/training/volley/index.html
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
                                    testShip.setName(shipname);
                                    testShip.setFuel(fuel);
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
    /**
     * This function loads the cargo of the player
     * @param user_id The players ID number
     */
    private void loadCargoHold(int user_id) {
        this.url = baseUrl + "/cargohold/id/" + user_id;

        // Next, we create a new JsonArrayRequest. This will use Volley to make a HTTP request
        // that expects a JSON Array Response.
        // To fully understand this, I'd recommend
        // reading the office docs: https://developer.android.com/training/volley/index.html
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
                                    //int max = jsonObj.getInt("maxsize");
                                    int curr = jsonObj.getInt("curr_size");
                                    //cargoHold = testShip.getCargoHold();
                                    //cargoHold.setCurrSize(curr);
                                    cargoHoldViewModel.setCurrSize(curr);
                                    //shipViewModel.getMainShip().getCargoHold().setCurrSize(curr);
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
    /**
     * This function loads the items the player has
     * @param user_id The players ID number
     */
    private void loadItem(int user_id) {
        this.url = baseUrl + "/items/id/" + user_id;
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
                            //Log.i("CargoHold", cargoHoldViewModel.toString());
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
}
