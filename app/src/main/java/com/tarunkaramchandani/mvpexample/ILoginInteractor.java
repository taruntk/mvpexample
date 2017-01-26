package com.tarunkaramchandani.mvpexample;

/**
 * Created by tarunkaramchandani on 26/01/17.
 */

interface ILoginInteractor {

    interface OnLoginFinishedListener {

        void onSuccess();
    }

    void login(String username, String password, OnLoginFinishedListener listener);

}
