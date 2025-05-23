package com.bodysim.xrayprank.cam2025.spalsh;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.bodysim.xrayprank.cam2025.databinding.ActivitySkinToneBinding;


public class SkinToneActivity extends BaseActivity {

    ActivitySkinToneBinding binding;
    int selectedIndex = -1;
    private final String selectedSkinTone = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySkinToneBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.toolbarLayout.headerTitle.setText("Select Skin Tone");
        binding.toolbarLayout.btnBack.setOnClickListener(v -> onBackPressed());


        binding.btnNext.setOnClickListener(v -> {
            SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
            String name = sharedPreferences.getString("category", "");


            if (name.equals("btnFullBodyScan")) {

                Intent intent = new Intent(SkinToneActivity.this, SelectUpperActivity.class);
                startActivity(intent);
            } else if (name.equals("btnOldBody")) {

                Intent intent = new Intent(SkinToneActivity.this, AddImageActivity.class);
                startActivity(intent);
            } else if (name.equals("btnBodyPartName")) {

                Intent intent = new Intent(SkinToneActivity.this, ExploreBodyPartActivity.class);
                startActivity(intent);
            } else if (name.equals("btnBodyFilter")) {

                Intent intent = new Intent(SkinToneActivity.this, BodyFilterActivity.class);
                startActivity(intent);
            } else if (name.equals("btnHumanSpecies")) {

                Intent intent = new Intent(SkinToneActivity.this, HumanSpeciesActivity.class);
                startActivity(intent);
            } else if (name.equals("btnOpenGallery")) {

                Intent intent = new Intent(SkinToneActivity.this, SkinToneDetailsActivity.class);
                startActivity(intent);
            }


        });
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("skinTone", "Fair");
    }


    @Override
    public void onBackPressed() {
        myBackActivity();
    }
}
