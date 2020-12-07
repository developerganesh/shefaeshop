package com.linkysoft.shefaeshop.Presentation.ui.fragments;

import com.linkysoft.shefaeshop.Models.CartModel;
import com.linkysoft.shefaeshop.Network.response.CartQuantityUpdateResponse;
import com.linkysoft.shefaeshop.Network.response.RemoveCartResponse;

import java.util.List;

public interface CartView {
    void setCartItems(List<CartModel> cartItems);
    void showRemoveCartMessage(RemoveCartResponse removeCartResponse);
    void showCartQuantityUpdateMessage(CartQuantityUpdateResponse cartQuantityUpdateResponse);
}
