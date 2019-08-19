package com.example.submissiontiga.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;
import com.example.submissiontiga.model.MovieData;
import com.example.submissiontiga.model.TvData;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import cz.msebera.android.httpclient.Header;

public class MainViewModel extends ViewModel {

    private static final String API_KEY = "ca17afdd8c6d6638a7ee520a9b84ea8f";
    private MutableLiveData<ArrayList<MovieData>> listMovieData = new MutableLiveData<>();

    public void setListMovieData() {
        AsyncHttpClient client = new AsyncHttpClient();
        final ArrayList<MovieData> listItems = new ArrayList<>();

        String url = "https://api.themoviedb.org/3/discover/movie?api_key="+API_KEY+"&language=en-US";

        Log.d("cetakURL",url);

        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String result = new String(responseBody);
                    JSONObject responseObject = new JSONObject(result);
                    JSONArray list = responseObject.getJSONArray("list");

                    for (int i = 0; i < list.length(); i++) {
                        JSONObject movie = list.getJSONObject(i);
                        MovieData movieData = new MovieData(movie);
                        listItems.add(movieData);
                    }
                    listMovieData.postValue(listItems);
                }catch (Exception e){
                    Log.d("Exception", e.getMessage());
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("onFailure", error.getMessage());
            }
        });
    }

    public LiveData<ArrayList<MovieData>> getMovieData() {
        return listMovieData;
    }
}
