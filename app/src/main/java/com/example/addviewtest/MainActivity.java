package com.example.addviewtest;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import com.example.addviewtest.databinding.ActivityMainBinding;

import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ScrollView scrollView = findViewById(R.id.scrollView);

        LinearLayout verticalLayout = new LinearLayout(this.getApplicationContext());
        verticalLayout.setOrientation(LinearLayout.VERTICAL);
        scrollView.addView(verticalLayout);

        binding.fab.setOnClickListener(view -> addView(verticalLayout));
    }

    void addView(LinearLayout layout) {
        Random rnd = new Random();
        View rectangleView = new View(this);
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        rectangleView.setBackgroundColor(color);
        LinearLayout.LayoutParams verticalParams = new LinearLayout.LayoutParams(200, 250);
        verticalParams.setMargins(0, 0, 0, 1);
        rectangleView.setLayoutParams(verticalParams);
        layout.addView(rectangleView);
    }
}