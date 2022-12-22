package com.deliysuf.kisilerodev.di;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.room.Room;

import com.deliysuf.kisilerodev.data.entity.Yapilacak;
import com.deliysuf.kisilerodev.data.repo.YapilacakDaoRepository;
import com.deliysuf.kisilerodev.room.VeriTabani;
import com.deliysuf.kisilerodev.room.YapilacakDao;

import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
@Module
@InstallIn(SingletonComponent.class)
public class AppModule {

    @Provides
    @Singleton
    public YapilacakDaoRepository yapilacaklarDaoprovider(YapilacakDao yDao){
        return new YapilacakDaoRepository(yDao);
    }
    @Provides
    @Singleton
    public YapilacakDao provideDao(@ApplicationContext Context context){
       VeriTabani vt = Room.databaseBuilder(context,
               VeriTabani.class,
               "yap").build();

        return vt.getyapilacakDao() ;
    }


}
