package com.bodysim.xrayprank.cam2025.spalsh;

import static android.view.View.GONE;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bodysim.xrayprank.cam2025.R;
import com.bodysim.xrayprank.cam2025.databinding.ActivityLanguagesBinding;
import com.bodysim.xrayprank.cam2025.databinding.ItemLanguageBinding;
import com.bodysim.xrayprank.cam2025.model.LanguageModel;

import java.util.ArrayList;
import java.util.List;

public class CountryActivity extends BaseActivity {
    private final List<LanguageModel> languageList = new ArrayList<>();
    private ActivityLanguagesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        toolbarHeaderText = "Select Your Country";
        super.onCreate(savedInstanceState);


        binding = ActivityLanguagesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.toolbarLayout.headerTitle.setText("Select Your Country");
        binding.toolbarLayout.btnBack.setOnClickListener(v -> onBackPressed());
        showSettings = true;

        binding.btnNext.setImageResource(R.drawable.img_start);
        binding.toolbarLayout.btnBack.setVisibility(GONE);
        setupLanguageList();
        LanguageAdapter adapter = new LanguageAdapter(languageList);


        binding.languageRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        binding.languageRecyclerView.setAdapter(adapter);


        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(CountryActivity.this, BodyInfoActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setupLanguageList() {
        languageList.add(new LanguageModel("India", R.drawable.india, true));
        languageList.add(new LanguageModel("UK", R.drawable.uk, false));
        languageList.add(new LanguageModel("Brazil ", R.drawable.brazil, false));
        languageList.add(new LanguageModel("USA", R.drawable.usa, false));
        languageList.add(new LanguageModel("Bangladesh", R.drawable.bangladesh, false));
        languageList.add(new LanguageModel("Nepal", R.drawable.nepal, false));
        languageList.add(new LanguageModel("Canada", R.drawable.canada, false));
        languageList.add(new LanguageModel("Other", R.drawable.other, false));


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
        public LanguageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            ItemLanguageBinding binding = ItemLanguageBinding.inflate(inflater, parent, false);
            return new LanguageViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(@NonNull LanguageViewHolder holder, int position) {
            LanguageModel model = languageList.get(position);
            holder.binding.languageName.setText(model.getLanguageName());
            holder.binding.languageFlag.setImageResource(model.getFlagResId());
            holder.binding.languageName.setSelected(true);
            holder.binding.languageBg.setImageResource(R.drawable.img_info_unselect);
            if (model.isSelected()) {
                holder.binding.getRoot().setBackgroundResource(R.drawable.bg_country_select1);
                holder.binding.languageBg.setImageResource(R.drawable.img_info_select);
                holder.binding.languageName.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.white));


            } else {
                holder.binding.getRoot().setBackgroundResource(R.drawable.bg_country_unselect1);
                holder.binding.languageBg.setImageResource(R.drawable.img_info_unselect);
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
            ItemLanguageBinding binding;

            LanguageViewHolder(ItemLanguageBinding binding) {
                super(binding.getRoot());
                this.binding = binding;
            }
        }
    }
}