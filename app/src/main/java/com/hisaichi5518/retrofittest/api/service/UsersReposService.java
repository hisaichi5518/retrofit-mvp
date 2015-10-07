package com.hisaichi5518.retrofittest.api.service;

import com.hisaichi5518.retrofittest.entity.Repo;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

public interface UsersReposService {
    @GET("/users/{user}/repos")
    void repos(@Path("user") String user, Callback<List<Repo>> cb);

}
