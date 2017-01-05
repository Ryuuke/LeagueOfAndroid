package com.home.yassine.leagueofandroid.core.champion.cache;

import java.sql.SQLException;

import javax.inject.Inject;

/**
 * Created by Yassine on 02/01/2017.
 */

public class CachePresenterImpl implements CachePresenter {

    CacheView view;

    CacheInteractor cacheInteractor;

    @Inject
    public CachePresenterImpl(CacheInteractor cacheInteractor) {
        this.cacheInteractor = cacheInteractor;
    }

    @Override
    public void loadChampionsData(Long number) {

        if (view == null)
            return;

        try {
            view.setViewData(cacheInteractor.loadChampionsData(number));
        } catch (SQLException e) {
            view.showError(e);
        }
    }

    @Override
    public void bind(CacheView view) {
        this.view = view;
    }

    @Override
    public void unbind() {
        this.cacheInteractor.unbind();
        this.view = null;
    }
}
