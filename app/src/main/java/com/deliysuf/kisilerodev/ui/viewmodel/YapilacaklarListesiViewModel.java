package com.deliysuf.kisilerodev.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.deliysuf.kisilerodev.data.entity.Yapilacak;
import com.deliysuf.kisilerodev.data.repo.YapilacakDaoRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class YapilacaklarListesiViewModel extends ViewModel {
    public MutableLiveData<List<Yapilacak>> yapilacakListesi = new MutableLiveData<>();
    private YapilacakDaoRepository yDao ;
    @Inject
    public YapilacaklarListesiViewModel( YapilacakDaoRepository yDao) {
        this.yDao = yDao;
        yapilacaklariYukle();
        yapilacakListesi = yDao.getYapilacaklarList();
    }

    public void sil(int yapilacak_id){
        yDao.sil(yapilacak_id);

    }
    public void ara(String aramaKelimesi){
        yDao.ara(aramaKelimesi);
    }
    public void yapilacaklariYukle(){
        yDao.yaplacaklariyukle();
    }
}
