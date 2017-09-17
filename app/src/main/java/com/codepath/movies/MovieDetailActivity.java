package com.codepath.movies;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.DecimalFormat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.codepath.movies.MainActivity.API_KEY;

/**
 * Created by manoj on 9/16/17.
 */

public class MovieDetailActivity extends AppCompatActivity {

    private static final String TAG = "MovieDetailActivity";
    private int id;

    private ImageView movieImage;
    private TextView movieTitle;
    private TextView movieGenre;
    private TextView movieDescription;
    private TextView moviePopularity;
    private TextView movieRating;

    private String url;
    private String title;
    private String genre;
    private String description;
    private String popularity;
    private String rating;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        Log.d(TAG, "onCreate Movie Detail Acitivity");

        movieImage = (ImageView) findViewById(R.id.movieDetailImage);
        movieTitle = (TextView) findViewById(R.id.movieDetailTitle);
        movieDescription = findViewById(R.id.movieDetailOverview);
        moviePopularity = findViewById(R.id.movieDetailPopularity);
        movieRating = findViewById(R.id.movieDetailRating);


        Intent intent = getIntent();

        context = (Context)this;

        id = intent.getIntExtra("movieId",0);

        Log.d(TAG, "Movie Id is : "+id);

//        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
//
//        Call<Movie> call = apiService.getMovieDetails(id, API_KEY);
//        call.enqueue(new Callback<Movie>() {
//            @Override
//            public void onResponse(Call<Movie> call, Response<Movie> response) {
//                int statusCode = response.code();
//                Log.d(TAG, "status code is : "+statusCode);
//
//                url = response.body().getBackdrop_path();
//                title = response.body().getTitle();
//                description = response.body().getOverview();
//                rating = response.body().getRating();
//                popularity = response.body().getPopularity();
//
//                String imagePath = "https://image.tmdb.org/t/p/w1280"+ url;
//                Glide.with(context)
//                        .load(imagePath)
//                        .placeholder(R.mipmap.placeholder)
//                        .dontTransform()
//                        .dontAnimate()
//                        .into(movieImage);
//
//            }
//            @Override
//            public void onFailure(Call<Movie> call, Throwable t) {
//                // Log error here since request failed
//                Log.e(TAG, t.toString());
//            }
//        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<Movie> call = apiService.getMovieDetails(id, API_KEY);
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                int statusCode = response.code();
                Log.d(TAG, "status code is : "+statusCode);

                url = response.body().getBackdrop_path();
                title = response.body().getTitle();
                description = response.body().getOverview();
                rating = new DecimalFormat("#.##").format(response.body().getRating());
                popularity = new DecimalFormat("#.##").format(response.body().getPopularity());


                String imagePath = "https://image.tmdb.org/t/p/w1280"+ url;
                Glide.with(context)
                        .load(imagePath)
                        .placeholder(R.mipmap.placeholder)
                        .dontTransform()
                        .dontAnimate()
                        .into(movieImage);

                movieTitle.setText(getResources().getString(R.string.Movie) + title);
                moviePopularity.setText(getResources().getString(R.string.Popularity) + popularity);
                movieRating.setText(getResources().getString(R.string.Rating)+ rating);
                movieDescription.setText(description);
            }
            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });


    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
