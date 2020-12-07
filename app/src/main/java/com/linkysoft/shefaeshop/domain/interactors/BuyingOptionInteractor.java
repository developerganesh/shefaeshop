package com.linkysoft.shefaeshop.domain.interactors;

import com.linkysoft.shefaeshop.Network.response.VariantResponse;

public interface BuyingOptionInteractor {
    interface CallBack {

        void onGetVariantPrice(VariantResponse variantResponse);

        void onGetVariantPriceError();
    }
}
