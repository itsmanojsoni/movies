package com.codepath.movies.rest;

import com.codepath.movies.model.Movie;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by manoj on 9/15/17.
 */

public class MoviesResponse {

    public List<Movie> getResults() {
        return results;
    }

    @SerializedName("results")
    List<Movie> results;
}
