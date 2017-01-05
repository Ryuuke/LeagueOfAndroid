package com.home.yassine.leagueofandroid.base;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.home.yassine.leagueofandroid.DI.ApplicationComponent;
import com.home.yassine.leagueofandroid.LeagueApp;

/**
 * Created by Yassine on 26/12/2016.
 */

public abstract class BaseFragment extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        injectDependencies(LeagueApp.getComponent(), context);
    }

    protected abstract void injectDependencies(ApplicationComponent applicationComponent, Context context);
}
