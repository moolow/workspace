package com.example.june.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    //  setContentView(R.layout.activity_canvas);
        setContentView(new MyView(this));

    }

    class MyView extends View {
        int width, height;
        int bw, bh;
        Bitmap image;

        public MyView(Context context) {
            super(context);
            Display display = ((WindowManager) context.getSystemService
                    (Context.WINDOW_SERVICE)).getDefaultDisplay();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 4;
            Point point = new Point();
            display.getSize(point);
            width = point.x;
            height = point.y;
            image = BitmapFactory.decodeResource(context.getResources(),
                    R.drawable.moon,
                    options);
            bw = image.getWidth() / 2;
            bh = image.getHeight() / 2;
        }

        public void onDraw(Canvas canvas) {
            canvas.drawBitmap(image, width / 2 - bw, height / 2 - bh, null);
        }
    } // MyView
} // Activity
