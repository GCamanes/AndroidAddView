package com.example.addviewtest;

import android.content.Context;
import android.util.Log;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class VerticalLayout extends LinearLayout {
    public VerticalLayout(Context context) {
        super(context);
        this.setOrientation(LinearLayout.VERTICAL);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        Log.d("LAYOUT", "CHILDREN : "  + getAllIds());
    }

    String getAllIds() {
        List<Integer> ids = new ArrayList<>();
        int count = this.getChildCount();
        for (int i = 0; i < count; i++) {
            ids.add(this.getChildAt(i).getId());
        }
        return ids.toString();
    }
}
