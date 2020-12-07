package com.linkysoft.shefaeshop.Network.services;

import com.linkysoft.shefaeshop.Network.response.RemoveWishlistResponse;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Header;
import retrofit2.http.Url;

public interface RemoveWishlistApiInterface {
    @DELETE
    Call<RemoveWishlistResponse> removeWishlistItem(@Header("Authorization") String authHeader, @Url String url);
}
