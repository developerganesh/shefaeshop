package com.linkysoft.shefaeshop.domain.interactors;

import com.linkysoft.shefaeshop.Models.ProductDetails;

public interface ProductDetailsInteractor {
    interface CallBack {

        void onProductDetailsDownloaded(ProductDetails productDetails);

        void onProductDetailsDownloadError();
    }
}
