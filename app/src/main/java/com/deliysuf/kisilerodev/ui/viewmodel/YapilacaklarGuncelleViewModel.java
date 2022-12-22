package com.deliysuf.kisilerodev.ui.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.deliysuf.kisilerodev.data.entity.Yapilacak;
import com.deliysuf.kisilerodev.data.repo.YapilacakDaoRepository;

import java.io.Closeable;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class YapilacaklarGuncelleViewModel extends ViewModel {

    private YapilacakDaoRepository yDao;
    @Inject
    public YapilacaklarGuncelleViewModel(YapilacakDaoRepository yDao) {
        this.yDao = yDao;

    }



    public void guncelle(int yapilacak_id , String yapilacak_name , String yapilacak_not){
        yDao.daoguncelle(yapilacak_id,yapilacak_name,yapilacak_not);
    }

}
