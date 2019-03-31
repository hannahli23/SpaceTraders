package com.cosmiccoders.spacetraders.views;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.arch.lifecycle.ViewModelProviders;
import android.util.Log;

import android.view.View;
import android.widget.RadioGroup;
import android.view.MenuItem;
import android.widget.Button;

import com.cosmiccoders.spacetraders.R;
import com.cosmiccoders.spacetraders.viewmodels.EditAddPlayerViewModel;
import com.cosmiccoders.spacetraders.viewmodels.EditShipViewModel;
import com.cosmiccoders.spacetraders.viewmodels.GetSetPlanetViewModel;
import com.cosmiccoders.spacetraders.viewmodels.ViewAddSolarSystemViewModel;

public class Map extends AppCompatActivity {

    private EditShipViewModel shipViewModel;
    private EditAddPlayerViewModel playerViewModel;
    private ViewAddSolarSystemViewModel solarSystem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planet_map);
        solarSystem = ViewModelProviders.of(this).get(ViewAddSolarSystemViewModel.class);;
    }

    public void onPlanetPress(View v) {
        Button change = (Button) findViewById(v.getId());

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()) {
                    case R.id.kravat:

                }
            }
        });
    }
}
