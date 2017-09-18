package com.example.zhaolei.listview;

import android.content.Intent;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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



}
