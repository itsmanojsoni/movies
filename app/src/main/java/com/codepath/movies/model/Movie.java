package com.codepath.movies.model;

/**
 * Created by manoj on 9/15/17.
 */

import com.google.gson.annotations.SerializedName;


public class Movie {

    public String getPosterPath() {
        return posterPath;
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    @SerializedName("poster_path")
    String posterPath;
    @SerializedName("original_title")
    String title;
    @SerializedName("overview")
    String overview;

    @SerializedName("popularity")
    double popularity;

    @SerializedName("vote_average")
    double rating;


    public double getPopularity() {
        return popularity;
    }


    public double getRating() {
        return rating;
    }


    public int getId() {
        return id;
    }

    @SerializedName("id")
    int id;

    public String getBackdrop_path() {
        return backdrop_path;
    }

    @SerializedName("backdrop_path")
    String backdrop_path;

}
