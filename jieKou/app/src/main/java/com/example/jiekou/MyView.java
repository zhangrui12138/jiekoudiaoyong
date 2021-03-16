package com.example.jiekou;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class MyView extends View {
    interface myinterface {
        void add(int a, int b);

        void multi(int a, int b);
    }

    private myinterface myinterface;
    private int a;
    private int b;
    private Paint paint;
    private int viewWidth = 0;
    private int viewHeight = 0;

    public MyView(Context context, myinterface myinterface) {
        super(context);
        this.myinterface = myinterface;
        setBackgroundColor(Color.parseColor("#aaadadad"));
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.parseColor("#aa000000"));
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                myinterface.add(a,b);
            }
        });
        setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                myinterface.multi(a,b);
                return true;
            }
        });
    }

    public void init(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText("a=" + a + "///b=" + b, viewWidth / 3, viewHeight / 2, paint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        viewWidth = w;
        viewHeight = h;
    }


}
