package com.home.yassine.leagueofandroid.adapters;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.home.yassine.leagueofandroid.core.models.Champion;

import yassine.home.com.leagueofandroid.BR;

/**
 * Created by Yassine on 05/01/2017.
 */

public class ChampionViewHolder extends RecyclerView.ViewHolder {

    private final View view;
    private Champion champion;
    private ViewDataBinding viewDataBinding;

    public ChampionViewHolder(View itemView) {

        super(itemView);

        this.view = itemView;

        viewDataBinding = DataBindingUtil.bind(itemView);
    }

    public Champion getChampion() {
        return this.champion;
    }

    public void setChampion(Champion champion) {

        this.champion = champion;

        viewDataBinding.setVariable(BR.champion, champion);
        viewDataBinding.executePendingBindings();
    }
}
