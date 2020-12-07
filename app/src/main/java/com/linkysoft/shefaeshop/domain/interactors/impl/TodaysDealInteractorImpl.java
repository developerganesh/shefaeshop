package com.linkysoft.shefaeshop.domain.interactors.impl;

import android.util.Log;

import com.linkysoft.shefaeshop.Network.ApiClient;
import com.linkysoft.shefaeshop.Network.response.ProductResponse;
import com.linkysoft.shefaeshop.Network.services.TodaysDealApiInterface;
import com.linkysoft.shefaeshop.domain.executor.Executor;
import com.linkysoft.shefaeshop.domain.executor.MainThread;
import com.linkysoft.shefaeshop.domain.interactors.TodaysDealInteractor;
import com.linkysoft.shefaeshop.domain.interactors.base.AbstractInteractor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TodaysDealInteractorImpl extends AbstractInteractor {
    private TodaysDealInteractor.CallBack mCallback;
    private TodaysDealApiInterface apiService;

    public TodaysDealInteractorImpl(Executor threadExecutor, MainThread mainThread, TodaysDealInteractor.CallBack callBack) {
        super(threadExecutor, mainThread);
        mCallback = callBack;
    }

    @Override
    public void run() {
        apiService = ApiClient.getClient().create(TodaysDealApiInterface.class);
        Call<ProductResponse> call = apiService.getTodaysDeal();

        call.enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                try {
                    mCallback.onTodaysDealProductDownloaded(response.body().getData());
                } catch (Exception e) {
                    Log.e("Exception", e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t) {
                mCallback.onTodaysDealProductDownloadError();
            }
        });

    }
}
