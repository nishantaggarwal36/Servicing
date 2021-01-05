package com.example.carownersdata;

import android.app.Application;

import java.util.ArrayList;

public class MyApplication extends Application {

   public static ArrayList<Car> cars;

    @Override
    public void onCreate() {
        super.onCreate();

        cars = new ArrayList<Car>();
        cars.add(new Car("Polo", "Black Color \n Car No - HR 3C 1295\n Dent on Back and right side\n Condition: Working", "Lokesh Garg", "78690478391", "Volkswagen"));
        cars.add(new Car("E-class", "Grey Color \n HR 23A 1346 \n Dent on Front \n Scratches ","Nikita", "87909049891", "Mercedes"));
        cars.add(new Car("G-class", "Brown Color \n HR 56AD 7823 \n no Dents \n problem with engine  ","Aashi Bansal", "00986472811", "Mercedes"));
        cars.add(new Car("Vento", "Black Color \n Car No - HR 3C 1295\n Dent on Back and right side\n Condition: Working", "Sanjay Malik", "78687478391", "Volkswagen"));
        cars.add(new Car("kicks", "Red Color \n DL 60CG 6749 \n windows stuck \n Dent on Driver's Door", "Shweta Gupta", "64758903257", "Nissan"));
        cars.add(new Car("jetta", "blue Color \n DL 70G 5678 \n Engine Not working \n SCratches to be removed" , "Kunal Aggarwal", "75678478391", "Volkswagen"));
        cars.add(new Car("GT-R", "Grey Color \n HR 23A 1346 \n Dent on Front \n Scratches", "Manish Saini", "68905647184", "Nissan"));

    }
}
