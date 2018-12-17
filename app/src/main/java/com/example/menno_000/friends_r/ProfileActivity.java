package com.example.menno_000.friends_r;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    // Setting up global variables
    Friend retrievedFriend;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Retrieve data from former screen
        Intent intent = getIntent();
        retrievedFriend = (Friend) intent.getSerializableExtra("clickedFriend");

        // Retrieving the profile picture, name and bio
        ImageView imageView = findViewById(R.id.profileImage);
        TextView nameView = findViewById(R.id.profileName);
        TextView bioView = findViewById(R.id.profileBio);

        // Setting the profile picture, name and bio
        imageView.setImageResource(retrievedFriend.getDrawableId());
        nameView.setText(retrievedFriend.getName());
        bioView.setText(retrievedFriend.getBio());


        // Save rating for each friend using SharedPreferences
        prefs = getSharedPreferences("settings", MODE_PRIVATE);
        RatingBar ratingBar = findViewById(R.id.profileRatingBar);

        // Get the stored rating
        Float retrievedFloat = prefs.getFloat(retrievedFriend.getName(), 0);

        // Set the correct value in de data
        retrievedFriend.setRating(retrievedFloat);

        // Set the correct value on the ratingbar
        ratingBar.setRating(retrievedFloat);

        // Initialise the listener for the rating bar
        RatingBarListener(ratingBar);
    }

    // Creating the listener
    public void RatingBarListener(RatingBar ratingbar) {
        ratingbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

                // If the rating changes, set the new rating
                retrievedFriend.setRating(v);

                // Save the change
                SharedPreferences.Editor editor = prefs.edit();
                editor.putFloat(retrievedFriend.getName(), v);
                editor.apply();
            }
        });
    }
}
