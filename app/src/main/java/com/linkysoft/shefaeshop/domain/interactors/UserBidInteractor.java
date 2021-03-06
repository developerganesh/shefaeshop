package com.linkysoft.shefaeshop.domain.interactors;

import com.linkysoft.shefaeshop.Models.UserBid;

import java.util.List;

public interface UserBidInteractor {
    interface CallBack {

        void onUserBidLodaded(List<UserBid> userBids);

        void onUserBidError();
    }
}
