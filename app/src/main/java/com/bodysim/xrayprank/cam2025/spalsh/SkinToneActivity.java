package com.bodysim.xrayprank.cam2025.spalsh;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.bodysim.xrayprank.cam2025.R;
import com.bodysim.xrayprank.cam2025.databinding.ActivitySkinToneBinding;

import java.util.LinkedHashMap;
import java.util.Map;


public class SkinToneActivity extends BaseActivity {

    ActivitySkinToneBinding binding;
    int selectedIndex = -1;
    private String selectedSkinTone = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySkinToneBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.toolbarLayout.headerTitle.setText("Select Skin Tone");
        binding.toolbarLayout.btnBack.setOnClickListener(v -> onBackPressed());

        setupSkinToneButtons();

        binding.btnNext.setOnClickListener(v -> {
            SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
            String name = sharedPreferences.getString("category", "");

//            if (selectedIndex == -1) {
//                Toast.makeText(this, "Please select a skin tone", Toast.LENGTH_SHORT).show();
//            } else {
//                Intent intent = new Intent(SkinToneActivity.this, SelectBodyTypActivity.class);
//                intent.putExtra("selected_skin_index", selectedIndex);
//                intent.putExtra("selected_skin_name", selectedSkinTone); // optional
//                startActivity(intent);
//            }


            if (name.equals("btnFullBodyScan")) {

                Intent intent = new Intent(SkinToneActivity.this, SelectBodyTypActivity.class);
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

    private void setupSkinToneButtons() {
        Map<View, String> skinToneMap = new LinkedHashMap<>();
        skinToneMap.put(binding.btnFair, "Fair");
        skinToneMap.put(binding.btnOlive, "Olive");
        skinToneMap.put(binding.btnLight, "Light");
        skinToneMap.put(binding.btnBrown, "Brown");
        skinToneMap.put(binding.btnBlack, "Black");

        int[] index = {0};
        for (Map.Entry<View, String> entry : skinToneMap.entrySet()) {
            View button = entry.getKey();
            String skinTone = entry.getValue();
            final int currentIndex = index[0];

            button.setOnClickListener(v -> {
                selectedIndex = currentIndex;
                selectedSkinTone = skinTone;

                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("skinTone", selectedSkinTone);
                editor.apply();

                updateSelectedUI(skinToneMap, button);
            });

            index[0]++;
        }
    }

    private void updateSelectedUI(Map<View, String> skinToneMap, View selectedButton) {
        for (View button : skinToneMap.keySet()) {
            if (button == selectedButton) {
                button.setBackgroundResource(R.drawable.bg_country_select);
            } else {
                button.setBackgroundResource(R.drawable.bg_country_unselect);
            }
        }
    }

    @Override
    public void onBackPressed() {
        myBackActivity();
    }
}
