package com.linkysoft.shefaeshop.Network.services;

import com.linkysoft.shefaeshop.Network.response.SliderImageResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SliderImageApiInterface {
    @GET("sliders")
    Call<SliderImageResponse> getSliderImages();
}
