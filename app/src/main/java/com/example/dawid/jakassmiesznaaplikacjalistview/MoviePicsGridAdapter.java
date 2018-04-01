package com.example.dawid.jakassmiesznaaplikacjalistview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


public class MoviePicsGridAdapter extends ArrayAdapter
{
    private Context context;
    private int layoutResourceId;
    private int [] picResourceIds;

    public MoviePicsGridAdapter(Context context, int layoutResourceId, int [] picResourceIds)
    {
        super(context, layoutResourceId);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.picResourceIds = picResourceIds;
    }

    @Override
    public View getView(int position, View row, ViewGroup parent)
    {
        ViewHolder holder = null;

        if (row == null)
        {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new ViewHolder();
            holder.image = row.findViewById(R.id.pic);
            row.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) row.getTag();
        }

        Glide.with(context).load(picResourceIds[position]).into(holder.image);
        return row;
    }


    @Override
    public int getCount()
    {
        return picResourceIds.length;
    }





    static class ViewHolder
    {
        ImageView image;
    }
}