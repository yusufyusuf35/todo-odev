package com.deliysuf.kisilerodev.data.repo;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.deliysuf.kisilerodev.data.entity.Yapilacak;
import com.deliysuf.kisilerodev.room.YapilacakDao;

import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class YapilacakDaoRepository {
    private MutableLiveData<List<Yapilacak>> yapilacaklarList ;
    private YapilacakDao yDao;

    public MutableLiveData<List<Yapilacak>> getYapilacaklarList() {
        return yapilacaklarList;
    }

    public YapilacakDaoRepository(YapilacakDao yDao) {
        yapilacaklarList = new MutableLiveData<>();
        this.yDao = yDao;
    }

    public void yaplacaklariyukle(){
        yDao.yapilacaklariYukle().
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new SingleObserver<List<Yapilacak>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(List<Yapilacak> yapilacaks) {
               yapilacaklarList.setValue(yapilacaks);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }
    public void kaydet(String yapilacak_name , String yapilacak_not){

     Yapilacak yapilacak = new Yapilacak(0,
             yapilacak_name,yapilacak_not);

        yDao.kaydet(yapilacak).subscribeOn(Schedulers.io()).
             observeOn(AndroidSchedulers.mainThread()).
             subscribe(new CompletableObserver() {
         @Override
         public void onSubscribe(Disposable d) {
         }

         @Override
         public void onComplete() {

         }

         @Override
         public void onError(Throwable e) {
Log.e("error","dfffffffff");
         }
     });

    }

    public void sil(int yapilacak_id){

        Yapilacak yapilacak = new Yapilacak(yapilacak_id,
                "","");
        yDao.sil(yapilacak).subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onComplete() {
               yaplacaklariyukle();
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }
    public void daoguncelle(int yapilacak_id ,
                         String yapilacak_name ,
                         String yapilacak_not){


        Yapilacak yapilacak = new
                Yapilacak(yapilacak_id,yapilacak_name,yapilacak_not);

        yDao.guncelle(yapilacak_id,yapilacak_name,yapilacak_not).subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {
            }
            @Override
            public void onComplete() {

                yaplacaklariyukle();
                Log.e("basari","hoooooooooooooooooooooleeeeeeeeeeee");
            }
            @Override
            public void onError(Throwable e) {
            }
        });
    }

    public void ara(String aramaKelimesi){
        yDao.ara(aramaKelimesi).subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).subscribe(new SingleObserver<List<Yapilacak>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<Yapilacak> yapilacaks) {
                        yapilacaklarList.setValue(yapilacaks);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }
}
