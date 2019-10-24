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

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;


public class BodyFragment extends Fragment {

    private static final String TAG = "BodyFragment";

    private MainActivity activity;
    private WebView webView;
    private String baseUri = "file:///android_asset/";
    private String extension = ".html";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.body_fragment, container, false);
        activity = (MainActivity) getActivity();

        webView = view.findViewById(R.id.webView);
        webView.setBackgroundColor(0x00000000);

        if (activity.singlePreferences != null) {
            activity.singlePreferences.subscribe(observerPref);
        }
        return view;
    }

    private SingleObserver<String> observerPref = new SingleObserver<String>() {
        @Override
        public void onSubscribe(Disposable d) {

        }
        @Override
        public void onSuccess(String s) {
            setWebView(baseUri + s + extension);
        }
        @Override
        public void onError(Throwable e) {
            e.printStackTrace();
        }
    };

    @SuppressLint("SetJavaScriptEnabled")
    private void setWebView(String uri) {
        webView.loadUrl(uri);
        WebSettings webSettings = webView.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setJavaScriptEnabled(true);
    }
}
