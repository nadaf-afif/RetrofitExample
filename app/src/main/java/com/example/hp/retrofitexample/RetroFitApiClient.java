package com.example.hp.retrofitexample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by hp on 10/23/16.
 */
public class RetroFitApiClient {

    //https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20
    // (select%20woeid%20from%20geo.places(1)%20where%20text%3D%22pune%22)&format=json&diagnostics=true
    // &env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys&callback=

    private static final String BASE_URL = "https://maps.googleapis.com/maps/api/place/textsearch/";
    public static Retrofit retroFitApiClient = null;

    public static Retrofit getClient(){

        if (retroFitApiClient == null){

            Gson gson = new GsonBuilder().setLenient().create();

            retroFitApiClient = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }

        return retroFitApiClient;
    }

}
