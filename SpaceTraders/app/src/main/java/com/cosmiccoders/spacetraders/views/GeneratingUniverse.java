package com.cosmiccoders.spacetraders.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.cosmiccoders.spacetraders.R;

import com.cosmiccoders.spacetraders.entity.Planets.PlanetTemp;
import com.cosmiccoders.spacetraders.entity.Planets.StartingPlanet;
import com.cosmiccoders.spacetraders.entity.SolarSystem;
import com.cosmiccoders.spacetraders.model.PlanetInteractor;
import com.cosmiccoders.spacetraders.viewmodels.GetSetPlanetViewModel;

import java.util.Iterator;
import java.util.Map;

public class GeneratingUniverse extends AppCompatActivity {

    private SolarSystem solarSystem;
    private GetSetPlanetViewModel planetInteractor;
    private PlanetTemp planetTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.generating_universe);

        planetInteractor = ViewModelProviders.of(this).get(GetSetPlanetViewModel.class);

        solarSystem = new SolarSystem();

        Iterator it = solarSystem.getPlanetMap().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            Log.i("Generating Solar System",
                    solarSystem.getPlanet((String) pair.getKey()).toString());
            it.remove();
        }
        planetTemp = new StartingPlanet();
        planetInteractor.setPlanet(planetTemp);
        Log.i("Test", planetInteractor.getPlanet().toString());
    }

    public void onContinuePressed(View view) {
        Button btn = (Button) findViewById(R.id.homeButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GeneratingUniverse.this, ShipHome.class));
            }
        });
    }
}
