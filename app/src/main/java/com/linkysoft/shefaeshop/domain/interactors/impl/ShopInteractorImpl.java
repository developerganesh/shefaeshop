package com.linkysoft.shefaeshop.domain.interactors.impl;

import android.util.Log;

import com.linkysoft.shefaeshop.Network.ApiClient;
import com.linkysoft.shefaeshop.Network.response.ShopResponse;
import com.linkysoft.shefaeshop.Network.services.ShopApiInterface;
import com.linkysoft.shefaeshop.domain.executor.Executor;
import com.linkysoft.shefaeshop.domain.executor.MainThread;
import com.linkysoft.shefaeshop.domain.interactors.ShopInteractor;
import com.linkysoft.shefaeshop.domain.interactors.base.AbstractInteractor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShopInteractorImpl extends AbstractInteractor {
    private ShopInteractor.CallBack mCallback;
    private ShopApiInterface apiService;
    private String url;

    public ShopInteractorImpl(Executor threadExecutor, MainThread mainThread, ShopInteractor.CallBack callBack, String url) {
        super(threadExecutor, mainThread);
        mCallback = callBack;
        this.url = url;
    }

    @Override
    public void run() {
        apiService = ApiClient.getClient().create(ShopApiInterface.class);
        Call<ShopResponse> call = apiService.getShopDetails(url);

        call.enqueue(new Callback<ShopResponse>() {
            @Override
            public void onResponse(Call<ShopResponse> call, Response<ShopResponse> response) {
                try {
                    mCallback.onShopLoaded(response.body().getData().get(0));
                } catch (Exception e) {
                    Log.e("Exception", e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<ShopResponse> call, Throwable t) {
                mCallback.onShopLoadError();
            }
        });

    }
}
