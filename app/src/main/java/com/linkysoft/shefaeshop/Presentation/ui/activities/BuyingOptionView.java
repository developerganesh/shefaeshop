package com.linkysoft.shefaeshop.Presentation.ui.activities;

import com.linkysoft.shefaeshop.Network.response.AddToCartResponse;
import com.linkysoft.shefaeshop.Network.response.VariantResponse;

public interface BuyingOptionView {
    void setVariantprice(VariantResponse variantResponse);
    void setAddToCartMessage(AddToCartResponse addToCartResponse);
}
