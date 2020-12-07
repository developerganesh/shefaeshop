package com.linkysoft.shefaeshop.Presentation.presenters;

import com.linkysoft.shefaeshop.Network.response.RegistrationResponse;
import com.linkysoft.shefaeshop.Presentation.ui.activities.RegisterView;
import com.linkysoft.shefaeshop.domain.executor.Executor;
import com.linkysoft.shefaeshop.domain.executor.MainThread;
import com.linkysoft.shefaeshop.domain.interactors.RegisterInteractor;
import com.linkysoft.shefaeshop.domain.interactors.impl.RegisterInteractorImpl;
import com.google.gson.JsonObject;

public class RegisterPresenter extends AbstractPresenter implements RegisterInteractor.CallBack {

    private RegisterView registerView;

    public RegisterPresenter(Executor executor, MainThread mainThread, RegisterView registerView) {
        super(executor, mainThread);
        this.registerView = registerView;
    }

    public void validateRegistration(JsonObject jsonObject) {
        new RegisterInteractorImpl(mExecutor, mMainThread, this, jsonObject).execute();
    }

    @Override
    public void onRegistrationDone(RegistrationResponse registrationResponse) {
        if (registerView != null){
            registerView.setRegistrationResponse(registrationResponse);
        }
    }

    @Override
    public void onRegistrationError() {

    }
}
