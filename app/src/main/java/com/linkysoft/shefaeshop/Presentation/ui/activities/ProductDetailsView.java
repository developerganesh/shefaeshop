package com.linkysoft.shefaeshop.Presentation.ui.activities;

import com.linkysoft.shefaeshop.Models.Product;
import com.linkysoft.shefaeshop.Models.ProductDetails;
import com.linkysoft.shefaeshop.Network.response.AddToCartResponse;
import com.linkysoft.shefaeshop.Network.response.AddToWishlistResponse;
import com.linkysoft.shefaeshop.Network.response.CheckWishlistResponse;
import com.linkysoft.shefaeshop.Network.response.RemoveWishlistResponse;

import java.util.List;

public interface ProductDetailsView {
    void setProductDetails(ProductDetails productDetails);
    void setRelatedProducts(List<Product> relatedProducts);
    void setTopSellingProducts(List<Product> topSellingProducts);
    void setAddToCartMessage(AddToCartResponse addToCartResponse);
    void setAddToWishlistMessage(AddToWishlistResponse addToWishlistMessage);
    void onCheckWishlist(CheckWishlistResponse checkWishlistResponse);
    void onRemoveFromWishlist(RemoveWishlistResponse removeWishlistResponse);
}
