package com.linkysoft.shefaeshop.Presentation.ui.activities.impl;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.linkysoft.shefaeshop.Models.WishlistModel;
import com.linkysoft.shefaeshop.Models.WishlistProduct;
import com.linkysoft.shefaeshop.Network.response.AuthResponse;
import com.linkysoft.shefaeshop.Presentation.presenters.WishlistPresenter;
import com.linkysoft.shefaeshop.Presentation.ui.activities.WishlistView;
import com.linkysoft.shefaeshop.Presentation.ui.adapters.WishlistAdapter;
import com.linkysoft.shefaeshop.Presentation.ui.listeners.WishlistProductClickListener;
import com.linkysoft.shefaeshop.R;
import com.linkysoft.shefaeshop.Threading.MainThreadImpl;
import com.linkysoft.shefaeshop.Utils.AppConfig;
import com.linkysoft.shefaeshop.Utils.RecyclerViewMargin;
import com.linkysoft.shefaeshop.Utils.UserPrefs;
import com.linkysoft.shefaeshop.domain.executor.impl.ThreadExecutor;

import java.util.List;

public class WishlistActivity extends BaseActivity implements WishlistView, WishlistProductClickListener {
    private AuthResponse authResponse;
    private WishlistPresenter wishlistPresenter;
    private ProgressBar progressBar;
    private TextView wishlist_empty_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist);

        initializeActionBar();
        setTitle("My Wishlist");

        progressBar = findViewById(R.id.item_progress_bar);
        wishlist_empty_text = findViewById(R.id.wishlist_empty_text);

        wishlistPresenter = new WishlistPresenter(ThreadExecutor.getInstance(), MainThreadImpl.getInstance(), this);

        authResponse = new UserPrefs(getApplicationContext()).getAuthPreferenceObjectJson("auth_response");
        if(authResponse != null && authResponse.getUser() != null){
            progressBar.setVisibility(View.VISIBLE);
            wishlistPresenter.getWishlistItems(authResponse.getUser().getId(), authResponse.getAccessToken());
        }
        else {
            //startActivityForResult(new Intent(getActivity(), LoginActivity.class), 100);
            //getActivity().finish();
        }
    }

    @Override
    public void setWishlistProducts(List<WishlistModel> wishlistModels) {
        progressBar.setVisibility(View.GONE);
        if (wishlistModels.size() > 0){
            WishlistAdapter adapter = new WishlistAdapter(getApplicationContext(), wishlistModels, this);
            RecyclerView recyclerView = findViewById(R.id.product_list);
            LinearLayoutManager horizontalLayoutManager
                    = new LinearLayoutManager(WishlistActivity.this, RecyclerView.VERTICAL, false);
            recyclerView.setLayoutManager(horizontalLayoutManager);
            RecyclerViewMargin decoration = new RecyclerViewMargin(AppConfig.convertDpToPx(this,10), 1);
            recyclerView.addItemDecoration(decoration);
            recyclerView.setAdapter(adapter);
        }
        else {
            wishlist_empty_text.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onProductItemClick(WishlistProduct product) {
        Intent intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
        intent.putExtra("product_name", product.getName());
        intent.putExtra("link", product.getLinks().getDetails());
        intent.putExtra("top_selling", product.getLinks().getRelated());
        startActivity(intent);
    }
}
