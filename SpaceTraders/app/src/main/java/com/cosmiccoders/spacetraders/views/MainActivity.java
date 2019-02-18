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

        addListenerOnButton();
    }
    public void addListenerOnButton() {
        radioGroup= findViewById(R.id.radioGroup);
        textView= findViewById(R.id.text_view_selected);
        Button apply = findViewById(R.id.create_button);
        apply.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View t) {
                int radioID = radioGroup.getCheckedRadioButtonId();

                radioButton = findViewById(radioID);

                Toast.makeText(this, "Selected Radio Button: " + radioButton.getText(), Toast.LENGTH_SHORT);
            }
        });





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
        final TextView changeText = pilotSkills;

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()) {
                    case R.id.subtract_pilot:
                        Log.d("Edit", "Subtracted");
                        if (ps != 0) {
                            ps--;
                            changeText.setText(ps);
                        }
                    case R.id.subtract_trader:
                        if(ts != 0) {
                            Log.d("Edit", "Subtracted");
                            ts--;
                            traderSkills.setText(ts);
                        }
                    case R.id.subtract_fighter:
                        if(fs != 0) {
                            Log.d("Edit", "Subtracted");
                            fs--;
                            fighterSkills.setText(fs);
                        }
                    case R.id.subtract_engineer:
                        Log.d("Edit", "Subtracted");
                        if(es != 0) {
                            es--;
                            engineerSkills.setText(ps);
                        }
                }
            }
        });
    }

    public void onAddPressed(View view) {
        final int total = ts + ps + fs + es;
        Button change = (Button) findViewById(view.getId());
        final TextView changeText = (TextView) findViewById(R.id.pilot_points);

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ps++;
                changeText.setText("Yay!");
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