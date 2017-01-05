package com.home.yassine.leagueofandroid.core.champion.search;

import com.home.yassine.leagueofandroid.core.client.LoLApi;
import com.home.yassine.leagueofandroid.core.models.ChampionResponse;
import com.home.yassine.leagueofandroid.core.utils.SchedulerProvider;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Yassine on 02/01/2017.
 */

public class SearchInteractorImpl implements SearchInteractor {

    private SchedulerProvider scheduler;
    private LoLApi loLApi;

    @Inject
    public SearchInteractorImpl(SchedulerProvider scheduler, LoLApi loLApi) {
        this.scheduler = scheduler;
        this.loLApi = loLApi;
    }

    @Override
    public Observable<ChampionResponse> searchChampions() {

        return loLApi.getChampions().subscribeOn(scheduler.io()).asObservable();
    }

    @Override
    public void unbind() {

    }
}
