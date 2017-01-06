package com.home.yassine.leagueofandroid.fragments;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.home.yassine.leagueofandroid.DI.ApplicationComponent;
import com.home.yassine.leagueofandroid.DI.champion.cache.AppCacheModule;
import com.home.yassine.leagueofandroid.adapters.ChampionsRecyclerViwAdapter;
import com.home.yassine.leagueofandroid.base.BaseFragment;
import com.home.yassine.leagueofandroid.core.base.BaseView;
import com.home.yassine.leagueofandroid.core.champion.cache.CachePresenter;
import com.home.yassine.leagueofandroid.core.champion.cache.CacheView;
import com.home.yassine.leagueofandroid.core.models.Champion;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import yassine.home.com.leagueofandroid.R;

/**
 * Created by Yassine on 26/12/2016.
 */

public class CacheFragment extends BaseFragment implements CacheView {

    @Inject
    CachePresenter cachePresenter;
    @Inject
    ChampionsRecyclerViwAdapter adapter;
    @Inject
    Resources resources;
    @Inject
    Context context;
    @Inject
    CacheListener listener;
    @Inject
    LinearLayoutManager linearLayout;

    @BindView(R.id.list)
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.cache_frag, container, false);
        ButterKnife.bind(this, view);
        recyclerView.setLayoutManager(linearLayout);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;

        cachePresenter.unbind();
        cachePresenter = null;
    }


    @Override
    public void onResume() {
        super.onResume();

        this.refreshViewData();
    }

    @Override
    protected void injectDependencies(ApplicationComponent applicationComponent, Context context) {

        applicationComponent.plus(new AppCacheModule(this, context)).inject(this);
    }

    public static CacheFragment newInstance() {
        return new CacheFragment();
    }

    @Override
    public void refreshViewData() {
        cachePresenter.loadChampionsData((long) 10);
    }

    @Override
    public void setViewData(List<Champion> champions) {
        adapter.setChampions(champions);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showError(Throwable throwable) {
        Toast.makeText(context, throwable.getMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void showMessage(String message) {
        listener.showMessage(message);
    }

    @Override
    public void showOfflineMessage() {
        listener.showOfflineMessage();
    }

    public interface CacheListener extends BaseView {

    }
}
