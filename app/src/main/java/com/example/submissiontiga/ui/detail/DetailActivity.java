package com.example.submissiontiga.ui.detail;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.submissiontiga.R;
import com.example.submissiontiga.model.MovieData;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends AppCompatActivity {

    CircleImageView imgFilm;
    TextView titleFilm, descOfFilm;
    public static final String EXTRA_DATA = "extra_data";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Film Detail");

        imgFilm = (CircleImageView) findViewById(R.id.img_film);
        titleFilm = (TextView) findViewById(R.id.tv_title_film);

        descOfFilm = (TextView) findViewById(R.id.tv_desc_film);

        MovieData movieData = getIntent().getParcelableExtra(EXTRA_DATA);

        titleFilm.setText(movieData.getTitle());
        descOfFilm.setText(movieData.getOverview());

        Glide.with(this)
                .load(movieData.getPoster_path())
                .into(imgFilm);
    }
}
