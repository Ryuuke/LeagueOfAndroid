package com.home.yassine.leagueofandroid.DI.Champion.Search;

import com.home.yassine.leagueofandroid.fragments.SearchFragment;
import com.home.yassine.leagueofandroid.core.champion.search.Search;

import dagger.Subcomponent;

/**
 * Created by Yassine on 02/01/2017.
 */

@Search
@Subcomponent(modules = {AppSearchModule.class})
public interface SearchSubComponent {

    void inject(SearchFragment view);
}
