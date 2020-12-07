package com.linkysoft.shefaeshop.Network.services;

import com.linkysoft.shefaeshop.Network.response.ShippingInfoResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface ShippingInfoDeleteApiInterface {
    @GET("user/shipping/delete/{id}")
    Call<ShippingInfoResponse> deleteShippingAddress(@Header("Authorization") String authHeader, @Path("id") int id);
}
