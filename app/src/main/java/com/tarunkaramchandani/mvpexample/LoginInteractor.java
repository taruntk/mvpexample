package com.tarunkaramchandani.mvpexample;

import android.os.Handler;

/**
 * Created by tarunkaramchandani on 26/01/17.
 */

public class LoginInteractor implements ILoginInteractor {
    @Override
    public void login(final String username, final String password, final OnLoginFinishedListener listener) {
        // Mock login. Creating a handler to delay the answer a couple of seconds
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean error = false;
                if (!error) {
                    listener.onSuccess();
                }
            }
        }, 2000);
    }
}
