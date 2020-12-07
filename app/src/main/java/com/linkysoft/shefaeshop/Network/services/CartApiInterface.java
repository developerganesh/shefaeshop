package com.linkysoft.shefaeshop.Network.services;

import com.linkysoft.shefaeshop.Network.response.CartResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Url;

public interface CartApiInterface {
    @GET
    Call<CartResponse> getCartItems(@Header("Authorization") String authHeader, @Url String url);
}
