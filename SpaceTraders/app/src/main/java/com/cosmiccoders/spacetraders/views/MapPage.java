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
import com.cosmiccoders.spacetraders.viewmodels.EditAddPlayerViewModel;
import com.cosmiccoders.spacetraders.viewmodels.EditShipViewModel;
import com.cosmiccoders.spacetraders.viewmodels.GetSetPlanetViewModel;
import com.cosmiccoders.spacetraders.viewmodels.ViewAddSolarSystemViewModel;

public class MapPage extends AppCompatActivity {
    private ViewAddSolarSystemViewModel solarSystem;
    private EditShipViewModel shipViewModel;
    private EditAddPlayerViewModel playerViewModel;
    private GetSetPlanetViewModel planetViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planet_map);
        solarSystem = ViewModelProviders.of(this).get(ViewAddSolarSystemViewModel.class);
        planetViewModel = ViewModelProviders.of(this).get(GetSetPlanetViewModel.class);
        shipViewModel = ViewModelProviders.of(this).get(EditShipViewModel.class);

        TextView location = findViewById(R.id.location_tag);
        TextView fuel = findViewById(R.id.fuel_amount);
        location.setText(planetViewModel.getPlanet().getName());
        fuel.setText(shipViewModel.getMainShip().getFuel()+"");
    }

    public void onPlanetPress(View v) {
        Button change = (Button) findViewById(v.getId());
        Log.i("Try", "trial");
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //where you change the planet you wanna go to
                //break after every case
                switch(v.getId()) {
                    case R.id.kravat:
                        planetViewModel.setPlanetDestination(solarSystem.getPlanet("Kravat"));
                        Log.i("Testing", planetViewModel.getPlanetDestination().toString());
                        //switching to page
                        break;
                    //switching to the planets on the planet map.xml & breaking
                    case R.id.drax:
                        planetViewModel.setPlanetDestination(solarSystem.getPlanet("Drax"));
                        Log.i("TestingDrax", planetViewModel.getPlanetDestination().toString());
                        break;
                    case R.id.bluedwarf:

                        planetViewModel.setPlanetDestination(solarSystem.getPlanet("Blue Dwarf"));
                        Log.i("TestingBlue", planetViewModel.getPlanetDestination().toString());
                        break;
                    case R.id.baratas:
                        planetViewModel.setPlanetDestination(solarSystem.getPlanet("Baratas"));
                        Log.i("TestingBaratas", planetViewModel.getPlanetDestination().toString());
                        break;
                    case R.id.andromeda:
                        planetViewModel.setPlanetDestination(solarSystem.getPlanet("andromeda"));
                        Log.i("TestingA", planetViewModel.getPlanetDestination().toString());
                        break;
                    case R.id.rollingHills:
                        planetViewModel.setPlanetDestination(solarSystem.getPlanet("Rolling Hills"));
                        Log.i("TestingHome", planetViewModel.getPlanetDestination().toString());
                        break;
                    case R.id.titikaka:
                        planetViewModel.setPlanetDestination(solarSystem.getPlanet("Titikaka"));
                        Log.i("TestingHome", planetViewModel.getPlanetDestination().toString());
                        break;
                }

                startActivity(new Intent(MapPage.this, PlanetIntro.class));

            }
        });
    }
}
