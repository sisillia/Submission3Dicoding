package com.example.submissiontiga.ui.main;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.submissiontiga.R;
import com.example.submissiontiga.model.MovieData;
import com.example.submissiontiga.viewmodel.MainViewModel;

import java.util.ArrayList;

public class ListMovieFragment extends Fragment {

    private ListMovieAdapter listMovieAdapter;
    private RecyclerView recyclerData;
    private MainViewModel mainViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.recycler_recycler_item_tv_movie, container, false);
        recyclerData = (RecyclerView) view.findViewById(R.id.recycler_data);

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.getMovieData().observe(this, getMovieData);

        listMovieAdapter = new ListMovieAdapter();
        recyclerData.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerData.setAdapter(listMovieAdapter);
        recyclerData.setHasFixedSize(true);
        mainViewModel.setListMovieData();
        listMovieAdapter.notifyDataSetChanged();

        return view;
    }

    private Observer<ArrayList<MovieData>> getMovieData = new Observer<ArrayList<MovieData>>() {
        @Override
        public void onChanged(@Nullable ArrayList<MovieData> movieData) {
            if(movieData != null){
                listMovieAdapter.setMovieData(movieData);
            }
        }
    };


}
