package com.linkysoft.shefaeshop.domain.interactors.impl;

import android.util.Log;

import com.linkysoft.shefaeshop.Network.ApiClient;
import com.linkysoft.shefaeshop.Network.response.ReviewResponse;
import com.linkysoft.shefaeshop.Network.services.ReviewApiInterface;
import com.linkysoft.shefaeshop.domain.executor.Executor;
import com.linkysoft.shefaeshop.domain.executor.MainThread;
import com.linkysoft.shefaeshop.domain.interactors.ReviewInteractor;
import com.linkysoft.shefaeshop.domain.interactors.base.AbstractInteractor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReviewInteractorImpl extends AbstractInteractor {
    private ReviewInteractor.CallBack mCallback;
    private ReviewApiInterface apiService;
    private String url;

    public ReviewInteractorImpl(Executor threadExecutor, MainThread mainThread, ReviewInteractor.CallBack callBack, String url) {
        super(threadExecutor, mainThread);
        mCallback = callBack;
        this.url = url;
    }

    @Override
    public void run() {
        apiService = ApiClient.getClient().create(ReviewApiInterface.class);
        Call<ReviewResponse> call = apiService.getReviews(url);

        call.enqueue(new Callback<ReviewResponse>() {
            @Override
            public void onResponse(Call<ReviewResponse> call, Response<ReviewResponse> response) {
                try {
                    mCallback.onReviewLodaded(response.body().getData());
                } catch (Exception e) {
                    Log.e("Exception", e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<ReviewResponse> call, Throwable t) {
                mCallback.onReviewError();
            }
        });

    }
}
