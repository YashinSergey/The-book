package com.example.thebook.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.thebook.MainActivity;
import com.example.thebook.R;
import com.example.thebook.TitlePreferences;

public class BodyFragment extends Fragment {

    private static final String TAG = "BodyFragment";
    private MainActivity activity;
    private WebView webView;
    private String baseUri = "file:///android_asset/";
    private String extension = ".html";
    //    D:\Programming\The-book\app\src\main\assets\1.Debut_in_Echo.html

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.body_fragment, container, false);
        activity = (MainActivity) getActivity();
        TitlePreferences preferences = new TitlePreferences(activity);

        webView = view.findViewById(R.id.webView);
        if (!preferences.getTitleName().equals("")) {
            String uri = baseUri + preferences.getTitleName() + extension;
            webView.loadUrl(uri);
            WebSettings webSettings = webView.getSettings();
            webSettings.setBuiltInZoomControls(true);
            webSettings.setDisplayZoomControls(false);
            webSettings.setJavaScriptEnabled(true);
        }


        return view;
    }
}
