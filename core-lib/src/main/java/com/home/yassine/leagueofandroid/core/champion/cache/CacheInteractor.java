package com.home.yassine.leagueofandroid.core.champion.cache;

import com.home.yassine.leagueofandroid.core.base.BaseInteractor;
import com.home.yassine.leagueofandroid.core.models.Champion;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Yassine on 02/01/2017.
 */

public interface CacheInteractor extends BaseInteractor{

    List<Champion> loadChampionsData(Long number) throws SQLException;

}
