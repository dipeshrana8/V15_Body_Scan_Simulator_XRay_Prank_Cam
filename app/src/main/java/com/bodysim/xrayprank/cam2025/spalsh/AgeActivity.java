package com.bodysim.xrayprank.cam2025.spalsh;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bodysim.xrayprank.cam2025.R;
import com.bodysim.xrayprank.cam2025.databinding.ActivityAgeBinding;
import com.bodysim.xrayprank.cam2025.databinding.ItemAgeBinding;
import com.bodysim.xrayprank.cam2025.model.LanguageModel;

import java.util.ArrayList;
import java.util.List;

public class AgeActivity extends BaseActivity {
    private final List<LanguageModel> languageList = new ArrayList<>();
    private final int MIN_AGE = 15;
    private ActivityAgeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAgeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        setupLanguageList();
        LanguageAdapter adapter = new LanguageAdapter(languageList);


        binding.languageRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        binding.languageRecyclerView.setAdapter(adapter);

        binding.btnConfirm.setOnClickListener(v -> {


            SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
            String name = sharedPreferences.getString("category", "");


            if (name.equals("btnFullBodyScan")) {

                Intent intent = new Intent(AgeActivity.this, SkinToneActivity.class);
                startActivity(intent);
            } else if (name.equals("btnOldBody")) {

                Intent intent = new Intent(AgeActivity.this, SkinToneActivity.class);
                startActivity(intent);
            } else if (name.equals("btnBodyPartName")) {

                Intent intent = new Intent(AgeActivity.this, ExploreBodyPartActivity.class);
                startActivity(intent);
            } else if (name.equals("btnBodyFilter")) {

                Intent intent = new Intent(AgeActivity.this, BodyFilterActivity.class);
                startActivity(intent);
            } else if (name.equals("btnHumanSpecies")) {

                Intent intent = new Intent(AgeActivity.this, HumanSpeciesActivity.class);
                startActivity(intent);
            } else if (name.equals("btnOpenGallery")) {

                Intent intent = new Intent(AgeActivity.this, AddImageActivity.class);
                startActivity(intent);
            }


        });
    }

    private void setupLanguageList() {
        languageList.add(new LanguageModel("15-20", R.drawable.img_age_1, true));
        languageList.add(new LanguageModel("21-25", R.drawable.img_age_2, false));
        languageList.add(new LanguageModel("26-30 ", R.drawable.img_age_3, false));
        languageList.add(new LanguageModel("31-35", R.drawable.img_age_4, false));
        languageList.add(new LanguageModel("36-40", R.drawable.img_age_5, false));
        languageList.add(new LanguageModel("41-45", R.drawable.img_age_6, false));
        languageList.add(new LanguageModel("46-50", R.drawable.img_age_7, false));


    }

    @Override
    public void onBackPressed() {
        myBackActivity();
    }

    public class LanguageAdapter extends RecyclerView.Adapter<LanguageAdapter.LanguageViewHolder> {

        private final List<LanguageModel> languageList;
        private int selectedPosition = 0;

        public LanguageAdapter(List<LanguageModel> languageList) {
            this.languageList = languageList;
            if (!languageList.isEmpty()) languageList.get(0).setSelected(true);
        }

        @NonNull
        @Override
        public LanguageAdapter.LanguageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            ItemAgeBinding binding = ItemAgeBinding.inflate(inflater, parent, false);
            return new LanguageAdapter.LanguageViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(@NonNull LanguageAdapter.LanguageViewHolder holder, int position) {
            LanguageModel model = languageList.get(position);
            holder.binding.languageName.setText(model.getLanguageName());
            holder.binding.languageFlag.setImageResource(model.getFlagResId());
            holder.binding.imgSelect.setVisibility(View.VISIBLE);

            holder.binding.languageName.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.black));
            if (model.isSelected()) {
                holder.binding.getRoot().setBackgroundResource(R.drawable.bg_country_select);
                holder.binding.imgSelect.setImageResource(R.drawable.ic_selected);
                holder.binding.languageName.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.black));

            } else {
                holder.binding.getRoot().setBackgroundResource(R.drawable.bg_country_unselect);
                holder.binding.imgSelect.setImageResource(R.drawable.ic_unselected);
                holder.binding.languageName.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.black));

            }


            holder.binding.getRoot().setOnClickListener(v -> {
                if (selectedPosition != position) {
                    languageList.get(selectedPosition).setSelected(false);
                    model.setSelected(true);
                    notifyItemChanged(selectedPosition);
                    notifyItemChanged(position);
                    selectedPosition = position;
                }
            });
        }


        @Override
        public int getItemCount() {
            return languageList.size();
        }

        class LanguageViewHolder extends RecyclerView.ViewHolder {
            ItemAgeBinding binding;

            LanguageViewHolder(ItemAgeBinding binding) {
                super(binding.getRoot());
                this.binding = binding;
            }
        }
    }
}