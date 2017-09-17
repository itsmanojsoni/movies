package com.codepath.movies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity implements MovieAdapter.OnItemClickListener {


    private static  final String TAG = "MainActivity";
    // TODO - insert your themoviedb.org API KEY here
//    private final static String API_KEY = "7e8f60e325cd06e164799af1e317d7a7";

    private final static String API_KEY = "a07e22bc18f5cb106bfe4cc1f83ad8ed";

    private List<Movie> movies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final MovieAdapter movieAdapter = new MovieAdapter(getApplicationContext(),this);

        recyclerView.setAdapter(movieAdapter);

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<MoviesResponse> call = apiService.getTopRatedMovies(API_KEY);
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                int statusCode = response.code();
                movies = response.body().getResults();

                Log.d(TAG, "Movie List Size = "+movies.size());
                movieAdapter.setData(movies);
                movieAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });

    }

    @Override
    public void onItemClick(int position) {

        Log.d(TAG, "onItem Clicked at Position = "+position);

        Intent intent = new Intent(this, MovieDetailActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }
}
