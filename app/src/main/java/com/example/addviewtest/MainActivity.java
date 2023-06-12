package com.example.addviewtest;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import com.example.addviewtest.databinding.ActivityMainBinding;

import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private List<Integer> viewIds;

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

        viewIds = new ArrayList<>();
    }

    void addView(LinearLayout layout) {
        View rectangleView = new View(this);
        rectangleView.setBackgroundColor(createViewColor());
        rectangleView.setId(View.generateViewId());
        LinearLayout.LayoutParams verticalParams = new LinearLayout.LayoutParams(200, 250);
        verticalParams.setMargins(0, 0, 0, 1);
        rectangleView.setLayoutParams(verticalParams);
        viewIds.add(rectangleView.getId());
        layout.addView(rectangleView);
        Log.e("ADD", "ID : " + rectangleView.getId());
        Log.e("LIST", viewIds.toString());
    }

    void removeView(LinearLayout layout) {
        if (viewIds.size() > 0) {
            int lastId = viewIds.get(viewIds.size() - 1);
            View rectangleView = findViewById(lastId);
            layout.removeView(rectangleView);
            viewIds.remove(viewIds.size() - 1);
            Log.e("REMOVE", "ID : " + lastId);
            Log.e("LIST", viewIds.toString());
        } else {
            Log.e("REMOVE", "list empty");
        }
    }

    int createViewColor() {
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        return color;
    }
}