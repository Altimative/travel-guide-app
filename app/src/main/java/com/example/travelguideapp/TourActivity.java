package com.example.travelguideapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class TourActivity extends AppCompatActivity {

    private EditText budgetField, timeField;
    private TextView yourTour;
    private ListView listView;
    private Button createTour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour);

        ArrayList<Attraction> attractions = getIntent().getParcelableArrayListExtra("attractions");

        budgetField = findViewById(R.id.budgetField);
        timeField = findViewById(R.id.timeField);

        yourTour = findViewById(R.id.textView11);

        listView = findViewById(R.id.listView2);

        createTour = findViewById(R.id.createTourButton);

        createTour.setOnClickListener(v -> {
            if (!budgetField.getText().toString().equals("") && !timeField.getText().toString().equals("")) {
                yourTour.setText("Ваш тур:");

                ArrayList<Attraction> tour = new ArrayList<>();
                double budget = Double.parseDouble(budgetField.getText().toString());
                double time = Double.parseDouble(timeField.getText().toString());

                Collections.shuffle(attractions);

                for (int i = 0; i < attractions.size(); i++) {
                    if (budget >= attractions.get(i).getTicketPrice() && time >= attractions.get(i).getDurationOfInspection()) {
                        tour.add(attractions.get(i));
                        budget -= attractions.get(i).getTicketPrice();
                        time -= attractions.get(i).getDurationOfInspection();
                    }
                }

                ArrayAdapter<Attraction> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tour);
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
                        Intent intent = new Intent(TourActivity.this, AttractionActivity.class);
                        intent.putExtra("attraction", tour.get(position));
                        startActivity(intent);
                    }
                });
            } else
                Toast.makeText(TourActivity.this, "Введите данные, пожалуйста.", Toast.LENGTH_LONG).show();
        });
    }
}