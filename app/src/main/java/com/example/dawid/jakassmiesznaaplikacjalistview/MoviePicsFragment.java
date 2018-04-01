package com.example.dawid.jakassmiesznaaplikacjalistview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MoviePicsFragment extends MovieInfoFragment
{
    public MoviePicsFragment()
    {
        super();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart()
    {
        super.onStart();
        initPics();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.movie_pics_fragment, container, false);
        return view;
    }

    private void initPics()
    {
        int [] imageIds = movie.getImageIds();

        ViewGroup picHolder = getView().findViewById(R.id.pic_holder);
        ImageView imageView;
        for(int i = 0; i < picHolder.getChildCount(); i++)
        {
            imageView = (ImageView)(picHolder.getChildAt(i));
            imageView.setImageResource(imageIds[i]);
        }
    }

    protected void setFragmentListener()
    {
    }
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener
    {
        // TODO: Update argument type and name
        void onListFragmentInteraction();
    }
}