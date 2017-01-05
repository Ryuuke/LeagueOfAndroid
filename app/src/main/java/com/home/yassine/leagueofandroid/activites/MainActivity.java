package com.home.yassine.leagueofandroid.activites;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.home.yassine.leagueofandroid.DI.ApplicationComponent;
import com.home.yassine.leagueofandroid.base.BaseActivity;
import com.home.yassine.leagueofandroid.fragments.CacheFragment;
import com.home.yassine.leagueofandroid.fragments.SearchFragment;
import com.home.yassine.leagueofandroid.core.models.Champion;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import yassine.home.com.leagueofandroid.R;

public class MainActivity extends BaseActivity implements SearchFragment.ChampionListener, CacheFragment.CacheListener{

    @Inject
    Context context;
    @Inject
    Resources resources;

    @BindView(R.id.activity_main)
    LinearLayout layout;

    private CacheFragment cacheFragment;
    private SearchFragment searchFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (savedInstanceState == null) {
            searchFragment = SearchFragment.newInstance();
            cacheFragment = CacheFragment.newInstance();
            attachFragments();
        }
        else {
            searchFragment = (SearchFragment) getSupportFragmentManager().findFragmentById(R.id.search_frag_id);
            cacheFragment = (CacheFragment) getSupportFragmentManager().findFragmentById(R.id.cache_frag_id);
        }
    }

    private void attachFragments() {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.search_frag_id, searchFragment, "tag_search_frag");
        fragmentTransaction.replace(R.id.cache_frag_id, cacheFragment, "tag_cache_frag");
        fragmentTransaction.commitAllowingStateLoss();
    }

    @Override
    protected void injectDependencies(ApplicationComponent applicationComponent) {
        applicationComponent.inject(this);
    }

    @Override
    public void addChampion(Champion champion) {
        cacheFragment.refreshViewData();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showOfflineMessage() {

        Snackbar.make(layout, "No internet connection", Snackbar.LENGTH_SHORT)
                .setAction("Go online ", v -> {
                    startActivity(new Intent(
                            Settings.ACTION_WIFI_SETTINGS));
                })
                .setActionTextColor(Color.GREEN).show();
    }
}