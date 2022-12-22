package com.deliysuf.kisilerodev.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.deliysuf.kisilerodev.data.entity.Yapilacak;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface YapilacakDao {
    @Query("SELECT * FROM Yapilacak")
   Single<List<Yapilacak>> yapilacaklariYukle();
    @Query("SELECT * FROM Yapilacak WHERE yapilacak_name like  '%' || :aramaKelimesi ||'%'")
    Single<List<Yapilacak>> ara(String aramaKelimesi);
    @Delete
    Completable sil(Yapilacak yapilacak);

    @Query("UPDATE  YAPILACAK SET yapilacak_name = :name,yapilacak_not = :not WHERE yapilacak_id = :id ")
    Completable guncelle(int id ,String name,String not);

    @Insert
    Completable kaydet(Yapilacak yapilacak);


}
