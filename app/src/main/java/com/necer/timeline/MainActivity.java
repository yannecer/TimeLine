package com.necer.timeline;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    private TimeLine timeLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timeLine = (TimeLine) findViewById(R.id.timeLine);


        Map<Integer, List<String>> map = new HashMap<>();

        List<String> li6 = new ArrayList<>();
        li6.add("06:50");
        li6.add("06:80");
        li6.add("06:90");

        map.put(6, li6);


        List<String> li18 = new ArrayList<>();

        li18.add("18:10");
        li18.add("18:50");

        map.put(18, li18);


        timeLine.setTimeMap(map);

    }

    public void set(View view) {


        Map<Integer, List<String>> map = new HashMap<>();

        List<String> li7 = new ArrayList<>();
        li7.add("07:50");
        li7.add("07:80");
        li7.add("07:90");

        map.put(7, li7);


        List<String> li20 = new ArrayList<>();

        li20.add("20:10");
        li20.add("20:50");
        map.put(20, li20);

        List<String> li23 = new ArrayList<>();

        li23.add("23:10");
        li23.add("23:50");

        //23点的key是-1
        map.put(-1, li23);

        timeLine.setTimeMap(map);

    }
}
