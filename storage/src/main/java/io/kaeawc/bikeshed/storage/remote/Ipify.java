package io.kaeawc.bikeshed.storage.remote;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by jason on 11/1/15.
 */
public class Ipify {

    // initialize Executor
    @Nullable
    private static volatile Ipify sInstance;

    @NonNull
    private IpifyApiManager mApiManager;

    public Ipify() {
        mApiManager = new IpifyApiManager();
    }

    public Ipify(IpifyApiManager apiManager) {
        mApiManager = apiManager;
    }

    public static Ipify getInstance() {
        if (sInstance == null) {
            synchronized (Ipify.class) {
                if (sInstance == null) {
                    sInstance = new Ipify();
                }
            }
        }

        return sInstance;
    }

    public static void setInstance(Ipify instance) {
        sInstance = instance;
    }

    @NonNull
    public IpifyApiManager getApiManager() {
        return mApiManager;
    }

    public void getIpAddress() {
        getApiManager().getIpAddress();
    }
}
