package com.home.yassine.leagueofandroid.core.champion.cache;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Yassine on 02/01/2017.
 */

@Module
public class CacheModule {

    CacheView view;

    public CacheModule(CacheView view) {
        this.view = view;
    }

    @Provides
    public CacheView providesCacheView() {
        return view;
    }

    @Provides
    @Cache
    public CachePresenter providesCachePresenter(CachePresenterImpl cachePresenter) {
        cachePresenter.bind(view);
        return cachePresenter;
    }

    @Provides
    @Cache
    public CacheInteractor providesCacheInteractor(CacheInteractorImpl cacheInteractor) {
        return cacheInteractor;
    }
}
