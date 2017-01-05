package com.home.yassine.leagueofandroid.core.client;

import com.home.yassine.leagueofandroid.core.models.Champion;
import com.home.yassine.leagueofandroid.core.models.ChampionResponse;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Yassine on 03/01/2017.
 */

public interface LoLApi {

    @GET("/champions.json")
    Observable<ChampionResponse> getChampions();
}
