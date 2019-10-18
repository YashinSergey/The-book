package com.example.thebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;

import com.example.thebook.fragments.TitleFragment;


public class MainActivity extends AppCompatActivity {

    private static String TAG = "MainActivity";
    private TitleFragment titleFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFragments(savedInstanceState);

    }

    private void initFragments(Bundle savedInstanceState) {
        titleFragment = new TitleFragment();
        if (savedInstanceState == null) {
            replaceFragment(titleFragment);
        }
    }

    public void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container_for_fragments, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
