package com.linkysoft.shefaeshop.domain.interactors.impl;

import android.util.Log;

import com.linkysoft.shefaeshop.Network.ApiClient;
import com.linkysoft.shefaeshop.Network.response.RemoveWishlistResponse;
import com.linkysoft.shefaeshop.Network.services.RemoveWishlistApiInterface;
import com.linkysoft.shefaeshop.domain.executor.Executor;
import com.linkysoft.shefaeshop.domain.executor.MainThread;
import com.linkysoft.shefaeshop.domain.interactors.RemoveWishlistInteractor;
import com.linkysoft.shefaeshop.domain.interactors.base.AbstractInteractor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RemoveWishlistInteractorImpl extends AbstractInteractor {
    private RemoveWishlistInteractor.CallBack mCallback;
    private RemoveWishlistApiInterface apiService;
    private int wishlist_id;
    private String token;

    public RemoveWishlistInteractorImpl(Executor threadExecutor, MainThread mainThread, RemoveWishlistInteractor.CallBack callBack, int wishlist_id, String token) {
        super(threadExecutor, mainThread);
        mCallback = callBack;
        this.wishlist_id = wishlist_id;
        this.token = "Bearer "+token;
    }

    @Override
    public void run() {
        apiService = ApiClient.getClient().create(RemoveWishlistApiInterface.class);
        Call<RemoveWishlistResponse> call = apiService.removeWishlistItem(token,"wishlists/"+wishlist_id);

        call.enqueue(new Callback<RemoveWishlistResponse>() {
            @Override
            public void onResponse(Call<RemoveWishlistResponse> call, Response<RemoveWishlistResponse> response) {
                try {
                    mCallback.onWishlistItemRemoved(response.body());
                } catch (Exception e) {
                    Log.e("Exception", e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<RemoveWishlistResponse> call, Throwable t) {
                mCallback.onWishlistItemRemovedError();
            }
        });

    }
}
