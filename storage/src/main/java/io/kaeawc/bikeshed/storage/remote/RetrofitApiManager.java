package io.kaeawc.bikeshed.storage.remote;

import android.support.annotation.NonNull;

import retrofit.Retrofit;

/**
 * Created by jason on 11/1/15.
 */
public interface RetrofitApiManager {

    abstract class Builder<A extends RestApi> {

        public Retrofit getBasicRetrofit() {
            return new Retrofit.Builder()
                    .baseUrl(getBaseUrl())
                    .build();
        }

        @NonNull
        public abstract String getBaseUrl();

        @NonNull
        public abstract A build(A mock, Class<A> clazz);
    }
}
