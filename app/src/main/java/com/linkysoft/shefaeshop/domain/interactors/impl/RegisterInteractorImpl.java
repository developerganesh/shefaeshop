package com.linkysoft.shefaeshop.domain.interactors.impl;

import android.util.Log;

import com.linkysoft.shefaeshop.Network.ApiClient;
import com.linkysoft.shefaeshop.Network.response.RegistrationResponse;
import com.linkysoft.shefaeshop.Network.services.RegisterApiInterface;
import com.linkysoft.shefaeshop.domain.executor.Executor;
import com.linkysoft.shefaeshop.domain.executor.MainThread;
import com.linkysoft.shefaeshop.domain.interactors.RegisterInteractor;
import com.linkysoft.shefaeshop.domain.interactors.base.AbstractInteractor;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterInteractorImpl extends AbstractInteractor {
    private RegisterInteractor.CallBack mCallback;
    private RegisterApiInterface apiService;
    private JsonObject jsonObject;

    public RegisterInteractorImpl(Executor threadExecutor, MainThread mainThread, RegisterInteractor.CallBack callBack, JsonObject jsonObject) {
        super(threadExecutor, mainThread);
        mCallback = callBack;
        this.jsonObject = jsonObject;
    }

    @Override
    public void run() {
        apiService = ApiClient.getClient().create(RegisterApiInterface.class);

        Call<RegistrationResponse> call = apiService.sendResgisterRequest(jsonObject);

        call.enqueue(new Callback<RegistrationResponse>() {
            @Override
            public void onResponse(Call<RegistrationResponse> call, Response<RegistrationResponse> response) {
                try {
                    //Log.d("Test", response.body().getVariant());
                    mCallback.onRegistrationDone(response.body());
                } catch (Exception e) {
                    Log.e("Exception", e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<RegistrationResponse> call, Throwable t) {
                //Log.d("Test", String.valueOf(call.isExecuted()));
                mCallback.onRegistrationError();
            }
        });

    }
}
