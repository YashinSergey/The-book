package com.example.thebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "MainActivity";

    private ArrayList<String> titleList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleList = new ArrayList<>();
        fillTheList(titleList);

        recyclerView = findViewById(R.id.title_recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        TitleAdapter titleAdapter = new TitleAdapter(this, titleList, new CustomItemClickListener() {
            @SuppressLint("ShowToast")
            @Override
            public void onItemClick(View v, int position) {
                Toast.makeText(getApplicationContext(), titleList.get(position), Toast.LENGTH_SHORT);
            }
        });

        recyclerView.setAdapter(titleAdapter);
    }

    private void fillTheList(ArrayList<String> list) {
        list.add(Constants.DEBUT_IN_ECHO);
        list.add(Constants.JUBA_CHEBOBARGO);
        list.add(Constants.PRISON_SELL);
        list.add(Constants.ALIEN);
        list.add(Constants.THE_KING_OF_BANJA);
        list.add(Constants.VICTIMS_OF_CIRCUMSTANCES);
        list.add(Constants.TRAVELING_TO_KETTARY);
    }
}
