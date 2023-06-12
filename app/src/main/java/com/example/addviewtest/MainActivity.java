package com.example.addviewtest;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import com.example.addviewtest.databinding.ActivityMainBinding;

import android.widget.LinearLayout;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ScrollView scrollView = findViewById(R.id.scrollView);

        LinearLayout verticalLayout = new VerticalLayout(this.getApplicationContext());
        scrollView.addView(verticalLayout);

        binding.fabPlus.setOnClickListener(view -> addTextView(verticalLayout));
        binding.fabMinus.setOnClickListener(view -> removeView(verticalLayout));
    }

    void addRectangleView(LinearLayout layout) {
        View rectangleView = new RectangleView(this);
        layout.addView(rectangleView);
    }

    void addTextView(LinearLayout layout) {
        View rectangleView = new CustomTextView(this, "test");
        layout.addView(rectangleView);
    }

    void removeView(LinearLayout layout) {
        final int childCount = layout.getChildCount();
        if (childCount > 0) {
            View view = layout.getChildAt(childCount - 1);
            Log.e("REMOVE VIEW", "ID " + view.getId());
            layout.removeView(view);
        } else {
            Log.e("REMOVE VIEW", "Layout has no children");
        }
    }
}