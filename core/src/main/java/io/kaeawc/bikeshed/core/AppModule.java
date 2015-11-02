package io.kaeawc.bikeshed.core;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;

import dagger.Module;
import dagger.Provides;
import timber.log.Timber;

import javax.inject.Singleton;

/**
 * A module for Android-specific dependencies which require a {@link android.content.Context} or
 * {@link android.app.Application} to create.
 */
@Module
public class AppModule {
    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    /**
     * Expose the application to the graph.
     */
    @Provides @Singleton Application application() {
        return application;
    }

    @Provides @Singleton
    ConnectivityManager provideConnectivityManager() {
        return (ConnectivityManager) application.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    @Provides @Singleton
    Timber.Tree provideTree() {
        return new Timber.DebugTree();
    }
}
