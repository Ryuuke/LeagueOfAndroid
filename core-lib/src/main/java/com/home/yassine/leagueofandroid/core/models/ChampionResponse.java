package com.home.yassine.leagueofandroid.core.models;

import java.util.HashMap;
import java.util.List;

import rx.Observable;

/**
 * Created by Yassine on 03/01/2017.
 */

public class ChampionResponse {

    private String type;
    private String version;

    private List<Champion> data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<Champion> getChampions() {
        return data;
    }

    public void setChampions(List<Champion> champions) {
        this.data = champions;
    }
}
