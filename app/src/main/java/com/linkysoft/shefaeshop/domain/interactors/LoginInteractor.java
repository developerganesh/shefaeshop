package com.linkysoft.shefaeshop.domain.interactors;

import com.linkysoft.shefaeshop.Network.response.AuthResponse;

public interface LoginInteractor {
    interface CallBack {

        void onValidLogin(AuthResponse authResponse);

        void onLoginError();
    }
}
