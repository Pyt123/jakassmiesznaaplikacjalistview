package com.example.dawid.jakassmiesznaaplikacjalistview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    private Context context = null;
    private List<Movie> data = null;

    public MovieAdapter(Context context, List<Movie> data)
    {
        super();
        this.context = context;
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(R.layout.movie_row, parent, false);
        Item item = new Item(row);

        setHolderEventListeners(item);
        return item;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        Movie movie = data.get(position);
        Item item = (Item)holder;
        item.nameView.setText(movie.getName());
        item.categoryView.setText(movie.getCategory());
        item.imageView.setImageResource(movie.getImageId());
        //item.setActualPosition(position);
    }

    @Override
    public int getItemCount()
    {
        return data.size();
    }

    private void setHolderEventListeners(final Item row)
    {
        row.itemView.setOnDragListener(new View.OnDragListener()
        {
            @Override
            public boolean onDrag(View view, DragEvent dragEvent)
            {
                int action = dragEvent.getAction();
                switch (action)
                {
                    case DragEvent.ACTION_DRAG_STARTED:
                        data.remove(row.getLayoutPosition());
                        notifyDataSetChanged();
                        break;
                    case DragEvent.ACTION_DRAG_ENDED:
                        break;
                }
                return true;
            }
        });
        row.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(context, "fraś debil", Toast.LENGTH_LONG).show();
            }
        });
    }

    public class Item extends RecyclerView.ViewHolder
    {
        //private int position = -1;
        private TextView nameView;
        private TextView categoryView;
        private ImageView imageView;

        public Item(View itemView)
        {
            super(itemView);
            nameView = itemView.findViewById(R.id.movie_name);
            categoryView = itemView.findViewById(R.id.category);
            imageView = itemView.findViewById(R.id.movie_image);
        }

       /* private void setActualPosition(int pos)
        {
            position = pos;
        }

        private int getActualPosition()
        {
            return position;
        }*/
    }
}