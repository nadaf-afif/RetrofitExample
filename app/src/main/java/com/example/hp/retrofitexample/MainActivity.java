package com.example.hp.retrofitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hp.retrofitexample.model.PlacesData;
import com.example.hp.retrofitexample.model.Result;
import com.example.hp.retrofitexample.model.WeatherData;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.PublicKey;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = MainActivity.class.getSimpleName();
    private EditText mSearchTermEditText;
    private RecyclerView mRecyclerView;
    public static final String API_KEY = "AIzaSyCVPjfFwUrghfcdOmg3qNynFL334-kROLs";
    private AddressAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        getWeatherInfo();
    }

    private void initViews() {
        mSearchTermEditText = (EditText) findViewById(R.id.searchTermEditText);
        mSearchTermEditText.setVisibility(View.GONE);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void getWeatherInfo() {

        ApiCallInterface apiCallInterface = RetroFitApiClient.getClient().create(ApiCallInterface.class);
        try {
            //String searchTerm = mSearchTermEditText.getText().toString();

            Call<PlacesData> apiCall = apiCallInterface.getWeatherInfo("hotels",API_KEY, false);
            apiCall.enqueue(new Callback<PlacesData>() {
                @Override
                public void onResponse(Call<PlacesData> call, Response<PlacesData> response) {
                    Log.d(TAG,call.request().url().toString());
                    List<Result> resultList = response.body().getResults();
                    if (resultList.size()>0){
                        if (mAdapter == null){
                            mAdapter = new AddressAdapter(resultList,MainActivity.this);
                            mRecyclerView.setAdapter(mAdapter);
                        }

                        mAdapter.notifyDataSetChanged();

                    }
                }

                @Override
                public void onFailure(Call<PlacesData> call, Throwable t) {
                    Log.d(TAG,call.request().url().toString());
                    Log.d(TAG, t.getMessage());
                }

            });

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
