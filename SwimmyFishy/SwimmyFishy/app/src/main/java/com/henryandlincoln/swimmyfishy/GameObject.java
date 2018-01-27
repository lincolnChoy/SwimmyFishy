package com.henryandlincoln.swimmyfishy;

import android.graphics.Canvas;

public interface GameObject {

    public void draw(Canvas canvas);
    public void update();
    public int getX();
    public int getY();
}
