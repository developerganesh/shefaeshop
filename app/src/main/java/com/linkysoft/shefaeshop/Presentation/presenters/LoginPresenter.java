package com.linkysoft.shefaeshop.Presentation.presenters;

import com.linkysoft.shefaeshop.Network.response.AuthResponse;
import com.linkysoft.shefaeshop.Presentation.ui.activities.LoginView;
import com.linkysoft.shefaeshop.domain.executor.Executor;
import com.linkysoft.shefaeshop.domain.executor.MainThread;
import com.linkysoft.shefaeshop.domain.interactors.LoginInteractor;
import com.linkysoft.shefaeshop.domain.interactors.SocialLoginInteractor;
import com.linkysoft.shefaeshop.domain.interactors.impl.LoginInteractorImpl;
import com.linkysoft.shefaeshop.domain.interactors.impl.SocialLoginInteractorImpl;

public class LoginPresenter extends AbstractPresenter implements LoginInteractor.CallBack, SocialLoginInteractor.CallBack {

    private LoginView loginView;

    public LoginPresenter(Executor executor, MainThread mainThread, LoginView loginView) {
        super(executor, mainThread);
        this.loginView = loginView;
    }

    public void validLogin(String email, String password) {
        new LoginInteractorImpl(mExecutor, mMainThread, this, email, password).execute();
    }

    public void validSocialLogin(String id, String name, String email) {
        new SocialLoginInteractorImpl(mExecutor, mMainThread, this, id, name, email).execute();
    }

    @Override
    public void onValidLogin(AuthResponse authResponse) {
        if (loginView != null){
            loginView.setLoginResponse(authResponse);
        }
    }

    @Override
    public void onLoginError() {

    }
}
