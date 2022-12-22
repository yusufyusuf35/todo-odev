package com.deliysuf.kisilerodev.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.deliysuf.kisilerodev.R;
import com.deliysuf.kisilerodev.data.entity.Yapilacak;
import com.deliysuf.kisilerodev.databinding.FragmentYapilacaklarGuncelleBinding;
import com.deliysuf.kisilerodev.ui.viewmodel.YapilacaklarGuncelleViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class YapilacaklarGuncelle extends Fragment {

private FragmentYapilacaklarGuncelleBinding binding;
private YapilacaklarGuncelleViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_yapilacaklar_guncelle,container,false);
        binding.setGuncelleFragment(this);
        binding.setGuncelleHeader("Guncelle Fragment");

        Yapilacak yapilacak = YapilacaklarGuncelleArgs.fromBundle(getArguments()).getYapilacak();
        binding.setYapilacak(yapilacak);
        return binding.getRoot();
    }
    public void guncelle(int yapilacak_id ,
                         String yapilacak_name ,
                         String yapilacak_not){

        viewModel.guncelle(yapilacak_id , yapilacak_name , yapilacak_not);


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).
                get(YapilacaklarGuncelleViewModel.class);

    }
}