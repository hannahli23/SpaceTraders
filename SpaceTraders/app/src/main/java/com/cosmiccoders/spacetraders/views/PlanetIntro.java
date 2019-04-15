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
import com.cosmiccoders.spacetraders.entity.Difficulty;
import com.cosmiccoders.spacetraders.entity.Planets.PlanetTemp;
import com.cosmiccoders.spacetraders.entity.ShortRangeChart;
import com.cosmiccoders.spacetraders.viewmodels.EditAddPlayerViewModel;
import com.cosmiccoders.spacetraders.viewmodels.EditShipViewModel;
import com.cosmiccoders.spacetraders.viewmodels.GetSetPlanetViewModel;
import com.cosmiccoders.spacetraders.viewmodels.ViewAddSolarSystemViewModel;

import java.util.List;
import java.util.Random;

/**
 * PlanetInto class
 */
public class PlanetIntro extends AppCompatActivity{
    private EditShipViewModel shipViewModel;
    private EditAddPlayerViewModel playerViewModel;
    private GetSetPlanetViewModel planetViewModel;
    private ShortRangeChart shortRangeChart;
    private ViewAddSolarSystemViewModel solarSystem;
    private Random rand;
    /**
     * This function makes the player lose money
     * @param randNum A randomly generated number that will determine how much money the player
     *                loses
     */
    private void loseMoney(int randNum) {
        if (randNum <= 99) {
            if (playerViewModel.getCurrency() >= 50) {
                playerViewModel.pay(50);
                Log.i("Test", "You've lost money!");
            }
        }
    }
    /**
     * This function makes the player gain money
     * @param randNum A randomly generated number that will determine how much money the player
     *                gains
     */
    private void gainMoney(int randNum) {
        if ((randNum > 40) && (randNum < 60)) {
            playerViewModel.getPaid(3000);
            Log.i("Test", "You've gained money!");
        }
    }
    /**
     * This function sets the difficulty to impossible
     * @param randNum A randomly generated number that will set the level on impossible
     */
    private void yaThatSucks(int randNum) {
        if (randNum == 98) {
            playerViewModel.setDifficulty(Difficulty.IMPOSSIBLE);
            Log.i("Test", "Level Set on Impossible!!");
        }
    }

    @Override
    /**
     * This function makes everything upon pressing the create button
     * @param savedInstanceState The state of the saved game
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kravat);
        /*
          You're going to be changing the textviews in on  create based on whichever planet is set
          as the planet you want to go to
          and then you should also have a click method for the GO button
          And in the go button you should be checking if the planet you want to go to is in
          the short range chart
          So is the check passes you should 1) reset main planet 2) naivgate to the shiphome page
         */
        solarSystem = ViewModelProviders.of(this).get(ViewAddSolarSystemViewModel.class);
        planetViewModel = ViewModelProviders.of(this).get(GetSetPlanetViewModel.class);
        shipViewModel = ViewModelProviders.of(this).get(EditShipViewModel.class);
        playerViewModel = ViewModelProviders.of(this).get(EditAddPlayerViewModel.class);

        //changing the textview to change with the click
        changeText();

        //setting welcome message
        setWelcome();

        //setting planet info
        setInfo();

        setShortRange();

        rand = new Random();
    }
    /**
     * This function changes the name of the planets
     */
    private void changeText() {
        TextView text = findViewById(R.id.planetName);
        text.setText(planetViewModel.getPlanet().getName());
    }
    /**
     * This function swets the welcome message of the planets
     */
    private void setWelcome() {
        TextView welcomeMessage = findViewById(R.id.welcomeMessage);
        welcomeMessage.setText("Welcome to " + planetViewModel.getPlanetDestination().getName());
    }
    /**
     * This function sets the planets information
     */
    private void setInfo() {
        TextView planetInfo = findViewById(R.id.planetInfo);
        planetInfo.setText("Planet Info: " + planetViewModel.getPlanetDestination().toString());
    }
    /**
     * This function sets the planets in the solar system
     */
    private void setShortRange() {
        shortRangeChart = new ShortRangeChart(shipViewModel.getMainShip(),
                planetViewModel.getPlanet(), solarSystem.getPlanetMap());

    }

    /**
     * Goes back to the map page when back button is pressed
     * @param view current view
     */
    public void onBackPressed(View view) {
        Button btn2 = findViewById(R.id.back);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlanetIntro.this, MapPage.class));
            }
        });
    }
    /**
     * This function allows things to happen once the go button is pressed
     * @param view The games current view
     */
    public void onGoPressed(View view) {
        Button btn2 = findViewById(R.id.go_to_planet);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlanetTemp go = planetViewModel.getPlanetDestination();
                List list = shortRangeChart.getPlanetsInRange();
                if(!list.contains(go)) {
                    Log.i("Error!!!", "This planet is not in range!");
                }
                int integer_use = (shortRangeChart.distance(go.getLocation(),
                        planetViewModel.getPlanet().getLocation()));
                if(integer_use > shipViewModel.getFuel()) {
                    Log.i("Error:", "Theres not enough fuel!");
                } else {
                    shipViewModel.takeAwayFromFeul(integer_use);
                    planetViewModel.setPlanet(planetViewModel.getPlanetDestination());
                    final int randNum = rand.nextInt(100) + 1;
                    loseMoney(randNum);
                    gainMoney(randNum);
                    yaThatSucks(randNum);
                    //moving to ship home
                    startActivity(new Intent(PlanetIntro.this, ShipHome.class));
                }
            }
        });
    }
}
