package com.linkysoft.shefaeshop.Presentation.ui.activities.impl;

import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.linkysoft.shefaeshop.Models.Category;
import com.linkysoft.shefaeshop.Models.SubCategory;
import com.linkysoft.shefaeshop.Presentation.presenters.SubSubCategoryPresenter;
import com.linkysoft.shefaeshop.Presentation.ui.activities.SubCategoryView;
import com.linkysoft.shefaeshop.Presentation.ui.adapters.SubCategoryAdapter;
import com.linkysoft.shefaeshop.Presentation.ui.listeners.SubCategoryClickListener;
import com.linkysoft.shefaeshop.R;
import com.linkysoft.shefaeshop.Threading.MainThreadImpl;
import com.linkysoft.shefaeshop.Utils.AppConfig;
import com.linkysoft.shefaeshop.domain.executor.impl.ThreadExecutor;
import com.thekhaeng.recyclerviewmargin.LayoutMarginDecoration;

import java.util.List;

public class SubCategoryActivity extends BaseActivity implements SubCategoryView, SubCategoryClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_sub_category);

        Category category = (Category) getIntent().getSerializableExtra("category");

        initializeActionBar();
        setTitle(category.getName());

        SubSubCategoryPresenter subSubCategoryPresenter = new SubSubCategoryPresenter(ThreadExecutor.getInstance(), MainThreadImpl.getInstance(), this);
        subSubCategoryPresenter.getSubSubCategories(category.getLinks().getSubCategories());
    }

    @Override
    public void setSubCategories(List<SubCategory> subCategories) {
        RecyclerView recyclerView = findViewById(R.id.subcategory_list);
        LinearLayoutManager linearLayoutManager
                = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration( new LayoutMarginDecoration( 1,  AppConfig.convertDpToPx(getApplicationContext(), 10)) );
        SubCategoryAdapter adapter = new SubCategoryAdapter(this, subCategories, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onSubCategoryItemClick(SubCategory subCategory) {
        Intent intent = new Intent(this, ProductListingActivity.class);
        intent.putExtra("title", subCategory.getName());
        intent.putExtra("url", subCategory.getLinks().getProducts());
        startActivity(intent);
    }
}
