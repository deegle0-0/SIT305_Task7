package com.example.task7;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.task7.Activities.AllAds;
import com.example.task7.Activities.newAdvertActivity;
import com.example.task7.adapter.AdvertListAdapter;
import com.example.task7.adapter.AdvertViewModel;
import com.example.task7.data.Advert;

public class MainActivity extends AppCompatActivity {

    Button newAd,showAds;
    private AdvertViewModel advertViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newAd = findViewById(R.id.createAd);
        showAds = findViewById(R.id.showAll);

        advertViewModel = new ViewModelProvider(this).get(AdvertViewModel.class);



        showAds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AllAds.class);
                startActivity(intent);
            }
        });

        newAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, newAdvertActivity.class);
                startActivityForResult(intent1, 1);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
                Advert advert1 = new Advert(0, data.getStringExtra("add_value1"),
                        data.getStringExtra("add_value2"),data.getStringExtra("add_value3"),
                        data.getStringExtra("add_value4"),data.getStringExtra("add_value5"),
                        data.getBooleanExtra("add_value6",false));

                advertViewModel.Insert(advert1);
        }
    }
}