package com.deliysuf.kisilerodev.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.deliysuf.kisilerodev.data.entity.Yapilacak;
import com.deliysuf.kisilerodev.data.repo.YapilacakDaoRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class YapilacakKaydetViewModel extends ViewModel {

    private YapilacakDaoRepository yDao;
    @Inject
    public YapilacakKaydetViewModel(YapilacakDaoRepository yDao) {
        this.yDao = yDao;

    }
    public void kaydet(String yapilacak_name , String yapilacak_not){
        yDao.kaydet(yapilacak_name , yapilacak_not);
   }

   }
