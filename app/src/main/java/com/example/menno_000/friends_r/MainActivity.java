package com.example.menno_000.friends_r;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    // A listener that creates a new view after a friend is chosen
    private class GridItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            // Retrieve chosen friend
            Friend clickedFriend = (Friend) adapterView.getItemAtPosition(i);

            // Give info to new view
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clickedFriend", clickedFriend);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialise containers for data
        ArrayList<Friend> friends = new ArrayList<>();
        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item, friends);

        // Initialise data
        Friend ted = new Friend ("Ted", "A guy looking for his soulmate",
                getResources().getIdentifier("ted_mosby", "drawable",
                        MainActivity.this.getPackageName()));
        Friend robin = new Friend ("Robin", "A girl who always puts her work first",
                getResources().getIdentifier("robin_scherbatsky", "drawable",
                        MainActivity.this.getPackageName()));
        Friend barney = new Friend ("Barney", "A guy trying to bed all women of New York"
                , getResources().getIdentifier("barney_stinson", "drawable",
                MainActivity.this.getPackageName()));
        Friend marshall = new Friend ("Marshall", "A guy studying law",
                getResources().getIdentifier("marshall_eriksen", "drawable",
                        MainActivity.this.getPackageName()));
        Friend lily = new Friend ("Lily", "A girl trying to figure out what job fits her"
                , getResources().getIdentifier("lily_aldrin", "drawable",
                MainActivity.this.getPackageName()));

        // Add the friends to the list
        Collections.addAll(friends, ted, robin, barney, marshall, lily);

        // Set a listener on the grid
        GridView gv = findViewById(R.id.grid);
        gv.setOnItemClickListener(new GridItemClickListener());

        // Set adapter on the grid
        GridView grid = findViewById(R.id.grid);
        grid.setAdapter(adapter);
    }
}
