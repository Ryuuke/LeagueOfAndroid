package com.home.yassine.leagueofandroid.DI.database;

import com.home.yassine.leagueofandroid.core.database.DbHelper;
import com.home.yassine.leagueofandroid.database.DbHelperImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Yassine on 05/01/2017.
 */

@Module
public class DatabaseModule {

    @Provides
    @Singleton
    public DbHelper provideDbHelper(DbHelperImpl dbHelper) {
        return dbHelper;
    }
}
