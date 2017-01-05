package com.home.yassine.leagueofandroid.core.champion.search;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Yassine on 02/01/2017.
 */

@Module
public class SearchModule {

    SearchView view;

    public SearchModule(SearchView view) {
        this.view = view;
    }

    @Provides
    public SearchView providesSearchView() {
        return this.view;
    }

    @Provides
    @Search
    public SearchInteractor provideSearchInteractor(SearchInteractorImpl searchInteractor) {
        return searchInteractor;
    }

    @Provides
    @Search
    public SearchPresenter provideSearchPresenter(SearchPresenterImpl searchPresenter) {
        searchPresenter.bind(view);
        return searchPresenter;
    }
}
