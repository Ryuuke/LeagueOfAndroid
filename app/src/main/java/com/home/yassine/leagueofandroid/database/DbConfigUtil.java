package com.home.yassine.leagueofandroid.database;

import com.home.yassine.leagueofandroid.core.models.Champion;
import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Yassine on 05/01/2017.
 */

public class DbConfigUtil extends OrmLiteConfigUtil {
    private static final Class<?>[] classes = new Class[]{ Champion.class };

    public static void main(String[] args) throws IOException, SQLException {
        writeConfigFile(new File("app/src/main/res/raw/ormlite_config.txt"), classes);
    }
}
