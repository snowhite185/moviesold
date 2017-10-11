package com.movies.app.movies.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.movies.app.movies.R;

/**
 * Created by Anusha on 10/11/2017.
 */

public class Utils {

    public static void replaceFragment(FragmentManager fragmentManager, Fragment fragment, String tag) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, fragment, tag);
        transaction.commit();
    }

    public static void replaceAndAddToBackStack(FragmentManager fragmentManager, Fragment fragment, String tag) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, fragment, tag);
        transaction.addToBackStack(tag);
        transaction.commit();
    }
}
