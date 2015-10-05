package io.kaeawc.bikeshed.data;

import javax.inject.Singleton;

import dagger.Component;
import io.kaeawc.bikeshed.Photos;

@Singleton
@Component(modules = DataModule.class)
public interface DataComponent {
    // Field injections of any dependencies of the App
    void inject(Photos photos);
}
