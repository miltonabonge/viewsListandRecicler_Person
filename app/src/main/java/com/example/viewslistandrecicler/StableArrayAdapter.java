package com.example.viewslistandrecicler;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.List;

public class StableArrayAdapter extends ArrayAdapter<String> {
    private HashMap<String, Integer> idMap = new HashMap<>();


    StableArrayAdapter(Context context, int resource, List<String> data) {
        super(context, resource, data);

        for (int i = 0; i < data.size(); i++) {
            idMap.put(data.get(i), i);
        }
    }

    @Override
    public long getItemId(int position) {
        String item = getItem(position);
        return idMap.get(item);
    }
//    public StableArrayAdapter(Context context, int resource) {
//        super(context, resource,data);

    @Override
    public boolean hasStableIds() {
        return true;
    }
}
