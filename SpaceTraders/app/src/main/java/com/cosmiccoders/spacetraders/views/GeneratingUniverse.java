package com.cosmiccoders.spacetraders.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.cosmiccoders.spacetraders.R;

import com.cosmiccoders.spacetraders.entity.SolarSystem;

import java.util.Iterator;
import java.util.Map;

public class GeneratingUniverse extends AppCompatActivity {

    private SolarSystem solarSystem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.generating_universe);

        solarSystem = new SolarSystem();

        Iterator it = solarSystem.getPlanetMap().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            Log.i("Generating Solar System",
                    solarSystem.getPlanet((String) pair.getKey()).toString());
            it.remove();
        }
    }
}
