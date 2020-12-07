package com.linkysoft.shefaeshop.Presentation.ui.fragments;

import com.linkysoft.shefaeshop.Models.AuctionProduct;
import com.linkysoft.shefaeshop.Models.Banner;
import com.linkysoft.shefaeshop.Models.Brand;
import com.linkysoft.shefaeshop.Models.Category;
import com.linkysoft.shefaeshop.Models.FlashDeal;
import com.linkysoft.shefaeshop.Models.Product;
import com.linkysoft.shefaeshop.Models.SliderImage;
import com.linkysoft.shefaeshop.Network.response.AppSettingsResponse;
import com.linkysoft.shefaeshop.Network.response.AuctionBidResponse;

import java.util.List;

public interface HomeView {
    void onAppSettingsLoaded(AppSettingsResponse appSettingsResponse);

    void setSliderImages(List<SliderImage> sliderImages);

    void setHomeCategories(List<Category> categories);

    void setTodaysDeal(List<Product> products);

    void setFlashDeal(FlashDeal flashDeal);

    void setBanners(List<Banner> banners);

    void setBestSelling(List<Product> products);

    void setFeaturedProducts(List<Product> products);

    void setTopCategories(List<Category> categories);

    void setPopularBrands(List<Brand> brands);

    void setAuctionProducts(List<AuctionProduct> auctionProducts);

    void onAuctionBidSubmitted(AuctionBidResponse auctionBidResponse);
}