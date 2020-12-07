package com.linkysoft.shefaeshop.Presentation.ui.activities;

import com.linkysoft.shefaeshop.Models.Product;
import com.linkysoft.shefaeshop.Models.Shop;

import java.util.List;

public interface SellerShopView {
    void onShopDetailsLoaded(Shop shop);
    void setFeaturedProducts(List<Product> products);
    void setTopSellingProducts(List<Product> products);
    void setNewProducts(List<Product> products);
}
