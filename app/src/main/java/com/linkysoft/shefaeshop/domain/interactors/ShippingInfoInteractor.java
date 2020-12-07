package com.linkysoft.shefaeshop.domain.interactors;

import com.linkysoft.shefaeshop.Models.ShippingAddress;
import java.util.List;

public interface ShippingInfoInteractor {
    interface CallBack {

        void onShippingInfoRetrived(List<ShippingAddress> shippingAddresses);

        void onShippingInfoRetrivedError();
    }
}
