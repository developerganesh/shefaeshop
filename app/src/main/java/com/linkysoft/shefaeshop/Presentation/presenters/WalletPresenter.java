package com.linkysoft.shefaeshop.Presentation.presenters;

import com.linkysoft.shefaeshop.Models.Wallet;
import com.linkysoft.shefaeshop.Presentation.ui.activities.WalletView;
import com.linkysoft.shefaeshop.domain.executor.Executor;
import com.linkysoft.shefaeshop.domain.executor.MainThread;
import com.linkysoft.shefaeshop.domain.interactors.WalletBalanceInteractor;
import com.linkysoft.shefaeshop.domain.interactors.WalletHistoryInteractor;
import com.linkysoft.shefaeshop.domain.interactors.impl.WalletBalanceInteractorImpl;
import com.linkysoft.shefaeshop.domain.interactors.impl.WalletHistoryInteractorImpl;

import java.util.List;

public class WalletPresenter extends AbstractPresenter implements WalletBalanceInteractor.CallBack, WalletHistoryInteractor.CallBack {
    private WalletView walletView;

    public WalletPresenter(Executor executor, MainThread mainThread, WalletView walletView) {
        super(executor, mainThread);
        this.walletView = walletView;
    }

    public void getWalletBalance(int id, String token) {
        new WalletBalanceInteractorImpl(mExecutor, mMainThread, this, id, token).execute();
    }

    public void getWalletHistory(int id, String token) {
        new WalletHistoryInteractorImpl(mExecutor, mMainThread, this, id, token).execute();
    }

    @Override
    public void onWalletBalanceLodaded(Double balance) {
        if (walletView != null){
            walletView.setWalletBalance(balance);
        }
    }

    @Override
    public void onWalletBalanceLoadError() {

    }

    @Override
    public void onWalletHistoryLodaded(List<Wallet> walletList) {
        if(walletView != null){
            walletView.setWalletHistory(walletList);
        }
    }

    @Override
    public void onWalletHistoryLoadError() {

    }
}
