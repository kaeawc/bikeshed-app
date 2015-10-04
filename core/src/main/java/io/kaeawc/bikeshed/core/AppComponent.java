package io.kaeawc.bikeshed.core;

import android.app.Application;
import android.net.ConnectivityManager;

import dagger.Component;
import javax.inject.Singleton;

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = AppModule.class)
public interface AppComponent {
    // Field injections of any dependencies of the App
    void inject(App application);

    // Exported for child-components.
    Application application();
    ConnectivityManager connectivityManager();
}
