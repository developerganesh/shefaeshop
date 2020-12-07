package com.linkysoft.shefaeshop.Network.services;

import com.linkysoft.shefaeshop.Network.response.CategoryResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AllCategoryApiInterface {
    @GET("categories")
    Call<CategoryResponse> getAllCategories();
}
