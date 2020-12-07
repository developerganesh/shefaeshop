package com.linkysoft.shefaeshop.domain.interactors;

import com.linkysoft.shefaeshop.Models.Product;

import java.util.List;

public interface BestSellingInteractor {
    interface CallBack {

        void onBestSellingProductDownloaded(List<Product> products);

        void onBestSellingProductDownloadError();
    }
}
