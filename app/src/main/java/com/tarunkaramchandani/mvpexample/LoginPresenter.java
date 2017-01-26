package com.tarunkaramchandani.mvpexample;

import android.text.TextUtils;

/**
 * Created by tarunkaramchandani on 26/01/17.
 */

public class LoginPresenter implements ILoginPresenter, ILoginInteractor.OnLoginFinishedListener {
    private ILoginView loginView;
    private ILoginInteractor iLoginInteractor;

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
        this.iLoginInteractor = new LoginInteractor();
    }

    @Override
    public void validateCredentials(String username, String password) {
        loginView.showProgress();
        boolean error = false;
        if (TextUtils.isEmpty(username)) {
            loginView.hideProgress();
            loginView.setUsernameError();
            error = true;
        }
        if (TextUtils.isEmpty(password)) {
            loginView.hideProgress();
            loginView.setPasswordError();
            error = true;
        }
        if (!error) {
            iLoginInteractor.login(username, password, this);
        }
    }

    @Override
    public void onSuccess() {
        if (loginView != null) {
            loginView.hideProgress();
            loginView.navigateToHome();
        }
    }

    interface ILoginView {
        void showProgress();

        void hideProgress();

        void setUsernameError();

        void setPasswordError();

        void navigateToHome();
    }
}