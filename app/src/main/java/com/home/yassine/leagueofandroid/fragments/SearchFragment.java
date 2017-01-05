package com.home.yassine.leagueofandroid.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;

import com.home.yassine.leagueofandroid.base.BaseFragment;
import com.home.yassine.leagueofandroid.DI.ApplicationComponent;
import com.home.yassine.leagueofandroid.DI.Champion.Search.AppSearchModule;
import com.home.yassine.leagueofandroid.core.base.BaseView;
import com.home.yassine.leagueofandroid.core.champion.search.SearchPresenter;
import com.home.yassine.leagueofandroid.core.champion.search.SearchView;
import com.home.yassine.leagueofandroid.core.models.Champion;
import com.mirhoseini.utils.Utils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import yassine.home.com.leagueofandroid.R;

/**
 * Created by Yassine on 03/01/2017.
 */

public class SearchFragment extends BaseFragment implements SearchView {

    @Inject
    ChampionListener listener;
    @Inject
    Context context;
    @Inject
    SearchPresenter searchPresenter;

    @BindView(R.id.champion_name_tv)
    AutoCompleteTextView championTextView;

    private ProgressDialog progressDialog;

    public SearchFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.search_frag, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    protected void injectDependencies(ApplicationComponent applicationComponent, Context context) {
        applicationComponent.plus(new AppSearchModule(this, context)).inject(this);
    }

    @Override
    public void addChampion(Champion champion) {

        if (listener == null)
            return;

        listener.addChampion(champion);
    }

    @Override
    public void showProgress() {

        if (progressDialog != null)
            progressDialog.dismiss();

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setIndeterminate(true);
        progressDialog.setTitle(getString(R.string.loading_champion_data));
        progressDialog.show();
    }

    @Override
    public void hideProgress() {

        if (progressDialog == null)
            return;

        progressDialog.dismiss();
    }

    @OnClick(R.id.search_btn)
    void onShowClick(View view) {

        championTextView.setError(null);

        Utils.hideKeyboard(context, championTextView);

        String query = championTextView.getText().toString().trim();

        if (searchPresenter.isValidQuery(query)) {
            searchPresenter.searchChampionByName(Utils.isConnected(context), query);
        }
        else {
            championTextView.setError(getString(R.string.invalid_champion_name));
            championTextView.requestFocus();
        }
    }

    @Override
    public void showQueryNoResult() {
        listener.showMessage(getString(R.string.no_champion_found));
    }

    @Override
    public void showRetryMessage(Throwable throwable) {
        listener.showMessage(getString(R.string.error_occurred));
    }

    @Override
    public void showMessage(String message) {
        listener.showMessage(message);
    }

    @Override
    public void showOfflineMessage() {
        listener.showOfflineMessage();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        searchPresenter.unbind();
    }

    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    public interface ChampionListener extends BaseView {
        void addChampion(Champion champion);
    }
}
