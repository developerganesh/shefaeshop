package com.linkysoft.shefaeshop.Presentation.ui.activities;

import com.linkysoft.shefaeshop.Models.UserBid;
import com.linkysoft.shefaeshop.Network.response.AuctionBidResponse;

import java.util.List;

public interface MybidView {
    void setUserBids(List<UserBid> userBids);
    void onAuctionBidSubmitted(AuctionBidResponse auctionBidResponse);
}
