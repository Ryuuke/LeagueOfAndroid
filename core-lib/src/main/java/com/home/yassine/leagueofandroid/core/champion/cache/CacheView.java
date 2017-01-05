package com.home.yassine.leagueofandroid.core.champion.cache;

import com.home.yassine.leagueofandroid.core.base.BaseView;
import com.home.yassine.leagueofandroid.core.models.Champion;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Yassine on 02/01/2017.
 */

public interface CacheView extends BaseView {

    void refreshViewData();
    void setViewData(List<Champion> champions);

    void showError(Throwable throwable);
}
