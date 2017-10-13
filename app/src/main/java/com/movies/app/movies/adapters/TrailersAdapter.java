package com.movies.app.movies.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.movies.app.movies.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Anusha on 10/13/2017.
 *
 * Adapter class for trailer list recycler view
 */

public class TrailersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String IMAGE_BASE_URL = "https://img.youtube.com/vi/%s/default.jpg";
    private List<String> trailerKeys;
    private List<String> trailerNames;
    private Context context;

    public TrailersAdapter(Context context,List<String> trailerKeys, List<String> trailerNames) {
        this.trailerKeys = trailerKeys;
        this.trailerNames = trailerNames;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_trailer_list_item,
                parent, false);
        return new TrailerListVH(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TrailerListVH trailerListVH = (TrailerListVH) holder;
        String key = trailerKeys.get(position);
        String name = trailerNames.get(position);
        String imageUrl = String.format(IMAGE_BASE_URL, key);
        trailerListVH.txtTrailerTitle.setText(name);
        Picasso.with(context).load(imageUrl).placeholder(R
                .drawable.poster_placeholder).into(trailerListVH.imgTrailer);
    }

    @Override
    public int getItemCount() {
        return trailerKeys == null ? 0 : trailerKeys.size();
    }

    static class TrailerListVH extends RecyclerView.ViewHolder {

        private ImageView imgTrailer;
        private TextView txtTrailerTitle;

        TrailerListVH(View itemView) {
            super(itemView);
            imgTrailer = itemView.findViewById(R.id.imgTrailer);
            txtTrailerTitle = itemView.findViewById(R.id.txtTrailerTitle);
        }
    }
}
