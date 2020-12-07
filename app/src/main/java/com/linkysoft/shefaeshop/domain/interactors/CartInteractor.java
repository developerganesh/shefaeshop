package com.linkysoft.shefaeshop.domain.interactors;

import com.linkysoft.shefaeshop.Models.CartModel;

import java.util.List;

public interface CartInteractor {
    interface CallBack {

        void onCartLodaded(List<CartModel> cartModel);

        void onCartError();
    }
}
