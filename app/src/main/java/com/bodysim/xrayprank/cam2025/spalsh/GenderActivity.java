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

            Intent intent = new Intent(GenderActivity.this, AgeActivity.class);
            startActivity(intent);


        });
    }


    private void setupGenderButtons() {


        binding.btnMale.setOnClickListener(v -> {
            binding.btnChange.setImageResource(R.drawable.img_male_select);
        });

        binding.btnFemale.setOnClickListener(v -> {
            binding.btnChange.setImageResource(R.drawable.img_female_selected);

        });

    }


    @Override
    public void onBackPressed() {
        myBackActivity();
    }
}