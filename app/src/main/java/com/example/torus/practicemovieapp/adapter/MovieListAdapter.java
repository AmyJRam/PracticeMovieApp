package com.example.torus.practicemovieapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.torus.practicemovieapp.Constant.Constant;
import com.example.torus.practicemovieapp.R;
import com.example.torus.practicemovieapp.module.MovieDb;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by amy on 26/10/17.
 */

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder> {
    List<MovieDb> movieDbList;
    Context context;

    public MovieListAdapter(Context context, List<MovieDb> movieDbList) {
        this.context = context;
        this.movieDbList = movieDbList;

    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_movie_adapter, parent, false);
        MovieViewHolder movieViewHolder = new MovieViewHolder(view);
        return movieViewHolder;
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        MovieDb movieDb = movieDbList.get(position);
        String moviePoster = movieDb.getImagePath();
        String movieTitle = movieDb.getMovieTitle();
        String movieSynopsis = movieDb.getMovieSynopsis();
        String movieReleaseDate = movieDb.getMovieReleaseDate();
        String movieRating = movieDb.getMovieRating();
        Picasso.with(context).load(Constant.POSTER_PATH + moviePoster).into(holder.imageViewMoviePoster);
    }

    @Override
    public int getItemCount() {
        return movieDbList.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewMoviePoster;

        public MovieViewHolder(View itemView) {
            super(itemView);
            imageViewMoviePoster = itemView.findViewById(R.id.imageView_movie_poster);
        }
    }
}
