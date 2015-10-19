package io.kaeawc.bikeshed.core;

import android.app.Application;
import android.net.ConnectivityManager;
import android.support.annotation.NonNull;

import javax.inject.Inject;

public class App extends Application {

    private AppComponent appComponent;

    @Inject ConnectivityManager mConnectivityManager;

    @Override public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    @NonNull
    public AppComponent component() {
        return appComponent;
    }
}
