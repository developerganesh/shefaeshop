package com.linkysoft.shefaeshop.domain.interactors;

import com.linkysoft.shefaeshop.Network.response.OrderResponse;

public interface OrderInteractor {
    interface CallBack {

        void onOrderSubmitted(OrderResponse orderResponse);

        void onOrderSubmitError();
    }
}
