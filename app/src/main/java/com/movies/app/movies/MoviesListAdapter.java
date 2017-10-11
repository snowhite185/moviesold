package com.movies.app.movies;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.movies.app.movies.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Anusha on 10/10/2017.
 * <p>
 * Adapter class for movie list recycler view
 */

public class MoviesListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> movieList;
    private Context context;

    public MoviesListAdapter(List<String> movieList, Context context) {
        this.movieList = movieList;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item,
                parent, false);
        return new MovieListVH(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MovieListVH movieListVH = (MovieListVH) holder;
        String imageUrl = movieList.get(position);
        Picasso.with(context).setLoggingEnabled(true);
        Picasso.with(context).load(imageUrl).placeholder(R
                .drawable.poster_placeholder).into(movieListVH.imgMoviePoster);
    }

    @Override
    public int getItemCount() {
        return movieList == null ? 0 : movieList.size();
    }

    static class MovieListVH extends RecyclerView.ViewHolder {

        private ImageView imgMoviePoster;

        public MovieListVH(View itemView) {
            super(itemView);
            imgMoviePoster = itemView.findViewById(R.id.imgMoviePoster);
        }
    }
}
