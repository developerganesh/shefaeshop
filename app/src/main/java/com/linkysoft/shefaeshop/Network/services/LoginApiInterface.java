package com.linkysoft.shefaeshop.Network.services;

import com.linkysoft.shefaeshop.Network.response.AuthResponse;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginApiInterface {

    @POST("auth/login")
    Call<AuthResponse> sendLoginCredentials(@Body JsonObject jsonObject);
}
