package com.cosmiccoders.spacetraders.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cosmiccoders.spacetraders.entity.Difficulty;
import com.cosmiccoders.spacetraders.entity.Person;
import com.cosmiccoders.spacetraders.entity.Ship;


import com.cosmiccoders.spacetraders.R;
import com.cosmiccoders.spacetraders.entity.Skills;
import com.cosmiccoders.spacetraders.viewmodels.EditAddPlayerModel;

public class MainActivity extends AppCompatActivity {

    private EditAddPlayerModel viewModel;

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

    private Person person;
    private Ship ship;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //shipField = findViewById(R.id.ship_name_field);
        //nameField = findViewById(R.id.name_field);

        pilotSkills = findViewById(R.id.pilot_points);
        traderSkills = findViewById(R.id.trader_points);
        engineerSkills = findViewById(R.id.engineer_points);
        fighterSkills = findViewById(R.id.fighter_points);

        ps = Integer.parseInt(pilotSkills.getText().toString());
        ts = Integer.parseInt(traderSkills.getText().toString());
        fs = Integer.parseInt(fighterSkills.getText().toString());
        es = Integer.parseInt(engineerSkills.getText().toString());
        System.out.println(ps);

        //pilotSkills =
        Button button = findViewById(R.id.create_button);
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
                switch(v.getId()) {
                    case R.id.subtract_pilot:
                        if (ps > 0) {
                            ps--;
                            changeText.setText("" + ps);
                        }
                    case R.id.subtract_trader:
                        if(ts > 0) {
                            ts--;
                            changeText.setText("" + ts);
                        }
                    case R.id.subtract_fighter:
                        if(fs > 0) {
                            fs--;
                            changeText.setText("" + fs);
                        }
                    case R.id.subtract_engineer:
                        if(es > 0) {
                            es--;
                            changeText.setText("" + es);
                        }
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
                final int total = ts + ps + fs + es;
                if(total < 16) {
                    switch(v.getId()) {
                        case R.id.add_pilot:
                            ps++;
                            changeText.setText("" + ps);
                            break;
                        case R.id.add_trader:
                            ts++;
                            changeText.setText("" + ts);
                            break;
                        case R.id.add_fighter:
                            fs++;
                            changeText.setText("" + fs);
                            break;
                        case R.id.add_engineer:
                            es++;
                            changeText.setText("" + es);
                    }
                }
            }
        });
    }

    public void onCreatPressed(View view) {
        person.setCurrency(1000);
        person.setDifficulty(Difficulty.EASY);
        person.setName(nameField.getText().toString());
        person.setSkills(Skills.PILOT, Integer.parseInt(pilotSkills.getText().toString()));
        person.setSkills(Skills.FIGHTER, Integer.parseInt(fighterSkills.getText().toString()));
        person.setSkills(Skills.TRADER, Integer.parseInt(traderSkills.getText().toString()));
        person.setSkills(Skills.ENGINEER, Integer.parseInt(engineerSkills.getText().toString()));
    }
}
