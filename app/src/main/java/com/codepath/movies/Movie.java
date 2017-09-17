package com.codepath.movies;

/**
 * Created by manoj on 9/15/17.
 */


import android.os.Parcel;
import android.os.Parcelable;

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
