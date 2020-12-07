package com.linkysoft.shefaeshop.Presentation.ui.activities;

import com.linkysoft.shefaeshop.Network.response.CouponResponse;
import com.linkysoft.shefaeshop.Network.response.OrderResponse;

public interface PaymentView {
    void onCouponApplied(CouponResponse couponResponse);
    void onOrderSubmitted(OrderResponse orderResponse);
}
