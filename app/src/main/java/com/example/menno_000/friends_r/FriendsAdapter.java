package com.example.menno_000.friends_r;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FriendsAdapter extends ArrayAdapter<Friend> {
    public FriendsAdapter(@NonNull Context context, int resource,
                          @NonNull ArrayList<Friend> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent,
                    false);
        }

        // Find a friend
        Friend friend = getItem(position);

        // Retrieve data from friend
        String name = friend.getName();
        Integer imageId = friend.getDrawableId();

        // Set data in GridView
        ImageView imageView = convertView.findViewById(R.id.gridImage);
        TextView nameView = convertView.findViewById(R.id.gridName);

        imageView.setImageResource(imageId);
        nameView.setText(name);

        // Finish implementing data
        return convertView;
    }
}
