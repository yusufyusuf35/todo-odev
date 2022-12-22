package com.deliysuf.kisilerodev.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.deliysuf.kisilerodev.R;
import com.deliysuf.kisilerodev.data.entity.Yapilacak;
import com.deliysuf.kisilerodev.databinding.ItemListBinding;
import com.deliysuf.kisilerodev.ui.fragment.YapilacaklarListesiDirections;
import com.deliysuf.kisilerodev.ui.viewmodel.YapilacaklarListesiViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class YapilacakAdapter extends RecyclerView.Adapter<YapilacakAdapter.YapilacaklarHolder> {
    private Context mcontext;
    private List<Yapilacak> yapilacakList;
    private YapilacaklarListesiViewModel viewModel;

    public YapilacakAdapter(Context mcontext, List<Yapilacak> yapilacakList, YapilacaklarListesiViewModel viewModel) {
        this.mcontext = mcontext;
        this.yapilacakList = yapilacakList;
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public YapilacaklarHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListBinding binding = DataBindingUtil.
               inflate(LayoutInflater.from(parent.getContext()), R.layout.item_list,
                       parent,false);
        return new YapilacaklarHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull YapilacaklarHolder holder, int position) {
         Yapilacak yapilacak = yapilacakList.get(position);
         ItemListBinding t = holder.binding;
         t.setYapilacakNesnesi(yapilacak);

         t.cardViewClick.setOnClickListener(view -> {

             NavDirections directions = YapilacaklarListesiDirections.
                     toyapilacaklariGuncelle(yapilacak);
             Navigation.findNavController(view).navigate(directions);
         });
          t.imageViewDeleting.setOnClickListener(view -> {
             Snackbar.make(view,"Silmek istediginizden Eminmisiniz",
                     Snackbar.LENGTH_LONG).
                     setAction("EVET", new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     viewModel.sil(yapilacak.getYapilacak_id());
                 }
             }).show();
         });
            }

    @Override
    public int getItemCount() {
        return yapilacakList.size();
    }

    public class YapilacaklarHolder extends RecyclerView.ViewHolder{
        private ItemListBinding binding;

        public YapilacaklarHolder( ItemListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
