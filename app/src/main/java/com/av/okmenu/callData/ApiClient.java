package com.av.okmenu.callData;

import com.av.okmenu.classes.Urls;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mina on 1/10/2018.
 */

public class ApiClient {
    private static final String BASE_URL = Urls.BASE_URL;//"https://reqres.in/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient(){
        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
