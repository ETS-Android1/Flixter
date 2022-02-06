package com.example.flixter.Models;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    String strPosterPath;
    String strTitle;
    String strOverView;
    String strBackDropPath;

    public static final String TAG = "Movie Models";

    public Movie(JSONObject objJSON) throws JSONException {
        try
        {
            strPosterPath = objJSON.getString("poster_path");
            strTitle = objJSON.getString("title");
            strOverView = objJSON.getString("overview");
            strBackDropPath = objJSON.getString("backdrop_path");
        }
        catch (Exception ex)
        {
            Log.e(TAG, "Error in JSON", ex);
        }
    }

    public static List<Movie> fromJsonArray(JSONArray jsonArray) throws JSONException
    {
        List<Movie> lstMovies = new ArrayList<>();
        try{
            for(int i = 0; i < jsonArray.length(); i++)
            {
                lstMovies.add(new Movie(jsonArray.getJSONObject(i)));
            }
        }
        catch (Exception ex)
        {
            Log.e(TAG, "Error in parsing JSON Array", ex);
        }
        return lstMovies;
    }

    public String getStrPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", strPosterPath);
    }

    public String getStrTitle() {
        return strTitle;
    }

    public String getStrOverView() {
        return strOverView;
    }

    public String getStrBackDropPath()
    {
        return String.format("https://image.tmdb.org/t/p/w342/%s", strBackDropPath);
    }

}
