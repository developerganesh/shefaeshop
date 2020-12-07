package com.linkysoft.shefaeshop.domain.interactors;

import com.linkysoft.shefaeshop.Models.Wallet;

import java.util.List;

public interface WalletHistoryInteractor {
    interface CallBack {

        void onWalletHistoryLodaded(List<Wallet> walletList);

        void onWalletHistoryLoadError();
    }
}
