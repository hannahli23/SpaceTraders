package com.cosmiccoders.spacetraders.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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
            Log.d("Generating Solar System",
                    solarSystem.getPlanet((String) pair.getKey()).toString());
            it.remove();
        }
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
