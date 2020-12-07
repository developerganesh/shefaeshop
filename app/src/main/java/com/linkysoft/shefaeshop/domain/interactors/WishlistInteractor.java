package com.linkysoft.shefaeshop.domain.interactors;

import com.linkysoft.shefaeshop.Models.WishlistModel;

import java.util.List;

public interface WishlistInteractor {
    interface CallBack {

        void onWishlistLodaded(List<WishlistModel> wishlistModels);

        void onWishlistError();
    }
}
