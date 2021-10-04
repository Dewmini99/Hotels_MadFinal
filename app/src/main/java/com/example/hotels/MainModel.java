package com.example.hotels;

public class MainModel {

    String name,ratings,tags,visits,hurl;

    MainModel()
    {

    }

    public MainModel(String name, String ratings, String tags, String visits, String hurl) {
        this.name = name;
        this.ratings = ratings;
        this.tags = tags;
        this.visits = visits;
        this.hurl = hurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getVisits() {
        return visits;
    }

    public void setVisits(String visits) {
        this.visits = visits;
    }

    public String getHurl() {
        return hurl;
    }

    public void setHurl(String hurl) {
        this.hurl = hurl;
    }
}
