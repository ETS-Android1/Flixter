package com.example.flixter.adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.flixter.Models.Movie;
import com.example.flixter.R;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>{

    Context context;
    List<Movie> lstMovies;

    public MovieAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.lstMovies = movies;
    }


    //inflating layout from xml and returning holder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View movieView = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(movieView);
    }

    //populating data into the item through holder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie objMovie = lstMovies.get(position);
        holder.bind(objMovie);

    }

    //return the size of list
    @Override
    public int getItemCount() {
        return lstMovies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvTitle;
        TextView tvOverview;
        ImageView ivPoster;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvOverview = itemView.findViewById(R.id.tvOverView);
            ivPoster = itemView.findViewById(R.id.ivPoster);
        }

        public void bind(Movie objMovie) {
            tvTitle.setText(objMovie.getStrTitle());
            tvOverview.setText(objMovie.getStrOverView());
            String strImageURL;
            if(context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
            {
                strImageURL = objMovie.getStrBackDropPath();
            }
            else
            {
                strImageURL = objMovie.getStrPosterPath();
            }
            Glide.with(context).load(strImageURL).into(ivPoster);

        }
    }
}
