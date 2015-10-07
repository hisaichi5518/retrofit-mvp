package com.hisaichi5518.retrofittest.ui.view;

import com.hisaichi5518.retrofittest.entity.ApiError;

public interface MainView {
    void showSuccessSnackbar();
    void showFailureSnackbar(ApiError err);
}
