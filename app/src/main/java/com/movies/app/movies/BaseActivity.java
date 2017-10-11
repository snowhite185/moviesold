package com.movies.app.movies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.movies.app.movies.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Utils.replaceFragment(getSupportFragmentManager(),new MovieListFragment(),
                MovieListFragment.class.getName());
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
////                        .setAction("Action", null).show();
//            }
//        });

    }



    private List<String> addMockData() {
        List<String> strings = new ArrayList<>();
        strings.add("https://api.androidhive.info/json/movies/1.jpg");
        strings.add("https://api.androidhive.info/json/movies/1.jpg");
        strings.add("https://api.androidhive.info/json/movies/1.jpg");
        strings.add("https://api.androidhive.info/json/movies/1.jpg");
        strings.add("https://api.androidhive.info/json/movies/1.jpg");
        strings.add("https://api.androidhive.info/json/movies/1.jpg");
        strings.add("https://api.androidhive.info/json/movies/1.jpg");
                return strings;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
