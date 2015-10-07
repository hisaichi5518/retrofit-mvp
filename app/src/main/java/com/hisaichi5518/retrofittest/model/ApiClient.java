package com.hisaichi5518.retrofittest.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hisaichi5518.retrofittest.api.service.UsersReposService;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

public class ApiClient {
    private static final String BASE_URL = "https://api.github.com";
    private RestAdapter mRestAdapter;

    public ApiClient() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'")
                .create();

        mRestAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(BASE_URL)
                .setConverter(new GsonConverter(gson))
                .setRequestInterceptor(new MyRequestInterceptor())
                .build();
    }

    // TODO: mApiClient.getService<UsersReposService>();
    public UsersReposService getUsersReposService() {
        return mRestAdapter.create(UsersReposService.class);
    }

    private class MyRequestInterceptor implements RequestInterceptor {
        @Override
        public void intercept(RequestFacade request) {
            request.addHeader("User-Agent", "Retrofit-Test");
        }
    }
}
