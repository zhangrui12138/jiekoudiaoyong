package com.example.jiekou;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyView.myinterface {
    @Override
    public void add(int a, int b) {
        Toast.makeText(this,"a + b="+(a + b),Toast.LENGTH_LONG).show();
    }

    @Override
    public void multi(int a, int b) {
        Toast.makeText(this,"a * b="+(a * b),Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyView myView = new MyView(MainActivity.this,this);
        myView.init(10,12);
        addContentView(myView,new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }

}