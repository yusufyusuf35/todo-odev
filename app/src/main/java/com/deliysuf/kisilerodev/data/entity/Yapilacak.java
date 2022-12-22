package com.deliysuf.kisilerodev.data.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Yapilacak implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "yapilacak_id")
    @NonNull
    private int yapilacak_id ;
    @ColumnInfo(name = "yapilacak_name")
    @NonNull
    private String yapilacak_name;
    @NonNull
    @ColumnInfo(name = "yapilacak_not")
    private String yapilacak_not;

    public Yapilacak() {
    }

    public Yapilacak(int yapilacak_id, @NonNull String yapilacak_name, @NonNull String yapilacak_not) {
        this.yapilacak_id = yapilacak_id;
        this.yapilacak_name = yapilacak_name;
        this.yapilacak_not = yapilacak_not;
    }

    public int getYapilacak_id() {
        return yapilacak_id;
    }

    public void setYapilacak_id(int yapilacak_id) {
        this.yapilacak_id = yapilacak_id;
    }
    @NonNull
    public String getYapilacak_name() {
        return yapilacak_name;
    }

    public void setYapilacak_name(@NonNull String yapilacak_name) {
        this.yapilacak_name = yapilacak_name;
    }
    @NonNull
    public String getYapilacak_not() {
        return yapilacak_not;
    }

    public void setYapilacak_not(@NonNull String yapilacak_not) {
        this.yapilacak_not = yapilacak_not;
    }
}
