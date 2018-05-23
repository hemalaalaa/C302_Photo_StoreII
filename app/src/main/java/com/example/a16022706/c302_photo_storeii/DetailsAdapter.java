package com.example.a16022706.c302_photo_storeii;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailsAdapter extends ArrayAdapter<Details> {
    private ArrayList<Details> categoryAl;
    private Context context;
    private TextView tvCategoryGroup;
    private TextView tvCategoryDesc;

    public DetailsAdapter(Context context, int resource, ArrayList<Details> objects) {
        super(context,resource,objects);
        categoryAl = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowVIew = inflater.inflate(R.layout.row_photodetails, parent, false);

        tvCategoryGroup = (TextView) rowVIew.findViewById(R.id.tvTitle);
        tvCategoryDesc = (TextView) rowVIew.findViewById(R.id.tvDesc);

        Details currentRow = categoryAl.get(position);

        tvCategoryGroup.setText(currentRow.getTitle());
        tvCategoryDesc.setText(currentRow.getDescription());

        return rowVIew;
    }

}
