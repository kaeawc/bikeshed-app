package io.kaeawc.bikeshed.storage;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = DataModule.class)
public interface DataComponent {
    // Field injections of any dependencies of the App
    void inject(PhotoStorageComponent photoStorage);
}
