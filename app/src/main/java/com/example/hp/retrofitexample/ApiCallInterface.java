package com.example.hp.retrofitexample;

import com.example.hp.retrofitexample.model.PlacesData;
import com.example.hp.retrofitexample.model.WeatherData;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by hp on 10/23/16.
 */
public interface ApiCallInterface {

    //select * from weather.forecast where woeid in (select woeid from geo.places(1) where text="nome, ak")
    @GET("json")
    Call<PlacesData> getWeatherInfo(@Query("query") String query, @Query("key") String api_key, @Query("sensor") boolean sensor);

}
