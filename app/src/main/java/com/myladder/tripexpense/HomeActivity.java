package com.myladder.tripexpense;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        
         Multimap<String, Integer> scores = HashMultimap.create();
        scores.put("Bob", 20);
        scores.put("Bob", 10);
        scores.put("Bob", 15);
        System.out.println(Collections.max(scores.get("Bob"))); // prints 20
    }
}
