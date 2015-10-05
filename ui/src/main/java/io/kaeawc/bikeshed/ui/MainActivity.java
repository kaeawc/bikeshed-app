package io.kaeawc.bikeshed.ui;

import android.app.Application;
import android.net.ConnectivityManager;
import android.net.Network;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.kaeawc.bikeshed.core.App;
import io.kaeawc.bikeshed.core.AppComponent;
import io.kaeawc.bikeshed.core.AppModule;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onResume() {
        super.onResume();

        App app = getApp();

        if (app == null) {
            return;
        }

        ConnectivityManager connectivityManager = app.component().connectivityManager();
        Network network = connectivityManager.getActiveNetwork();
    }

    @Nullable
    public App getApp() {
        Application application = getApplication();

        if (application == null || !(application instanceof App)) {
            return null;
        }

        return (App) application;
    }
}
