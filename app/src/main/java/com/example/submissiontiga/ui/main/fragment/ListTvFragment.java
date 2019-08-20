package com.example.submissiontiga.ui.main.fragment;

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
import android.widget.ProgressBar;

import com.example.submissiontiga.R;
import com.example.submissiontiga.model.MovieData;
import com.example.submissiontiga.model.TvData;
import com.example.submissiontiga.ui.main.adapter.ListTvShowAdapter;
import com.example.submissiontiga.viewmodel.MainViewModel;

import java.util.ArrayList;

public class ListTvFragment extends Fragment {

    private ListTvShowAdapter listTvShowAdapter;
    private RecyclerView recyclerData;
    private MainViewModel mainViewModel;
    private ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_recycler_item_tv_movie, container, false);
        progressBar = view.findViewById(R.id.progressBar);

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.getTVData().observe(this, getTVData);

        listTvShowAdapter = new ListTvShowAdapter(getContext());
        listTvShowAdapter.notifyDataSetChanged();

        recyclerData = (RecyclerView) view.findViewById(R.id.recycler_data);
        recyclerData.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerData.setAdapter(listTvShowAdapter);


        mainViewModel.setListMovieData();
        showLoading(true);

        return view;
    }

    private Observer<ArrayList<TvData>> getTVData = new Observer<ArrayList<TvData>>() {
        @Override
        public void onChanged(@Nullable ArrayList<TvData> tvData) {
            if (tvData != null){
                listTvShowAdapter.setTvData(tvData);
                showLoading(false);
            }
        }
    };

    private void showLoading(Boolean state) {
        if (state) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }
}
