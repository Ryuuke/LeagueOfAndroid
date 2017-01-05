package com.home.yassine.leagueofandroid.core.champion.cache;

import com.home.yassine.leagueofandroid.core.base.BasePresenter;

/**
 * Created by Yassine on 02/01/2017.
 */

public interface CachePresenter extends BasePresenter<CacheView> {

    void loadChampionsData(Long number);
}
