package com.linkysoft.shefaeshop.domain.interactors;

import com.linkysoft.shefaeshop.Models.Product;

import java.util.List;

public interface FeaturedProductInteractor {
    interface CallBack {

        void onFeaturedProductDownloaded(List<Product> products);

        void onFeaturedProductDownloadError();
    }
}
