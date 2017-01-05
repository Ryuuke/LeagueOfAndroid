package com.home.yassine.leagueofandroid.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.home.yassine.leagueofandroid.DI.ApplicationComponent;
import com.home.yassine.leagueofandroid.LeagueApp;

/**
 * Created by Yassine on 25/12/2016.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        injectDependencies(LeagueApp.getComponent());
    }

    protected abstract void injectDependencies(ApplicationComponent applicationComponent);
}