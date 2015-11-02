package io.kaeawc.bikeshed.storage.remote;

import android.support.annotation.NonNull;

import io.kaeawc.bikeshed.entities.IpAddress;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

public interface IpifyApi extends RestApi {

    @GET(" ")
    Call<IpAddress> getIpAddress(@Query("format") @NonNull String format);
}
