package com.example.thebook;

import android.app.Activity;
import android.content.SharedPreferences;

public class TitlePreferences {

    private static final String PREFERENCE_NAME = "index";
    private static final String TITLE_NAME = "";
    private SharedPreferences preferences;

    public TitlePreferences(Activity activity) {
        preferences = activity.getPreferences(Activity.MODE_PRIVATE);
    }

    public String getTitleName() {
        return preferences.getString(PREFERENCE_NAME, TITLE_NAME);
    }

    public void setTitleName(String title) {
        preferences.edit().putString(PREFERENCE_NAME, title).apply();
    }
}
