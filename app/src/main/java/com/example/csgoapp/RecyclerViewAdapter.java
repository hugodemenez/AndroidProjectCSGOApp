package com.example.csgoapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private final List<Content> mValues;
    private final Context contextRecyclerView;

    public RecyclerViewAdapter(List<Content> items,Context context) {
        contextRecyclerView = context;
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Content content = mValues.get(position);
        holder.button.setText(content.contentTitle);
        holder.button.setOnClickListener(v -> {
            Log.e("Button",content.contentTitle);
            Map<String,String> map = new HashMap<>();
            map.put("map", content.map);
            map.put("grenade", content.grenade);
            map.put("side", content.side);
            map.put("contentTitle", content.contentTitle);
            map.put("videoUrl", content.videoUrl);
            map.put("image1Url", content.image1Url);
            map.put("image2Url", content.image2Url);
            map.put("instruction",content.instruction);
            new CSGOActivityStarter(contextRecyclerView,map, CSGOContentDisplay.class);
        });


    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final Button button;


        public ViewHolder(View view) {
            super(view);
            button = (Button) view.findViewById(R.id.buttonChoose);

        }

        @Override
        public String toString() {
            return super.toString() + " '" + button.getText() + "'";
        }
    }
}