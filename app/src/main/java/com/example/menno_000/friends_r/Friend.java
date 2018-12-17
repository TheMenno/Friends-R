package com.example.menno_000.friends_r;

public class  Friend implements java.io.Serializable {
    private String name, bio;
    private int drawableId;
    private float rating;

    // Constructor
    public Friend(String name, String bio, int drawableId) {
        this.name = name;
        this.bio = bio;
        this.drawableId = drawableId;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public float getRating() {
        return rating;
    }

    // Setter
    public void setRating(float rating) {
        this.rating = rating;
    }
}
