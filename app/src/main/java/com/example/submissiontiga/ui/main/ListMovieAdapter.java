package com.example.submissiontiga.ui.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.submissiontiga.R;
import com.example.submissiontiga.model.MovieData;

import java.util.ArrayList;

public class ListMovieAdapter extends RecyclerView.Adapter<ListMovieAdapter.ViewHolder> {

    private ArrayList<MovieData> movieData = new ArrayList<>();

    public void setMovieData(ArrayList<MovieData> movieData){
        movieData.clear();
        movieData.addAll(movieData);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ListMovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_card_data, viewGroup, false);
        return new ViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListMovieAdapter.ViewHolder viewHolder, int position) {
        viewHolder.bind(movieData.get(position));
    }

    @Override
    public int getItemCount() {
        return movieData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvYear;
        TextView tvDesc;
        ImageView imgPhoto;
        Button btnReadMore;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvYear = itemView.findViewById(R.id.tv_item_year);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvDesc = itemView.findViewById(R.id.longdesc_item);
            btnReadMore = itemView.findViewById(R.id.btn_read_more);
        }
        void bind(MovieData movieData){
            tvName.setText(movieData.getTitle());
            tvYear.setText(movieData.getPopularity());
            tvDesc.setText(movieData.getOverview());

            Glide.with(itemView.getContext())
                    .load(movieData.getPoster_path())
                    .into(imgPhoto);

            btnReadMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}