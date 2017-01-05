package com.home.yassine.leagueofandroid.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by Yassine on 05/01/2017.
 */

public class Utils {

    /**
     * Show keyboard of a View
     *
     * @param context Application context
     * @param view    Edit text or another view that you want hide the keyboard
     */
    public static void showKeyboard(Context context, @NonNull View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
    }


    /**
     * Hide keyboard of a View
     *
     * @param context Application context
     * @param view    Edit text or another view that you want hide the keyboard
     */
    public static void hideKeyboard(Context context, @NonNull View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    public static boolean isConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager
                .getActiveNetworkInfo();

        return activeNetworkInfo != null;
    }
}
