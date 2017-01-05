package com.home.yassine.leagueofandroid.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.home.yassine.leagueofandroid.core.database.DbHelper;
import com.home.yassine.leagueofandroid.core.models.Champion;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import yassine.home.com.leagueofandroid.R;

/**
 * Created by Yassine on 05/01/2017.
 */

public class DbHelperImpl extends OrmLiteSqliteOpenHelper implements DbHelper {

    private static final String DB_NAME = "lol_android.db";
    private static final int DB_VERSION = 1;

    private Dao<Champion, Integer> championDao;

    @Inject
    public DbHelperImpl(Context context) {
        super(context, DB_NAME, null, DB_VERSION, R.raw.ormlite_config);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Champion.class);
        } catch (SQLException e) {
            Log.e(DbHelperImpl.class.getName(), "Error, unable to create table");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, Champion.class, true);
        } catch (SQLException e) {
            Log.e(DbHelperImpl.class.getName(), "Error, unable to delete table");
        }

        onCreate(database, connectionSource);
    }

    public Dao<Champion, Integer> getChampionDao() throws SQLException {

        if (championDao == null)
            championDao = getDao(Champion.class);

        return championDao;
    }

    public int addChampion(Champion champion) throws SQLException {
        Champion result = getChampionDao().queryForFirst(
                getChampionDao()
                        .queryBuilder()
                        .where().eq("id", champion.getId())
                        .prepare());

        if (result != null)
            getChampionDao().delete(result);

        return getChampionDao().create(champion);
    }

    @Override
    public List<Champion> selectChampions(Long limit) throws SQLException {
        return getChampionDao().query(getChampionDao().queryBuilder().limit(limit).orderBy("date", false).prepare());
    }
}
