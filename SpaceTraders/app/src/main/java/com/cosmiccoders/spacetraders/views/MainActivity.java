package com.cosmiccoders.spacetraders.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.view.View.OnClickListener;
import com.cosmiccoders.spacetraders.entity.Difficulty;
import com.cosmiccoders.spacetraders.entity.Person;
import com.cosmiccoders.spacetraders.entity.Ship;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.cosmiccoders.spacetraders.R;
import com.cosmiccoders.spacetraders.entity.ShipTypes;
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
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //addListenerOnButton();

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
        System.out.println(ps);

        //pilotSkills =
        //Button button = findViewById(R.id.create_button);
    }

    /*public void addListenerOnButton() {
        radioGroup= findViewById(R.id.radioGroup);
        textView= findViewById(R.id.text_view_selected);
        Button apply = findViewById(R.id.create_button);
        apply.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View t) {
                int radioID = radioGroup.getCheckedRadioButtonId();

                radioButton = findViewById(radioID);

                Toast.makeText(getApplicationContext(), "Selected Radio Button: " + radioButton.getText(), Toast.LENGTH_SHORT);
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_one:
                if (checked) {

                }
                break;
            case R.id.radio_two:
                if (checked) {
                }
                break;
            case R.id.radio_three:
                if (checked) {
                }
                break;
        }
    }*/

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
        person.setCurrency(1000);
        person.setDifficulty(Difficulty.EASY);
        person.setName(nameField.getText().toString());
        person.getShip().setName(shipField.getText().toString());
        person.getShip().setShipType(ShipTypes.GNAT);

        person.setSkills(Skills.PILOT, Integer.parseInt(pilotSkills.getText().toString()));
        person.setSkills(Skills.FIGHTER, Integer.parseInt(fighterSkills.getText().toString()));
        person.setSkills(Skills.TRADER, Integer.parseInt(traderSkills.getText().toString()));
        person.setSkills(Skills.ENGINEER, Integer.parseInt(engineerSkills.getText().toString()));

        Log.i("MyActivity", person.toString());

        finish();
    }

}