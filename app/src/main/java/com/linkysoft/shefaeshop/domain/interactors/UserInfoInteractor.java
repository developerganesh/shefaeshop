package com.linkysoft.shefaeshop.domain.interactors;

import com.linkysoft.shefaeshop.Models.User;

public interface UserInfoInteractor {
    interface CallBack {

        void onUserInfoLodaded(User user);

        void onUserInfoError();
    }
}
