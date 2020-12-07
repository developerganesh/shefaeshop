package com.linkysoft.shefaeshop.Presentation.presenters;

import com.linkysoft.shefaeshop.Network.response.ProductSearchResponse;
import com.linkysoft.shefaeshop.Presentation.ui.fragments.ProductSearchView;
import com.linkysoft.shefaeshop.domain.executor.Executor;
import com.linkysoft.shefaeshop.domain.executor.MainThread;
import com.linkysoft.shefaeshop.domain.interactors.ProductSearchInteractor;
import com.linkysoft.shefaeshop.domain.interactors.impl.ProductSearchInteractorImpl;

public class ProductSearchPresenter extends AbstractPresenter implements ProductSearchInteractor.CallBack {
    private ProductSearchView ProductSearchView;

    public ProductSearchPresenter(Executor executor, MainThread mainThread, ProductSearchView ProductSearchView) {
        super(executor, mainThread);
        this.ProductSearchView = ProductSearchView;
    }

    public void getSearchedProducts(String url) {
        new ProductSearchInteractorImpl(mExecutor, mMainThread, this, url).execute();
    }


    @Override
    public void onProductSearched(ProductSearchResponse productSearchResponse) {
        if (ProductSearchView != null){
            ProductSearchView.setSearchedProduct(productSearchResponse);
        }
    }

    @Override
    public void onProductSearchedError() {

    }
}
