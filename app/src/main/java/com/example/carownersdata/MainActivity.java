package com.example.carownersdata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.ServiceConfigurationError;
import java.util.concurrent.atomic.LongAdder;

public class MainActivity extends AppCompatActivity implements CarAdapter.ItemClicked {

    Button btnCar, btnOwner;
    TextView tvNameD, tvNumberD, tvCarD, tvOwner;
    ImageView ivBrandD;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCar = findViewById(R.id.btnCar);
        btnOwner = findViewById(R.id.btnOwner);
        tvCarD = findViewById(R.id.tvCarD);
        tvNameD = findViewById(R.id.tvNameD);
        tvNumberD = findViewById(R.id.tvNumberD);
        ivBrandD = findViewById(R.id.ivBrandD);
        tvOwner = findViewById(R.id.tvOwner);



        tvCarD.setVisibility(View.GONE);
        tvNameD.setVisibility(View.GONE);
        tvNumberD.setVisibility(View.GONE);
        ivBrandD.setVisibility(View.GONE);
        tvOwner.setVisibility(View.GONE);

        if(findViewById(R.id.layout_potrait) != null){

            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.fragment))
                    .hide(manager.findFragmentById(R.id.fragment2))
                    .commit();
        }

        if(findViewById(R.id.layout_landscape) != null){
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.fragment))
                    .show(manager.findFragmentById(R.id.fragment2))
                    .commit();

        }


        btnCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tvCarD.setVisibility(View.VISIBLE);
                ivBrandD.setVisibility(View.VISIBLE);
                tvNameD.setVisibility(View.GONE);
                tvNumberD.setVisibility(View.GONE);
                tvOwner.setVisibility(View.GONE);


            }
        });

        btnOwner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tvOwner.setVisibility(View.VISIBLE);
                tvNameD.setVisibility(View.VISIBLE);
                tvNumberD.setVisibility(View.VISIBLE);
                tvCarD.setVisibility(View.GONE);
                ivBrandD.setVisibility(View.GONE);

            }
        });



    }



    @Override
    public void Onitemclicked(int index) {
        tvCarD.setVisibility(View.GONE);
        tvOwner.setVisibility(View.VISIBLE);
        tvNameD.setVisibility(View.VISIBLE);
        tvNumberD.setVisibility(View.VISIBLE);
        ivBrandD.setVisibility(View.GONE);


        tvNameD.setText(MyApplication.cars.get(index).getName());
        tvNumberD.setText(MyApplication.cars.get(index).getNumber());
        tvCarD.setText(MyApplication.cars.get(index).getCarname() +"\n\n" +  MyApplication.cars.get(index).getCardetail());

        if(MyApplication.cars.get(index).getPreferences().equals("Mercedes"))

            ivBrandD.setImageResource(R.drawable.mercedes);
        else if(MyApplication.cars.get(index).getPreferences().equals("Nissan"))
            ivBrandD.setImageResource(R.drawable.nissan);
        else
            ivBrandD.setImageResource(R.drawable.volkswagen);


        if(findViewById(R.id.layout_potrait) != null){

            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.fragment))
                    .show(manager.findFragmentById(R.id.fragment2))
                    .addToBackStack(null)
                    .commit();
             }


    }

}