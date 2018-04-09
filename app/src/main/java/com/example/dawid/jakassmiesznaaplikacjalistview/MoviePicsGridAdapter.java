package com.example.dawid.jakassmiesznaaplikacjalistview;

import android.app.Activity;
import android.content.Context;
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
            row = createRow(parent);
            holder = createNewHolder(row);
        }
        else
        {
            holder = (ViewHolder) row.getTag();
        }

        Glide.with(context).load(picResourceIds[position]).into(holder.image);
        return row;
    }

    private View createRow(ViewGroup parent)
    {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View row = inflater.inflate(layoutResourceId, parent, false);
        return row;
    }

    private ViewHolder createNewHolder(View row)
    {
        ViewHolder holder = new ViewHolder();
        holder.image = row.findViewById(R.id.pic);
        row.setTag(holder);
        return holder;
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