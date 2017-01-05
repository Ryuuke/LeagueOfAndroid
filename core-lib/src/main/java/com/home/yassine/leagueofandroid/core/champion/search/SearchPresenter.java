package com.home.yassine.leagueofandroid.core.champion.search;

import com.home.yassine.leagueofandroid.core.base.BasePresenter;

/**
 * Created by Yassine on 02/01/2017.
 */

public interface SearchPresenter extends BasePresenter<SearchView> {

    void searchChampionByName(boolean isConnected, String name);

    boolean isValidQuery(String query);
}
