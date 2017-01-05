package com.home.yassine.leagueofandroid.utils;

import com.home.yassine.leagueofandroid.core.utils.SchedulerProvider;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Yassine on 03/01/2017.
 */

public class AppSchedulerProvider implements SchedulerProvider {

    @Override
    public Scheduler mainThread() {
        return AndroidSchedulers.mainThread();
    }

    @Override
    public Scheduler io() {
        return Schedulers.io();
    }
}
