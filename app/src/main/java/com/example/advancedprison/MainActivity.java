package com.example.advancedprison;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Prisoner> prisonerList;
    private List<String> prisonerInfo = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Prison myFantasticPrison = new Prison(this);

        prisonerList = myFantasticPrison.getPrisonerList();

        Collections.sort(prisonerList, new Comparator<Prisoner>() {
            @Override
            public int compare(Prisoner p1, Prisoner p2) {
                return p1.getName().compareTo(p2.getName());
            }
        });

        System.out.println(myFantasticPrison.getPrisonerList().size());

        DataPrisonerAdapter adapter = new DataPrisonerAdapter(this, prisonerList);
        ListView listView = findViewById(android.R.id.list);
        listView.setAdapter(adapter);
    }
}
