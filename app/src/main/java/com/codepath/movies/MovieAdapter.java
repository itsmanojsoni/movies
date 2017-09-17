package com.codepath.movies;

import android.content.Context;
import android.content.res.Configuration;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

import static com.codepath.movies.R.id.posterImage;

/**
 * Created by manoj on 9/15/17.
 */
public class MovieAdapter extends
        RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private static final String TAG = MovieAdapter.class.getSimpleName();

    private Context context;
    private List<Movie> list = new ArrayList<>();
    private OnItemClickListener onItemClickListener;

    public MovieAdapter(Context context, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    public void setData (List<Movie> movieList) {
        this.list = movieList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Todo Butterknife bindings
         ImageView posterImage;
         TextView movieTitle;
         TextView movieOverview;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            posterImage = (ImageView) itemView.findViewById(R.id.posterImage);
            movieTitle = (TextView) itemView.findViewById(R.id.movieTitle);
            movieOverview = (TextView) itemView.findViewById(R.id.movieOverview);
        }

        public void bind(final Movie model,
                         final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "onClick in Movie Adapter");
                    listener.onItemClick(getLayoutPosition());

                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.movie_list_item, parent, false);
        ButterKnife.bind(this, view);


        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie item = list.get(position);

        Log.d(TAG, "movie Title  = "+item.getTitle());

        holder.movieTitle.setText(item.getTitle());
        holder.movieOverview.setText(item.getOverview());

        String url = null;

        int orientation = context.getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            url = "https://image.tmdb.org/t/p/w342"+ item.getPosterPath();
            Log.d(TAG, "Portrait url is : "+url);
            // ...
        } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            url = "https://image.tmdb.org/t/p/w1280"+ item.getBackdrop_path();
            Log.d(TAG, "Landscape url is : "+url);
        }

        Glide.with(context)
                .load(url)
                .placeholder(R.mipmap.placeholder)
                .dontTransform()
                .dontAnimate()
                .into(holder.posterImage);

        //Todo: Setup viewholder for item 
        holder.bind(item, onItemClickListener);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

}