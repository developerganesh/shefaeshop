package com.linkysoft.shefaeshop.domain.interactors;

import com.linkysoft.shefaeshop.Network.response.ShippingInfoResponse;

public interface ShippingInfoCreateInteractor {
    interface CallBack {

        void onShippingInfoCreated(ShippingInfoResponse shippingInfoResponse);

        void onShippingInfoCreateError();
    }
}
