package com.linkysoft.shefaeshop.domain.interactors;

import com.linkysoft.shefaeshop.Models.Product;

import java.util.List;

public interface ProductInteractor {
    interface CallBack {

        void onProductDownloaded(List<Product> products);

        void onProductDownloadError();
    }
}
