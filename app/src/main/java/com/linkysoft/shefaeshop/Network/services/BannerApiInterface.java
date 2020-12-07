package com.linkysoft.shefaeshop.Network.services;

import com.linkysoft.shefaeshop.Network.response.BannerResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BannerApiInterface {
    @GET("banners")
    Call<BannerResponse> getBanners();
}
