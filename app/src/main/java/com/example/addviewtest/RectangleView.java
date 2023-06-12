package com.example.addviewtest;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import java.util.Random;

public class RectangleView extends View {
    public RectangleView(Context context) {
        super(context);

        this.setBackgroundColor(createViewColor());
        this.setId(View.generateViewId());
        LinearLayout.LayoutParams verticalParams = new LinearLayout.LayoutParams(200, 250);
        verticalParams.setMargins(0, 0, 0, 1);
        this.setLayoutParams(verticalParams);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.e("RectangleView", "ID " + this.getId());
    }

    int createViewColor() {
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }
}
