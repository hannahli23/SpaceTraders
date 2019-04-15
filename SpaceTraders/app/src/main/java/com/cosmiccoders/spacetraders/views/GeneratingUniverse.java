package com.cosmiccoders.spacetraders.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.cosmiccoders.spacetraders.R;

import com.cosmiccoders.spacetraders.entity.Planets.*;
import com.cosmiccoders.spacetraders.viewmodels.GetSetPlanetViewModel;
import com.cosmiccoders.spacetraders.viewmodels.ViewAddSolarSystemViewModel;

import java.util.Map;

/**
 * Class responsible for generating the universe
 */
public class GeneratingUniverse extends AppCompatActivity {

    //private SolarSystem solarSystem;
    //private PlanetTemp planetTemp;
    private ViewAddSolarSystemViewModel solarSystemViewModel;
    private GetSetPlanetViewModel planetViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.generating_universe);

        planetViewModel = ViewModelProviders.of(this).get(GetSetPlanetViewModel.class);
        solarSystemViewModel = ViewModelProviders.of(this).get(ViewAddSolarSystemViewModel.class);

        //solarSystem = new SolarSystem();
        addPlanets();

        printPlanets();

        setMainPlanet();
    }

    private void setMainPlanet() {
        planetViewModel.setPlanet(solarSystemViewModel.getPlanet("Rolling Hills"));
        Log.i("Test", planetViewModel.getPlanet().toString());
    }

    private void printPlanets() {
        for (Map.Entry<String, PlanetTemp> entry : solarSystemViewModel.getPlanetMap().entrySet()) {
            Log.i("Planet name", entry.getKey());
            Log.i("Test", entry.getValue().toString());
        }
    }

    private void addPlanets() {
        /*PlanetTemp test = new Kravat();
        solarSystemViewModel.setPlanetSS(new StartingPlanet());
        solarSystemViewModel.setPlanetSS(new Andromeda());
        solarSystemViewModel.setPlanetSS(new Baratas());
        solarSystemViewModel.setPlanetSS(new Cornholio());
        solarSystemViewModel.setPlanetSS(new Drax());
        solarSystemViewModel.setPlanetSS(test);
        solarSystemViewModel.setPlanetSS(new Omphalos());
        solarSystemViewModel.setPlanetSS(new Titikaka());
        solarSystemViewModel.setPlanetSS(new RedDwarf());
        solarSystemViewModel.setPlanetSS(new BlueDwarf());*/
        solarSystemViewModel.setSolarSystem();
    }

    /**
     * When homeButton is pressed, change to ship home page.
     * @param view the current view
     */
    public void onContinuePressed(View view) {
        Button btn = findViewById(R.id.homeButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GeneratingUniverse.this, ShipHome.class));
            }
        });
    }
}
