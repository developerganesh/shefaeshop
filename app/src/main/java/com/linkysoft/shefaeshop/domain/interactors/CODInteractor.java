package com.linkysoft.shefaeshop.domain.interactors;

import com.linkysoft.shefaeshop.Network.response.OrderResponse;

public interface CODInteractor {
    interface CallBack {

        void onCODOrderSubmitted(OrderResponse orderResponse);

        void onCODOrderSubmitError();
    }
}
