package com.example.submissiontiga.model;

import com.google.gson.JsonObject;

public class MovieData {

    private String title;
    private int popularity;
    private String overview;
    private String linkImage;

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

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }

    MovieData(JsonObject jsonObject){
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
