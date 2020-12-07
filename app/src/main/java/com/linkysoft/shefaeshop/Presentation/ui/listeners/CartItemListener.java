package com.linkysoft.shefaeshop.Presentation.ui.listeners;

import com.linkysoft.shefaeshop.Models.CartModel;

public interface CartItemListener {
    void onCartRemove(CartModel cartModel);
    void onQuantityUpdate(int quantity, CartModel cartModel);
}
