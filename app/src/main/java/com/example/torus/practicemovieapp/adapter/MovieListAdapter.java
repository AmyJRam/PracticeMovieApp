package com.example.torus.practicemovieapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.torus.practicemovieapp.Constant.Constant;
import com.example.torus.practicemovieapp.MovieDetailedView;
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
        final String moviePoster = movieDb.getImagePath();
        final String movieTitle = movieDb.getMovieTitle();
        final String movieSynopsis = movieDb.getMovieSynopsis();
        final String movieReleaseDate = movieDb.getMovieReleaseDate();
        final String movieRating = movieDb.getMovieRating();
        Picasso.with(context).load(Constant.POSTER_PATH + moviePoster).into(holder.imageViewMoviePoster);
        holder.imageViewMoviePoster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMovieDetailedView=new Intent();
                intentMovieDetailedView.putExtra(Constant.MOVIE_TITLE,movieTitle);
                intentMovieDetailedView.putExtra(Constant.MOVIE_IMAGE_POSTER,moviePoster);
                intentMovieDetailedView.putExtra(Constant.MOVIE_SYNOPSIS,movieSynopsis);
                intentMovieDetailedView.putExtra(Constant.MOVIE_RATING,movieRating);
                intentMovieDetailedView.putExtra(Constant.MOVIE_ReleaseDate,movieReleaseDate);
                intentMovieDetailedView.setClass(context, MovieDetailedView.class);
                context.startActivity(intentMovieDetailedView);
            }
        });
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
