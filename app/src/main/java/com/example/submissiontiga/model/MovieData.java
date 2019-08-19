package com.example.submissiontiga.model;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONObject;

public class MovieData {

    private String title;
    private int popularity;
    private String overview;
    private String poster_path;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public MovieData(JSONObject object){
        try {
            String title = object.getJSONObject("results").getString("title");
            int popularity = object.getJSONObject("result").getInt("popularity");
            String overview = object.getJSONObject("overview").getString("overview");
            String poster_path = object.getJSONObject("poster_path").getString("poster_path");
            String finalPosterPath = "https://image.tmdb.org/t/p/w500"+poster_path;

            this.title = title;
            this.popularity = popularity;
            this.poster_path = finalPosterPath;
            this.overview = overview;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
