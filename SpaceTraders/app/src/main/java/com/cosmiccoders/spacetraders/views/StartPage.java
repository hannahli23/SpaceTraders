package com.cosmiccoders.spacetraders.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.cosmiccoders.spacetraders.R;

public class StartPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_page);

    }

    public void onLoadPageClick(View v) {
        Button btn = findViewById(R.id.load);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartPage.this, LoadGame.class));
            }
        });
    }

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
