package com.bodysim.xrayprank.cam2025.spalsh;

import static android.view.View.GONE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.bodysim.xrayprank.cam2025.databinding.ActivityHomeBinding;

public class HomeActivity extends BaseActivity {

    ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        toolbarHeaderText = "Full Xray Vision-Body scanner";
        showBackButton = false;

        super.onCreate(savedInstanceState);


        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.toolbarLayout.headerTitle.setText("Full Xray Vision-Body scanner");
        binding.toolbarLayout.btnBack.setVisibility(GONE);

        binding.toolbarLayout.headerTitle.setSelected(true);
        binding.btnFullBodyScan.setOnClickListener(v -> {

            SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("category", "btnFullBodyScan");
            editor.apply();


            Intent intent = new Intent(HomeActivity.this, GenderActivity.class);
            startActivity(intent);
        });

        binding.btnHumanSpecies.setOnClickListener(v -> {

            SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("category", "btnHumanSpecies");
            editor.apply();

            Intent intent = new Intent(HomeActivity.this, GenderActivity.class);
            startActivity(intent);
        });

        binding.btnOldBody.setOnClickListener(v -> {

            SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("category", "btnOldBody");
            editor.apply();

            Intent intent = new Intent(HomeActivity.this, GenderActivity.class);
            startActivity(intent);
        });

        binding.btnOpenGallery.setOnClickListener(v -> {

            SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("category", "btnOpenGallery");
            editor.apply();

            Intent intent = new Intent(HomeActivity.this, GenderActivity.class);
            startActivity(intent);
        });


        binding.btnBodyPartName.setOnClickListener(v -> {

            SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("category", "btnBodyPartName");
            editor.apply();

            Intent intent = new Intent(HomeActivity.this, GenderActivity.class);
            startActivity(intent);
        });

        binding.btnBodyFilter.setOnClickListener(v -> {

            SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("category", "btnBodyFilter");
            editor.apply();

            Intent intent = new Intent(HomeActivity.this, GenderActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(HomeActivity.this, A7_ExitActivity.class);
        startActivity(intent);


    }


}