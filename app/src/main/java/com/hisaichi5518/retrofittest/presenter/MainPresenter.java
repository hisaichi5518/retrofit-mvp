package com.hisaichi5518.retrofittest.presenter;

import com.hisaichi5518.retrofittest.ui.view.MainView;
import com.hisaichi5518.retrofittest.model.ApiClient;
import com.hisaichi5518.retrofittest.entity.ApiError;
import com.hisaichi5518.retrofittest.entity.Repo;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainPresenter {
    private ApiClient mApiClient;
    private MainView mMainView;

    public MainPresenter(MainView view) {
        mApiClient = new ApiClient();
        mMainView = view;
    }

    public void fetchHisaichisRepos() {
        mApiClient.getUsersReposService().repos("hisaichi5518", new Callback<List<Repo>>() {
            @Override
            public void success(List<Repo> repos, Response response) {
                mMainView.showSuccessSnackbar();
            }

            @Override
            public void failure(RetrofitError error) {
                // NOTE: 5xx系ならリトライなし, 4xx系ならリトライあり みたいに分岐するのありっぽい
                ApiError apiError = (ApiError) error.getBodyAs(ApiError.class);
                mMainView.showFailureSnackbar(apiError);
            }
        });
    }
}
