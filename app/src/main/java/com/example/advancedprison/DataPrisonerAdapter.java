package com.example.advancedprison;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by William on 19-3-2018.
 */

public class DataPrisonerAdapter extends ArrayAdapter<Prisoner> {

    List<Prisoner> mPrisoners;
    LayoutInflater mInflater;

    public DataPrisonerAdapter(@NonNull Context context, @NonNull List<Prisoner> objects) {
        super(context, R.layout.prison_list, objects);

        mPrisoners = objects;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.prison_list, parent, false);
        }

        View fillerView = convertView.findViewById(R.id.viewID);
        ImageView imageView = convertView.findViewById(R.id.imageViewID);
        TextView nameView = convertView.findViewById(R.id.nameViewID);
        TextView nameOutputView = convertView.findViewById(R.id.nameOutputID);
        TextView ageView = convertView.findViewById(R.id.ageViewID);
        TextView ageOutputView = convertView.findViewById(R.id.ageOutputID);

        Prisoner prisoner = mPrisoners.get(position);

        nameView.setText("Name:");
        ageView.setText("Age:");
        nameOutputView.setText(prisoner.getName());
        ageOutputView.setText(prisoner.getAge());
        imageView.setImageResource(R.drawable.puton);

        return convertView;
    }
}
