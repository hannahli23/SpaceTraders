package com.cosmiccoders.spacetraders.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.cosmiccoders.spacetraders.entity.Difficulty;
import com.cosmiccoders.spacetraders.entity.Player;
import com.cosmiccoders.spacetraders.entity.Ship;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

import com.cosmiccoders.spacetraders.R;
import com.cosmiccoders.spacetraders.entity.ShipTypes;
import com.cosmiccoders.spacetraders.entity.Skills;
import com.cosmiccoders.spacetraders.viewmodels.EditAddPlayerViewModel;
import com.cosmiccoders.spacetraders.viewmodels.EditShipViewModel;

public class PlayerCreation extends AppCompatActivity {

    private EditAddPlayerViewModel playerViewModel;
    private EditShipViewModel shipViewModel;

    private TextView pilotSkills;
    private TextView fighterSkills;
    private TextView traderSkills;
    private TextView engineerSkills;

    private int ps;
    private int fs;
    private int ts;
    private int es;

    private EditText nameField;
    private EditText shipField;

    private Player player;
    private Ship ship;

    private Spinner majorSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        majorSpinner = findViewById(R.id.spinner);
        majorSpinner.setAdapter(new ArrayAdapter<Difficulty>(this,
                android.R.layout.simple_spinner_item, Difficulty.values()));

        shipField = findViewById(R.id.ship_field);
        nameField = findViewById(R.id.name_field);

        pilotSkills = findViewById(R.id.pilot_points);
        traderSkills = findViewById(R.id.trader_points);
        engineerSkills = findViewById(R.id.engineer_points);
        fighterSkills = findViewById(R.id.fighter_points);

        ps = Integer.parseInt(pilotSkills.getText().toString());
        ts = Integer.parseInt(traderSkills.getText().toString());
        fs = Integer.parseInt(fighterSkills.getText().toString());
        es = Integer.parseInt(engineerSkills.getText().toString());
    }

    public void onSubtractPressed(View view) {
        Button change = (Button) findViewById(view.getId());
        int temp = 0;
        switch(view.getId()) {
            case R.id.subtract_pilot:
                temp = R.id.pilot_points;
                break;
            case R.id.subtract_trader:
                temp = R.id.trader_points;
                break;
            case R.id.subtract_fighter:
                temp = R.id.fighter_points;
                break;
            case R.id.subtract_engineer:
                temp = R.id.engineer_points;
        }
        final TextView changeText = (TextView) findViewById(temp);

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int total = ts + ps + fs + es;
                Log.i("MyActivity", "" + total);
                switch(v.getId()) {
                    case R.id.subtract_pilot:
                        if (ps > 0) {
                            ps--;
                            changeText.setText("" + ps);
                            total = ts + ps + fs + es;
                            Log.i("PS", "" + ps);
                            Log.i("MyActivity", "" + total);
                        } else {
                            ps = 0;
                            Log.i("PS", "" + ps);
                            Log.i("MyActivity", "" + total);
                        }
                        break;
                    case R.id.subtract_trader:
                        if(ts > 0) {
                            ts--;
                            changeText.setText("" + ts);
                            total = ts + ps + fs + es;
                            Log.i("TS", "" + ts);
                            Log.i("MyActivity", "" + total);
                        } else {
                            ts = 0;
                            Log.i("TS", "" + ts);
                            Log.i("MyActivity", "" + total);
                        }
                        break;
                    case R.id.subtract_fighter:
                        if(fs > 0) {
                            fs--;
                            changeText.setText("" + fs);
                            total = ts + ps + fs + es;
                            Log.i("FS", "" + fs);
                            Log.i("MyActivity", "" + total);
                        } else {
                            fs = 0;
                            Log.i("FS", "" + fs);
                            Log.i("MyActivity", "" + total);
                        }
                        break;
                    case R.id.subtract_engineer:
                        if(es > 0) {
                            es--;
                            changeText.setText("" + es);
                            total = ts + ps + fs + es;
                            Log.i("ES", "" + es);
                            Log.i("MyActivity", "" + total);
                        } else {
                            es = 0;
                            Log.i("ES", "" + es);
                            Log.i("MyActivity", "" + total);
                        }
                        break;
                }
            }
        });
    }

    public void onAddPressed(View view) {
        Button change = (Button) findViewById(view.getId());
        int temp = 0;
        switch(view.getId()) {
            case R.id.add_pilot:
                temp = R.id.pilot_points;
                break;
            case R.id.add_trader:
                temp = R.id.trader_points;
                break;
            case R.id.add_fighter:
                temp = R.id.fighter_points;
                break;
            case R.id.add_engineer:
                temp = R.id.engineer_points;
        }

        final TextView changeText = (TextView) findViewById(temp);
        
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int total = ts + ps + fs + es;
                Log.i("MyActivity", "" + total);
                total = ts + ps + fs + es;
                if(total < 16) {
                    switch(v.getId()) {
                        case R.id.add_pilot:
                            ps++;
                            changeText.setText("" + ps);
                            total = ts + ps + fs + es;
                            Log.i("PS", "" + ps);
                            Log.i("MyActivity", "" + total);
                            break;
                        case R.id.add_trader:
                            ts++;
                            changeText.setText("" + ts);
                            total = ts + ps + fs + es;
                            Log.i("TS", "" + ts);
                            Log.i("MyActivity", "" + total);
                            break;
                        case R.id.add_fighter:
                            fs++;
                            changeText.setText("" + fs);
                            total = ts + ps + fs + es;
                            Log.i("FS", "" + fs);
                            Log.i("MyActivity", "" + total);
                            break;
                        case R.id.add_engineer:
                            es++;
                            changeText.setText("" + es);
                            total = ts + ps + fs + es;
                            Log.i("ES", "" + es);
                            Log.i("MyActivity", "" + total);
                    }
                }
            }
        });
    }
    public void onCreatePressed(View view) {
        if((ps + ts + es + fs) == 16 ) {
            player = new Player();
            player.setCurrency(1000);
            player.setDifficulty(Difficulty.EASY);

            String name = nameField.getText().toString();
            String shipName = shipField.getText().toString();
            if (!name.isEmpty() && !shipName.isEmpty()) {
                player.setName(name);
                ship.setName(shipName);
            } else if(name.isEmpty() && !shipName.isEmpty()) {
                ship.setName(shipName);
            } else if(!name.isEmpty() && shipName.isEmpty()) {
                player.setName(name);
            }

            ship.setShipType(ShipTypes.GNAT);

            player.setSkills(Skills.PILOT, Integer.parseInt(pilotSkills.getText().toString()));
            player.setSkills(Skills.FIGHTER, Integer.parseInt(fighterSkills.getText().toString()));
            player.setSkills(Skills.TRADER, Integer.parseInt(traderSkills.getText().toString()));
            player.setSkills(Skills.ENGINEER, Integer.parseInt(engineerSkills.getText().toString()));

            player.setDifficulty((Difficulty) majorSpinner.getSelectedItem());

            player.setShip(ship);

            playerViewModel.addPlayer(player);
            shipViewModel.addShip(ship);

            Log.i("MyActivity", player.toString());

            Button btn = (Button) findViewById(R.id.create_button);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(PlayerCreation.this, GeneratingUniverse.class));
                }
            });

        } else {
            Log.i("MyActivity", "Pleas make sure you've used all your skills!");
        }
    }

    public void onExitPressed(View view) {
        Button changeButton = (Button) findViewById(R.id.exit_button);
        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }
}