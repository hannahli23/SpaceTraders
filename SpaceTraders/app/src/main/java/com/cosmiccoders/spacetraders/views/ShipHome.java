package com.cosmiccoders.spacetraders.views;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.TextView;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.RadioGroup;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.cosmiccoders.spacetraders.R;
import com.cosmiccoders.spacetraders.viewmodels.EditShipHomeViewModel;

public class ShipHome extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{

    private EditShipHomeViewModel viewModel;

    private TextView playerName;

    private RadioGroup radioGroup;
    private RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ship_home);
        Button btn = (Button) findViewById(R.id.go_places);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(ShipHome.this, v);
                popup.setOnMenuItemClickListener(ShipHome.this);
                popup.inflate(R.menu.go_places_menu);
                popup.show();
            }
        });
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        Toast.makeText(this, "Selected Item: " + item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.go_market:
                Log.i("Testing: ", "Yay!");
                startActivity(new Intent(ShipHome.this, MarketPlace.class));
                return true;
            case R.id.go_ship:
                // do your code
                return true;
            case R.id.go_bank:
                // do your code
                return true;
            case R.id.go_police:
                // do your code
                return true;
            default:
                return false;
        }
    }

}
