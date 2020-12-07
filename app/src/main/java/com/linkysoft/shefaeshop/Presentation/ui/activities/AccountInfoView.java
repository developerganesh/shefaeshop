package com.linkysoft.shefaeshop.Presentation.ui.activities;

import com.linkysoft.shefaeshop.Models.ShippingAddress;
import com.linkysoft.shefaeshop.Models.User;
import com.linkysoft.shefaeshop.Network.response.ProfileInfoUpdateResponse;
import com.linkysoft.shefaeshop.Network.response.ShippingInfoResponse;

import java.util.List;

public interface AccountInfoView {
    void onProfileInfoUpdated(ProfileInfoUpdateResponse profileInfoUpdateResponse);
    void setShippingAddresses(List<ShippingAddress> shippingAddresses);
    void onShippingInfoCreated(ShippingInfoResponse shippingInfoResponse);
    void onShippingInfoDeleted(ShippingInfoResponse shippingInfoResponse);
    void setUpdatedUserInfo(User user);
}
