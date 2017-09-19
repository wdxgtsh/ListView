package com.example.zhaolei.listview;

import android.content.Intent;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.githang.statusbar.StatusBarCompat;

public class MainActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StatusBarCompat.setStatusBarColor(this, R.color.defaultColor);


    }

    public void interfaceClick (View v) {
        Toast.makeText(this, "interfaceClick", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, SubscribeActivity.class);
        startActivity(intent);
    }


    public void abstractClick (View v) {
        Toast.makeText(this, "abstractClick", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, MySubscribeActivity.class);
        startActivity(intent);
    }

    public void tabbarClick (View v) {
        Toast.makeText(this, "tabbarClick", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, TabbarActivity.class);
        startActivity(intent);

    }


}
