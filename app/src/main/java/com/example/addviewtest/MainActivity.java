package com.example.addviewtest;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.addviewtest.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        RelativeLayout layout = findViewById(R.id.relativeLayout);

        LinearLayout verticalLayout = new LinearLayout(this.getApplicationContext());
        verticalLayout.setOrientation(LinearLayout.VERTICAL);
        layout.addView(verticalLayout);
        Random rnd = new Random();

        for (int i = 0; i < 10; i++) {
            // Vertical item
            View verticalSquareView = new View(this);
            int verticalColor = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            verticalSquareView.setBackgroundColor(verticalColor);
            RelativeLayout.LayoutParams verticalParams = new RelativeLayout.LayoutParams(200, 250);
            verticalParams.setMargins(0, 0, 0, 1);
            verticalSquareView.setLayoutParams(verticalParams);
            verticalLayout.addView(verticalSquareView);
        }
    }
}