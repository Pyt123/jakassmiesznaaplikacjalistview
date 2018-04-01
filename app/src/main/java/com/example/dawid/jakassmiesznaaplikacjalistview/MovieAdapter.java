package com.example.dawid.jakassmiesznaaplikacjalistview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
        implements RecyclerItemTouchHelper.RecyclerItemTouchHelperListener
{
    private Context context = null;
    private List<Movie> data = null;

    public MovieAdapter(Context context, List<Movie> data, RecyclerView recyclerView)
    {
        super();
        this.context = context;
        this.data = data;
        setSwipeToDeleteListener(recyclerView);
    }

    private void setSwipeToDeleteListener(RecyclerView recyclerView)
    {
        ItemTouchHelper.SimpleCallback itemTouchHelperCallback =
                new RecyclerItemTouchHelper(0, ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT, this);
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        final LayoutInflater inflater = LayoutInflater.from(context);
        final View row = inflater.inflate(R.layout.movie_row, parent, false);
        final Item item = new Item(row);

        setClickListenerForItem(item);

        return item;
    }

    private void setClickListenerForItem(final Item item)
    {
        item.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                int idOfMovieInData = item.getLayoutPosition();
                SpecificIMovieActivity.start(context, idOfMovieInData);
            }
        });
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        Movie movie = data.get(position);
        Item item = (Item)holder;
        item.nameView.setText(movie.getMovieName());
        item.categoryView.setText(movie.getCategory());
        Glide.with(context).load(movie.getMainImageId()).into(item.imageView);
    }

    @Override
    public int getItemCount()
    {
        return data.size();
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position)
    {
        if (viewHolder instanceof MovieAdapter.Item)
        {
            removeItemOnPosition(position);
        }
    }

    private void removeItemOnPosition(int position)
    {
        data.remove(position);
        notifyItemRemoved(position);
    }

    public class Item extends RecyclerView.ViewHolder
    {
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
    }
}