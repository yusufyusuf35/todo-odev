package com.deliysuf.kisilerodev.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuProvider;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.deliysuf.kisilerodev.R;
import com.deliysuf.kisilerodev.databinding.ActivityMainBinding;
import com.deliysuf.kisilerodev.databinding.FragmentYapilacaklarListesiBinding;
import com.deliysuf.kisilerodev.ui.adapter.YapilacakAdapter;
import com.deliysuf.kisilerodev.ui.viewmodel.YapilacaklarListesiViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class YapilacaklarListesi extends Fragment implements SearchView.OnQueryTextListener {
    private FragmentYapilacaklarListesiBinding binding;
    private YapilacaklarListesiViewModel viewModel;
    private YapilacakAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_yapilacaklar_listesi,container,false);
        ((AppCompatActivity)getActivity()).setSupportActionBar(binding.listToolBar);
        binding.setHeaderToolbar("Yapilacaklar listesi");
        binding.setYapilacakFragment(this);
        viewModel.yapilacakListesi.observe(getViewLifecycleOwner(),liste->{
             adapter = new YapilacakAdapter(requireContext(),liste,viewModel);
            binding.setAdapter(adapter);

        });

        requireActivity().addMenuProvider(new MenuProvider() {
           @Override
           public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
               menuInflater.inflate(R.menu.search_menu,menu);
               MenuItem item = menu.findItem(R.id.actionViewSearch);
               SearchView searchView = (SearchView) item.getActionView();
               searchView.setOnQueryTextListener(YapilacaklarListesi.this);
           }

           @Override
           public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
               return false;
           }
       },getViewLifecycleOwner(), Lifecycle.State.RESUMED);

        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         viewModel = new ViewModelProvider(this).
                 get(YapilacaklarListesiViewModel.class);
    }

    @Override
    public void onResume() {
        viewModel.yapilacaklariYukle();

        super.onResume();



    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        viewModel.ara(query);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        viewModel.ara(newText);
        return true;

    }
   public void fabTikla(View view){
       Navigation.findNavController(view).navigate(R.id.toYapilacaklariKaydet);
   }
}