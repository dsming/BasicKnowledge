package com.example.basicknowledge;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class CanvasView {
    Paint mPaint;
    Canvas canvas;

    public void setmPaint(Paint mPaint) {
        this.mPaint = mPaint;
    }

    public Paint getmPaint() {
        return mPaint;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void drawView(int x, int y){

    }

    public void rotate(float degrees){
        mPaint.setColor(Color.RED);
    }
}
