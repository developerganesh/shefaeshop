package com.linkysoft.shefaeshop.Presentation.presenters;

import com.linkysoft.shefaeshop.Models.PurchaseHistory;
import com.linkysoft.shefaeshop.Presentation.ui.activities.PurchaseHistoryView;
import com.linkysoft.shefaeshop.domain.executor.Executor;
import com.linkysoft.shefaeshop.domain.executor.MainThread;
import com.linkysoft.shefaeshop.domain.interactors.PurchaseHistoryInteractor;
import com.linkysoft.shefaeshop.domain.interactors.impl.PurchaseHistoryInteractorImpl;

import java.util.List;

public class PurchaseHistoryPresenter extends AbstractPresenter implements PurchaseHistoryInteractor.CallBack {
    private PurchaseHistoryView purchaseHistoryView;

    public PurchaseHistoryPresenter(Executor executor, MainThread mainThread, PurchaseHistoryView purchaseHistoryView) {
        super(executor, mainThread);
        this.purchaseHistoryView = purchaseHistoryView;
    }

    public void getPurchaseHistoryItems(int id, String token) {
        new PurchaseHistoryInteractorImpl(mExecutor, mMainThread, this, id, token).execute();
    }

    @Override
    public void onPurchaseHistoryLodaded(List<PurchaseHistory> purchaseHistories) {
        if (purchaseHistoryView != null){
            purchaseHistoryView.onPurchaseHistoryLoaded(purchaseHistories);
        }
    }

    @Override
    public void onPurchaseHistoryLodadedError() {

    }
}
