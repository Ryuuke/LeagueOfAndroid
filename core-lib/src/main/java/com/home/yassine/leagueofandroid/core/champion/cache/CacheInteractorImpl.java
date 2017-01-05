package com.home.yassine.leagueofandroid.core.champion.cache;

import com.home.yassine.leagueofandroid.core.database.DbHelper;
import com.home.yassine.leagueofandroid.core.models.Champion;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Yassine on 02/01/2017.
 */

public class CacheInteractorImpl implements CacheInteractor {

    @Inject
    DbHelper dbHelper;

    @Inject
    public CacheInteractorImpl() {

    }

    @Override
    public List<Champion> loadChampionsData(Long number) throws SQLException {
        return dbHelper.selectChampions(number);
    }

    @Override
    public void unbind() {

    }
}
