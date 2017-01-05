package com.home.yassine.leagueofandroid.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.home.yassine.leagueofandroid.core.models.Champion;
import com.jakewharton.rxbinding.view.RxView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.subjects.PublishSubject;
import yassine.home.com.leagueofandroid.R;

/**
 * Created by Yassine on 05/01/2017.
 */

public class ChampionsRecyclerViwAdapter extends RecyclerView.Adapter<ChampionViewHolder> {

    private List<Champion> champions;

    private PublishSubject<Champion> publishSubject = PublishSubject.create();

    @Inject
    public ChampionsRecyclerViwAdapter() {

    }

    public void setChampions(List<Champion> champions) {
        this.champions = new ArrayList<>(champions);
    }

    @Override
    public ChampionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_character, parent, false);
        return new ChampionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ChampionViewHolder holder, int position) {

        final Champion champion = this.champions.get(position);

        holder.setChampion(champion);

        RxView.clicks(holder.itemView).map(__ -> holder.getChampion()).subscribe(publishSubject::onNext);
    }

    public Observable<Champion> asObservable() {
        return publishSubject.asObservable();
    }

    @Override
    public int getItemCount() {
        return this.champions.size();
    }
}
