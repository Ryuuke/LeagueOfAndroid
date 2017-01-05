package com.home.yassine.leagueofandroid.core.utils;

import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * Created by Yassine on 03/01/2017.
 */

public interface SchedulerProvider {

    Scheduler mainThread();
    Scheduler io();
}
