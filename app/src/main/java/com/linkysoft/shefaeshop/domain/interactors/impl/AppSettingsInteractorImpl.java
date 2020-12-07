package com.linkysoft.shefaeshop.domain.interactors.impl;

import android.util.Log;

import com.linkysoft.shefaeshop.Network.ApiClient;
import com.linkysoft.shefaeshop.Network.response.AppSettingsResponse;
import com.linkysoft.shefaeshop.Network.services.AppSettingsApiInterface;
import com.linkysoft.shefaeshop.domain.executor.Executor;
import com.linkysoft.shefaeshop.domain.executor.MainThread;
import com.linkysoft.shefaeshop.domain.interactors.AppSettingsInteractor;
import com.linkysoft.shefaeshop.domain.interactors.base.AbstractInteractor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppSettingsInteractorImpl extends AbstractInteractor {
    private AppSettingsInteractor.CallBack mCallback;
    private AppSettingsApiInterface apiService;

    public AppSettingsInteractorImpl(Executor threadExecutor, MainThread mainThread, AppSettingsInteractor.CallBack callBack) {
        super(threadExecutor, mainThread);
        mCallback = callBack;
    }

    @Override
    public void run() {
        apiService = ApiClient.getClient().create(AppSettingsApiInterface.class);
        Call<AppSettingsResponse> call = apiService.getAppSettings();

        call.enqueue(new Callback<AppSettingsResponse>() {
            @Override
            public void onResponse(Call<AppSettingsResponse> call, Response<AppSettingsResponse> response) {
                try {
                    mCallback.onAppSettingsLoaded(response.body());
                    //Log.d("AppSettings", response.body().getData().get(0).getName());
                } catch (Exception e) {
                    Log.e("Exception", e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<AppSettingsResponse> call, Throwable t) {
                mCallback.onAppSettingsLoadedError();
            }
        });

    }
}
