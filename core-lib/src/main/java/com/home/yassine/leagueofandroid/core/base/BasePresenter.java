package com.home.yassine.leagueofandroid.core.base;

/**
 * Created by Yassine on 02/01/2017.
 */

public interface BasePresenter<T> {

    void bind(T view);

    void unbind();
}
