package com.example.addviewtest;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class CustomTextView extends androidx.appcompat.widget.AppCompatTextView {
    public CustomTextView(Context context) {
        super(context);

        this.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    public CustomTextView(Context context, String text) {
        super(context);
        this.setText(text);
        this.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.e("CustomTextView", "ID " + this.getId());
    }
}
