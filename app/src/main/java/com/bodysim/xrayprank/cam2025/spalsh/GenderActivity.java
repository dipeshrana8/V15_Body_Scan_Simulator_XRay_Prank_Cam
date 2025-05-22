package com.bodysim.xrayprank.cam2025.spalsh;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.bodysim.xrayprank.cam2025.R;
import com.bodysim.xrayprank.cam2025.databinding.ActivityGenderAgeBinding;

public class GenderActivity extends BaseActivity {

    private final String selectedGender = "Male";
    private ActivityGenderAgeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGenderAgeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        setupGenderButtons();

        binding.toolbarLayout.headerTitle.setText("Select Age & Gender");
        binding.toolbarLayout.btnBack.setOnClickListener(v -> myBackActivity());

        binding.btnConfirm.setOnClickListener(v -> {


            SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
            String name = sharedPreferences.getString("category", "");


            if (name.equals("btnFullBodyScan")) {

                Intent intent = new Intent(GenderActivity.this, AgeActivity.class);
                startActivity(intent);
            } else if (name.equals("btnOldBody")) {

                Intent intent = new Intent(GenderActivity.this, AgeActivity.class);
                startActivity(intent);
            } else if (name.equals("btnBodyPartName")) {

                Intent intent = new Intent(GenderActivity.this, ExploreBodyPartActivity.class);
                startActivity(intent);
            } else if (name.equals("btnBodyFilter")) {

                Intent intent = new Intent(GenderActivity.this, AgeActivity.class);
                startActivity(intent);
            } else if (name.equals("btnHumanSpecies")) {

                Intent intent = new Intent(GenderActivity.this, HumanSpeciesActivity.class);
                startActivity(intent);
            } else if (name.equals("btnOpenGallery")) {

                Intent intent = new Intent(GenderActivity.this, AddImageActivity.class);
                startActivity(intent);
            }
        });
    }


    private void setupGenderButtons() {


        binding.btnMale.setOnClickListener(v -> {
            binding.btnMale.setBackgroundResource(R.drawable.bg_country_select);
            binding.btnFemale.setBackgroundResource(R.drawable.bg_country_unselect);
            binding.btnOthers.setBackgroundResource(R.drawable.bg_country_unselect);
        });

        binding.btnFemale.setOnClickListener(v -> {
            binding.btnFemale.setBackgroundResource(R.drawable.bg_country_select);
            binding.btnMale.setBackgroundResource(R.drawable.bg_country_unselect);
            binding.btnOthers.setBackgroundResource(R.drawable.bg_country_unselect);
        });
        binding.btnOthers.setOnClickListener(v -> {
            binding.btnOthers.setBackgroundResource(R.drawable.bg_country_select);
            binding.btnMale.setBackgroundResource(R.drawable.bg_country_unselect);
            binding.btnFemale.setBackgroundResource(R.drawable.bg_country_unselect);

        });
    }


    @Override
    public void onBackPressed() {
        myBackActivity();
    }
}