package com.linkysoft.shefaeshop.domain.interactors;

import com.linkysoft.shefaeshop.Models.AuctionProduct;

import java.util.List;

public interface AuctionProductInteractor {
    interface CallBack {

        void onAuctionProductDownloaded(List<AuctionProduct> auctionProducts);

        void onAuctionProductDownloadError();
    }
}
