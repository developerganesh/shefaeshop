package com.linkysoft.shefaeshop.Presentation.presenters;

import com.linkysoft.shefaeshop.Models.Review;
import com.linkysoft.shefaeshop.Presentation.ui.activities.ProductReviewView;
import com.linkysoft.shefaeshop.domain.executor.Executor;
import com.linkysoft.shefaeshop.domain.executor.MainThread;
import com.linkysoft.shefaeshop.domain.interactors.ReviewInteractor;
import com.linkysoft.shefaeshop.domain.interactors.impl.ReviewInteractorImpl;

import java.util.List;

public class ProductReviewPresenter extends AbstractPresenter implements ReviewInteractor.CallBack {
    private ProductReviewView productReviewView;

    public ProductReviewPresenter(Executor executor, MainThread mainThread, ProductReviewView productReviewView) {
        super(executor, mainThread);
        this.productReviewView = productReviewView;
    }

    public void sendUpdateProfileRequest(String url) {
        new ReviewInteractorImpl(mExecutor, mMainThread, this, url).execute();
    }


    @Override
    public void onReviewLodaded(List<Review> reviews) {
        if (productReviewView != null){
            productReviewView.onReviewsLoaded(reviews);
        }
    }

    @Override
    public void onReviewError() {

    }
}
