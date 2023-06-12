package com.example.addviewtest;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
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

        binding.fabPlus.setOnClickListener(view -> addView(verticalLayout));
        binding.fabMinus.setOnClickListener(view -> removeView(verticalLayout));
    }

    void addView(LinearLayout layout) {
        View rectangleView = new View(this);
        rectangleView.setBackgroundColor(createViewColor());
        rectangleView.setId(View.generateViewId());
        LinearLayout.LayoutParams verticalParams = new LinearLayout.LayoutParams(200, 250);
        verticalParams.setMargins(0, 0, 0, 1);
        rectangleView.setLayoutParams(verticalParams);
        layout.addView(rectangleView);
        Log.e("ADD", "ID : " + rectangleView.getId());
    }

    void removeView(LinearLayout layout) {
        final int childCount = layout.getChildCount();
        if (childCount > 0) {
            View rectangleView = layout.getChildAt(childCount - 1);
            Log.e("REMOVE", "ID : " + rectangleView.getId());
            layout.removeView(rectangleView);
        } else {
            Log.e("REMOVE", "Layout has no children");
        }
    }

    int createViewColor() {
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }
}