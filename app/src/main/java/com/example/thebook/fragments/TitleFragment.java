package com.example.thebook.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thebook.Constants;
import com.example.thebook.CustomItemClickListener;
import com.example.thebook.MainActivity;
import com.example.thebook.R;
import com.example.thebook.TitleAdapter;

import java.util.ArrayList;

public class TitleFragment extends Fragment {

    private ArrayList<String> titleList;
    private RecyclerView recyclerView;
    private MainActivity activity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tital_fragment, container, false);
        activity =(MainActivity) getActivity();
        titleList = new ArrayList<>();

        fillTheList(titleList);

        TitleAdapter titleAdapter = new TitleAdapter(activity.getApplicationContext(), titleList,
                getClickListener());

        initRecyclerView(view, titleAdapter);
        return view;
    }

    private void initRecyclerView(View view, TitleAdapter titleAdapter) {
        recyclerView = view.findViewById(R.id.title_recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity.getApplicationContext()));
        recyclerView.setAdapter(titleAdapter);
    }

    private CustomItemClickListener getClickListener() {
        return new CustomItemClickListener() {
                @SuppressLint("ShowToast")
                @Override
                public void onItemClick(View v, int position) {
                    Toast.makeText(activity.getApplicationContext(), titleList.get(position).replace("_", " "), Toast.LENGTH_SHORT).show();
                }
            };
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
