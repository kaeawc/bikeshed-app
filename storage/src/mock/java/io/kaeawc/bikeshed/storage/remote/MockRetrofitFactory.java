package io.kaeawc.bikeshed.storage.remote;

import android.support.annotation.NonNull;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit.Retrofit;
import retrofit.mock.CallBehaviorAdapter;
import retrofit.mock.MockRetrofit;
import retrofit.mock.NetworkBehavior;

public abstract class MockRetrofitFactory<A extends RestApi> implements RetrofitApiManager {

    private String mScenario;

    public MockRetrofitFactory(@NonNull String scenario) {
        mScenario = scenario;
    }

    private static class Builder<A extends RestApi> extends RetrofitApiManager.Builder<A> {

        public Builder() {

        }

        @NonNull
        public String getBaseUrl() {
            return "";
        }

        @NonNull
        public A build(A mock, Class<A> clazz) {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(getBaseUrl())
                    .build();

            // Create the Behavior object which manages the fake behavior and the background executor.
            NetworkBehavior behavior = NetworkBehavior.create();

            ExecutorService bg = Executors.newSingleThreadExecutor();

            // Create the mock implementation and use MockRetrofit to apply the behavior to it.
            MockRetrofit mockRetrofit = new MockRetrofit(behavior, new CallBehaviorAdapter(retrofit, bg));
            return mockRetrofit.<A>create(clazz, mock);
        }
    }
}
