package com.deliysuf.kisilerodev.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.deliysuf.kisilerodev.data.entity.Yapilacak;

@Database(entities = {Yapilacak.class},version = 1)
public abstract class VeriTabani extends RoomDatabase {
    public abstract YapilacakDao getyapilacakDao();
}
