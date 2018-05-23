package com.example.a16022706.c302_photo_storeii;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CategoryAdapter extends ArrayAdapter<Category> {
    private ArrayList<Category> alCategory;
    int  resource;
    private Context context;
    private TextView tvTitle;
    private TextView tvDesc;

    public CategoryAdapter(Context context, int resource, ArrayList<Category> objects) {
        super(context,resource,objects);
        this.alCategory = objects;
        this.resource = resource;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowVIew = inflater.inflate(R.layout.row_category_details, parent, false);

        tvTitle = (TextView) rowVIew.findViewById(R.id.tvCategoryGroup);
        tvDesc = (TextView) rowVIew.findViewById(R.id.tvCategoryDesc);

        Category currentRow = alCategory.get(position);

        tvTitle.setText(currentRow.getName());
        tvDesc.setText(currentRow.getDescription());

        return rowVIew;
    }


}
