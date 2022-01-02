package com.example.dz5.dz5.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.dz5.R;
import com.example.dz5.dz5.ui.fragments.first_fragment.FirstFragment;
import com.example.dz5.dz5.ui.fragments.second_fragment.SecondFragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState== null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container_fragment,new FirstFragment()).commit();
        }

        if (savedInstanceState== null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container_fragment1,new SecondFragment()).commit();
        }


    }






}