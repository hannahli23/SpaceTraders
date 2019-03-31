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

public class PlanetIntro extends AppCompatActivity{
    /**
     * You're going to be changing the textviews in on  create based on whichever planet is set
     * as the planet you want to go to
     * and then you should also have a click method for the GO button
     * And in the go button you should be checking if the planet you want to go to is in
     * the short range chart
     * So is the check passes you should 1) reset main planet 2) naivgate to the shiphome page
     */
    private ViewAddSolarSystemViewModel solarSystem;
    private EditShipViewModel shipViewModel;
    private EditAddPlayerViewModel playerViewModel;
    private GetSetPlanetViewModel planetViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kravat);
        solarSystem = ViewModelProviders.of(this).get(ViewAddSolarSystemViewModel.class);
        planetViewModel = ViewModelProviders.of(this).get(GetSetPlanetViewModel.class);
        //changing the textview to change with the click
        TextView text = (TextView) findViewById(R.id.planetName);
        text.setText(planetViewModel.getPlanetDestination().getName());
        //setting welcome message
        TextView welcomeMessage = (TextView) findViewById(R.id.welcomeMessage);
        welcomeMessage.setText("Welcome to " + planetViewModel.getPlanetDestination().getName());
        //setting planet info
        TextView planetInfo = (TextView) findViewById(R.id.planetInfo);
        planetInfo.setText("Planet Info: " + planetViewModel.getPlanetDestination().toString());

    }

    public void onBackPressed(View view) {
        Button btn2 = (Button) findViewById(R.id.back);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlanetIntro.this, Map.class));
            }
        });
    }
}