package com.home.yassine.leagueofandroid.utils;

/**
 * Created by Yassine on 03/01/2017.
 */

public abstract class AppConstants {

    // domain where you the champions.json file is hosted
    public static final String BASE_URL = "http://192.168.1.12:80/";

    public static final int NETWORK_CONNECTION_TIMEOUT = 30; // 30 sec
    public static final long CACHE_SIZE = 10 * 1024 * 1024; // 10 MB
    public static final int CACHE_MAX_AGE = 2; // 2 min
    public static final int CACHE_MAX_STALE = 7; // 7 day
}
