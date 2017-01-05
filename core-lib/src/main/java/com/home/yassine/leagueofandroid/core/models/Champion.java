package com.home.yassine.leagueofandroid.core.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Yassine on 03/01/2017.
 */

@DatabaseTable(tableName = "champions")
public class Champion implements Serializable {

    @DatabaseField(id = true)
    private int id;
    @DatabaseField
    private String name;
    @DatabaseField
    private String title;
    @DatabaseField
    private String key;
    @DatabaseField
    private Date date;

    public Champion() {

    }

    public Champion(int id, String name, String title) {

        this.id = id;
        this.name = name;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
