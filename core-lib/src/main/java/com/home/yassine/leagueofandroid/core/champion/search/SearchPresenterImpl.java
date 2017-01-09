package com.home.yassine.leagueofandroid.core.champion.search;

import com.home.yassine.leagueofandroid.core.database.DbHelper;
import com.home.yassine.leagueofandroid.core.models.Champion;
import com.home.yassine.leagueofandroid.core.models.ChampionResponse;
import com.home.yassine.leagueofandroid.core.utils.SchedulerProvider;

import java.sql.Date;
import java.sql.SQLException;

import javax.inject.Inject;

import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.subscriptions.Subscriptions;

/**
 * Created by Yassine on 02/01/2017.
 */

public class SearchPresenterImpl implements SearchPresenter {

    SearchView view;

    @Inject
    DbHelper dbHelper;

    @Inject
    SearchInteractor searchInteractor;

    private SchedulerProvider scheduler;
    private Subscription subscription = Subscriptions.empty();


    @Inject
    public SearchPresenterImpl(SchedulerProvider scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public boolean isValidQuery(String query) {
        return !query.isEmpty();
    }

    public void searchChampionByName(boolean isConnected, String name) {

        if (view == null)
            return;


        view.showProgress();

        subscription = searchInteractor.searchChampions()
                .map(ChampionResponse::getChampions)
                .flatMapIterable(champions -> champions)
                .filter(champion -> champion.getKey().toLowerCase().equals(name.toLowerCase()))
                .first()
                .doOnNext(champion -> {

                    if (champion == null)
                        throw Exceptions.propagate(new ChampionNotFoundException());

                    champion.setDate(new java.util.Date());

                    // cache it
                    try {
                        dbHelper.addChampion(champion);
                    } catch (SQLException e) {
                        throw Exceptions.propagate(e);
                    }
                })
                .observeOn(scheduler.mainThread())
                .subscribe(champion -> {

                    if (view == null)
                        return;

                    view.hideProgress();
                    view.addChampion(champion);

                    if (!isConnected) {
                        view.showOfflineMessage();
                    }

                }, throwable -> {

                    if (view == null)
                        return;

                    view.hideProgress();

                    if (!isConnected) {
                        view.showOfflineMessage();
                    }

                    if (throwable instanceof ChampionNotFoundException) {
                        view.showQueryNoResult();
                    }
                    else {
                        view.showRetryMessage(throwable);
                    }
                });
    }

    @Override
    public void bind(SearchView view) {
        this.view = view;
    }

    @Override
    public void unbind() {

        if (!subscription.isUnsubscribed())
            subscription.unsubscribe();

        searchInteractor.unbind();
        this.view = null;
        searchInteractor = null;
    }
}
