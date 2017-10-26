package com.example.torus.practicemovieapp.module;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amy on 10/24/2017.
 */

public class MovieDbJsonParse {



    public static  List<MovieDb> parseMovieStringToJson(String movieResultData) {
        List<MovieDb> movieDbList = new ArrayList<>();
        try {
            JSONObject movieResultJsonObject = new JSONObject(movieResultData);

            JSONArray movieResultJsonArray = movieResultJsonObject.getJSONArray("results");
            for (int i = 0; i < movieResultJsonArray.length(); i++) {
                MovieDb movieDb = new MovieDb();
                movieDb.setMovieTitle(movieResultJsonArray.getJSONObject(i).getString("original_title"));
                movieDb.setImagePath(movieResultJsonArray.getJSONObject(i).getString("backdrop_path"));
                movieDb.setMovieRating(movieResultJsonArray.getJSONObject(i).getString("vote_average"));
                movieDb.setMovieSynopsis(movieResultJsonArray.getJSONObject(i).getString("overview"));
                movieDb.setMovieReleaseDate(movieResultJsonArray.getJSONObject(i).getString("release_date"));
                movieDbList.add(movieDb);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return movieDbList;
    }

}
