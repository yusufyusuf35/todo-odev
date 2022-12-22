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
import com.deliysuf.kisilerodev.databinding.FragmentYapilacaklarKaydetBinding;
import com.deliysuf.kisilerodev.ui.viewmodel.YapilacakKaydetViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class YapilacaklarKaydet extends Fragment {
private FragmentYapilacaklarKaydetBinding binding;
private YapilacakKaydetViewModel viewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater , R.layout.fragment_yapilacaklar_kaydet,container,false);
        binding.setKaydetHeader("Yapilacak Kaydet");
        binding.setYapilacaklarFragment(this);

        return binding.getRoot();
    }
    public void kaydet(String yapilacak_name , String yapilacak_not){
        viewModel.kaydet(yapilacak_name,yapilacak_not);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(YapilacakKaydetViewModel.class);

    }
}