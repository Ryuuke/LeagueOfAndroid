package com.home.yassine.leagueofandroid.DI.Champion.Search;

import android.content.Context;

import com.home.yassine.leagueofandroid.fragments.SearchFragment;
import com.home.yassine.leagueofandroid.core.champion.search.Search;
import com.home.yassine.leagueofandroid.core.champion.search.SearchModule;
import com.home.yassine.leagueofandroid.core.champion.search.SearchView;

import java.security.InvalidParameterException;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Yassine on 05/01/2017.
 */

@Module
public class AppSearchModule extends SearchModule {

    private SearchFragment.ChampionListener championListener;

    public AppSearchModule(SearchView view, Context context) {
        super(view);

        SearchFragment.ChampionListener listener = (SearchFragment.ChampionListener) context;

        if (listener == null)
            throw new InvalidParameterException("context must implement championListener interface");

        this.championListener = listener;
    }

    @Provides
    @Search
    public SearchFragment.ChampionListener provideListener() {
        return this.championListener;
    }
}
