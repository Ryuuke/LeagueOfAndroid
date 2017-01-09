package com.home.yassine.leagueofandroid.utils;

/**
 * Created by Yassine on 03/01/2017.
 */

public abstract class AppConstants {

    // domain where you the champions.json file is hosted
    public static final String BASE_URL = "http://192.168.1.12:80/";

    public static final int NETWORK_CONNECTION_TIMEOUT_SEC = 30;
    public static final long CACHE_SIZE_BYTES = 10 * 1024 * 1024;
    public static final int CACHE_MAX_AGE_MIN = 2;
    public static final int CACHE_MAX_STALE_DAY = 7;
    public static final int CHAMPION_LIST_MAX_SIZE = 15; // last N champions shown
}
