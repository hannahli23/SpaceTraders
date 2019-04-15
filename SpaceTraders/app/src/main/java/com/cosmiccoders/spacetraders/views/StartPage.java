package com.cosmiccoders.spacetraders.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.cosmiccoders.spacetraders.R;

/**
 * Class representing the start page capabilities of the game
 */
public class StartPage extends AppCompatActivity {

    /*
       This function makes everything upon pressing the create button
       @param savedInstanceState The state of the saved game
      */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_page);

    }
    /**
     * This function loads the page once the player clicks the load button
     * @param v The games current view
     */
    public void onLoadPageClick(View v) {
        Button btn = findViewById(R.id.load);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartPage.this, LoadGame.class));
            }
        });
    }
    /**
     * This function creates the page once the create button is clicked
     * @param v The games current view
     */
    public void onCreatePageClick(View v) {
        Button btn = findViewById(R.id.create);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartPage.this, PlayerCreation.class));
            }
        });
    }

}
