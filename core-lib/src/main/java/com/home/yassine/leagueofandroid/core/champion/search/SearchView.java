package com.home.yassine.leagueofandroid.core.champion.search;

import com.home.yassine.leagueofandroid.core.base.BaseView;
import com.home.yassine.leagueofandroid.core.models.Champion;

/**
 * Created by Yassine on 02/01/2017.
 */

public interface SearchView extends BaseView {

    void addChampion(Champion champion);

    void showProgress();

    void hideProgress();

    void showQueryNoResult();

    void showRetryMessage(Throwable throwable);
}
