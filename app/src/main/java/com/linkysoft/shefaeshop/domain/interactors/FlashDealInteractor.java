package com.linkysoft.shefaeshop.domain.interactors;

import com.linkysoft.shefaeshop.Models.FlashDeal;

public interface FlashDealInteractor {
    interface CallBack {

        void onFlashDealProductDownloaded(FlashDeal flashDeal);

        void onFlashDealProductDownloadError();
    }
}