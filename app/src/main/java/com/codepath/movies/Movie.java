package com.codepath.movies;

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
}
