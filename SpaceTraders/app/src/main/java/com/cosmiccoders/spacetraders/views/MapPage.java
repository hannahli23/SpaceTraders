package com.cosmiccoders.spacetraders.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cosmiccoders.spacetraders.R;
import com.cosmiccoders.spacetraders.viewmodels.EditShipViewModel;
import com.cosmiccoders.spacetraders.viewmodels.GetSetPlanetViewModel;
import com.cosmiccoders.spacetraders.viewmodels.ViewAddSolarSystemViewModel;

/**
 * class to configure the map page
 */
public class MapPage extends AppCompatActivity {
    private ViewAddSolarSystemViewModel solarSystem;
    //private EditAddPlayerViewModel playerViewModel;
    private GetSetPlanetViewModel planetViewModel;

    @Override
    /**
     * This function creates the planets and universe
     * @param savedInstanceState The current state
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planet_map);
        solarSystem = ViewModelProviders.of(this).get(ViewAddSolarSystemViewModel.class);
        planetViewModel = ViewModelProviders.of(this).get(GetSetPlanetViewModel.class);
        EditShipViewModel shipViewModel = ViewModelProviders.of(this).get(EditShipViewModel.class);

        TextView location = findViewById(R.id.location_tag);
        TextView fuel = findViewById(R.id.fuel_amount);
        location.setText(planetViewModel.getPlanetName());
        fuel.setText(shipViewModel.getFuel()+"");
    }

    /**
     * Travels to the planet that is clicked
     * @param v current view
     */
    public void onPlanetPress(View v) {
        Button change = findViewById(v.getId());
        Log.i("Try", "trial");
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()) {
                    case R.id.kravat:
                        onPressedHelper("Kravat");
                        //switching to page
                        break;
                    //switching to the planets on the planet map.xml & breaking
                    case R.id.drax:
                        onPressedHelper("Drax");
                        break;
                    case R.id.bluedwarf:
                        onPressedHelper("Blue Dwarf");
                        break;
                    case R.id.baratas:
                        onPressedHelper("Baratas");
                        break;
                    case R.id.andromeda:
                        onPressedHelper("andromeda");
                        break;
                    case R.id.rollingHills:
                        onPressedHelper("Rolling Hills");
                        break;
                    case R.id.titikaka:
                        onPressedHelper("Titikaka");
                        break;
                }

                startActivity(new Intent(MapPage.this, PlanetIntro.class));

            }
        });
    }
    /**
     * This function is a helper method for the onPressed method
     * @param name The planet name
     */
    private void onPressedHelper(String name) {
        planetViewModel.setPlanetDestination(solarSystem.getPlanet(name));
        Log.i("Testing"+name, planetViewModel.toPlanetDestString());
    }
}
