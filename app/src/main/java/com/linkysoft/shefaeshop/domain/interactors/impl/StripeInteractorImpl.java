package com.linkysoft.shefaeshop.domain.interactors.impl;

import android.util.Log;

import com.linkysoft.shefaeshop.Network.ApiClient;
import com.linkysoft.shefaeshop.Network.response.StripeClientSecretResponse;
import com.linkysoft.shefaeshop.Network.services.StripeApiInterface;
import com.linkysoft.shefaeshop.domain.executor.Executor;
import com.linkysoft.shefaeshop.domain.executor.MainThread;
import com.linkysoft.shefaeshop.domain.interactors.StripeInteractor;
import com.linkysoft.shefaeshop.domain.interactors.base.AbstractInteractor;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StripeInteractorImpl extends AbstractInteractor {
    private StripeInteractor.CallBack mCallback;
    private StripeApiInterface apiService;
    private JsonObject jsonObject;
    private String auth_token;

    public StripeInteractorImpl(Executor threadExecutor, MainThread mainThread, StripeInteractor.CallBack callBack, String auth_token, JsonObject jsonObject) {
        super(threadExecutor, mainThread);
        mCallback = callBack;
        this.auth_token = "Bearer "+auth_token;
        this.jsonObject = jsonObject;
    }

    @Override
    public void run() {
        apiService = ApiClient.getClient().create(StripeApiInterface.class);

        Call<StripeClientSecretResponse> call = apiService.getStripeClientSecret(auth_token, jsonObject);

        call.enqueue(new Callback<StripeClientSecretResponse>() {
            @Override
            public void onResponse(Call<StripeClientSecretResponse> call, Response<StripeClientSecretResponse> response) {
                try {
                    //Log.d("Test", response.body().getVariant());
                    mCallback.ononClientSecretReceived(response.body());
                } catch (Exception e) {
                    Log.e("Exception", e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<StripeClientSecretResponse> call, Throwable t) {
                //Log.d("Test", String.valueOf(call.isExecuted()));
                mCallback.ononClientSecretReceiveError();
            }
        });

    }
}
