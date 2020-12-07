package com.linkysoft.shefaeshop.Presentation.presenters;

import com.linkysoft.shefaeshop.Models.OrderDetail;
import com.linkysoft.shefaeshop.Presentation.ui.activities.PurchaseHistoryDetailsView;
import com.linkysoft.shefaeshop.domain.executor.Executor;
import com.linkysoft.shefaeshop.domain.executor.MainThread;
import com.linkysoft.shefaeshop.domain.interactors.PurchaseHistoryDetailsInteractor;
import com.linkysoft.shefaeshop.domain.interactors.impl.PurchaseHistoryDetailsInteractorImpl;

import java.util.List;

public class PurchaseHistoryDetailsPresenter extends AbstractPresenter implements PurchaseHistoryDetailsInteractor.CallBack {

    private PurchaseHistoryDetailsView purchaseHistoryDetailsView;

    public PurchaseHistoryDetailsPresenter(Executor executor, MainThread mainThread, PurchaseHistoryDetailsView purchaseHistoryDetailsView) {
        super(executor, mainThread);
        this.purchaseHistoryDetailsView = purchaseHistoryDetailsView;
    }

    public void getOrderDetails(String token, String url){
        new PurchaseHistoryDetailsInteractorImpl(mExecutor, mMainThread, this, url, token).execute();
    }

    @Override
    public void onOrderDetailsLoaded(List<OrderDetail> orderDetails) {
        if (purchaseHistoryDetailsView != null){
            purchaseHistoryDetailsView.onOrderDetailsLoaded(orderDetails);
        }
    }

    @Override
    public void onOrderDetailsLoadError() {

    }
}
