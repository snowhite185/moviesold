package com.movies.app.movies.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.movies.app.movies.R;

/**
 * Created by Anusha on 10/11/2017.
 *
 * Utils class for all configuration methods.
 * All common methods used in application can be created here.
 */

public class Utils {

    public static void replaceFragment(FragmentManager fragmentManager, Fragment fragment, String tag) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, fragment, tag);
        transaction.commit();
    }

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager conMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo.State mobileState = conMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState();
        NetworkInfo.State WifiState = conMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState();
        if (mobileState == NetworkInfo.State.CONNECTED || WifiState == NetworkInfo.State.CONNECTED) {
            return true;
        }
        return false;
    }


    public static boolean isTablet(Context context) {
        return context.getResources().getBoolean(R.bool.isTablet);
    }
}
