package com.linkysoft.shefaeshop.Network.services;

import com.linkysoft.shefaeshop.Network.response.BrandResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BrandApiInterface {
    @GET("brands")
    Call<BrandResponse> getBrands();
}
