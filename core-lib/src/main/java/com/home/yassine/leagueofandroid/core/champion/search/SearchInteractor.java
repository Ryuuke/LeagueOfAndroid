package com.home.yassine.leagueofandroid.core.champion.search;

import com.home.yassine.leagueofandroid.core.base.BaseInteractor;
import com.home.yassine.leagueofandroid.core.models.Champion;
import com.home.yassine.leagueofandroid.core.models.ChampionResponse;

import rx.Observable;

/**
 * Created by Yassine on 02/01/2017.
 */

public interface SearchInteractor extends BaseInteractor{

    Observable<ChampionResponse> searchChampions();
}
