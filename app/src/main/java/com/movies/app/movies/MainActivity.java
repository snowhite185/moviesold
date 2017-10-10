package com.movies.app.movies;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });
        initViews();
    }

    private void initViews() {
        rvMovies = (RecyclerView) findViewById(R.id.rvMovies);
        MoviesListAdapter adapter = new MoviesListAdapter(addMockData());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        rvMovies.setLayoutManager(gridLayoutManager);
        rvMovies.setAdapter(adapter);
    }

    private List<String> addMockData() {
        List<String> strings = new ArrayList<>();
        strings.add("http://cdn.wonderfulengineering.com/wp-content/uploads/2014/05/mobile-samsung-18-610x1084.jpg");
        strings.add("http://cdn.wonderfulengineering.com/wp-content/uploads/2014/05/mobile-samsung-18-610x1084.jpg");
        strings.add("http://cdn.wonderfulengineering.com/wp-content/uploads/2014/05/mobile-samsung-18-610x1084.jpg");
        strings.add("http://cdn.wonderfulengineering.com/wp-content/uploads/2014/05/mobile-samsung-18-610x1084.jpg");
        strings.add("http://cdn.wonderfulengineering.com/wp-content/uploads/2014/05/mobile-samsung-18-610x1084.jpg");
        strings.add("http://cdn.wonderfulengineering.com/wp-content/uploads/2014/05/mobile-samsung-18-610x1084.jpg");
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
