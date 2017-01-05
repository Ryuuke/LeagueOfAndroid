package com.home.yassine.leagueofandroid.core.database;

import com.home.yassine.leagueofandroid.core.models.Champion;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Yassine on 05/01/2017.
 */

public interface DbHelper {

    List<Champion> selectChampions(Long limit) throws SQLException;

    int addChampion(Champion champion) throws SQLException;
}
