package com.example.task7.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.task7.R;
import com.example.task7.adapter.AdvertListAdapter;
import com.example.task7.adapter.AdvertViewModel;

public class AllAds extends AppCompatActivity {

    private AdvertViewModel advertViewModel;

    AdvertListAdapter listAdapter;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_ads);

        recyclerView = findViewById(R.id.recyclerview);

        advertViewModel = new ViewModelProvider(AllAds.this).get(AdvertViewModel.class);

        listAdapter = new AdvertListAdapter(new AdvertListAdapter.AdvertDiff(),
                this,advertViewModel);

        recyclerView.setAdapter(listAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    @Override
    protected void onResume() {
        super.onResume();
        advertViewModel.getFoundList().observe(this, students -> {
            //update the cached copy of the words in the adapter
            listAdapter.submitList(students);
        });
    }

}