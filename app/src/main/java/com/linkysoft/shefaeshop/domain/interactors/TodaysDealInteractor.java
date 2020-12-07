package com.linkysoft.shefaeshop.domain.interactors;

import com.linkysoft.shefaeshop.Models.Product;

import java.util.List;

public interface TodaysDealInteractor {
    interface CallBack {

        void onTodaysDealProductDownloaded(List<Product> products);

        void onTodaysDealProductDownloadError();
    }
}
