package com.bodysim.xrayprank.cam2025.spalsh;

import static android.view.View.GONE;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.bodysim.xrayprank.cam2025.R;
import com.bodysim.xrayprank.cam2025.databinding.ActivityBodyFilterBinding;

import java.util.LinkedHashMap;
import java.util.Map;

public class BodyFilterActivity extends BaseActivity {
    private static final int PICK_IMAGE_REQUEST = 1;
    ActivityBodyFilterBinding binding;
    int selectedIndex = -1;
    private boolean isImageSelected = false;
    private boolean isDoneState = false; // Track state
    private String selectedSkinTone = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBodyFilterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.toolbarLayout.headerTitle.setText("Select Skin Tone");
        binding.toolbarLayout.btnBack.setOnClickListener(v -> onBackPressed());

        setupSkinToneButtons();

        binding.btnNext.setOnClickListener(v -> {
            if (selectedIndex == -1) {
                Toast.makeText(this, "Please select a skin tone", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(BodyFilterActivity.this, SelectBodyTypActivity.class);
                intent.putExtra("selected_skin_index", selectedIndex);
                intent.putExtra("selected_skin_name", selectedSkinTone);
                startActivity(intent);
            }
        });


        binding.btnNext.setOnClickListener(v -> {

            if (!isImageSelected) {
                openGallery();
            } else if (!isDoneState) {

                isDoneState = true;
            } else {

                Intent intent = new Intent(BodyFilterActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri imageUri = data.getData();
            binding.imgPreview.setImageURI(imageUri);
            binding.btnNext.setVisibility(GONE);
            binding.toolbarLayout.headerTitle.setText("Image Preview");
            isDoneState = true;
            isImageSelected = true;
        }
    }

    private void setupSkinToneButtons() {
        Map<View, String> skinToneMap = new LinkedHashMap<>();
        Map<View, Integer> imageMap = new LinkedHashMap<>();

        skinToneMap.put(binding.btnFilter0, "Fair");
        skinToneMap.put(binding.btnFilter1, "Olive");
        skinToneMap.put(binding.btnFilter2, "Light");
        skinToneMap.put(binding.btnFilter3, "Brown");

        imageMap.put(binding.btnFilter0, R.drawable.img_body_0);
        imageMap.put(binding.btnFilter1, R.drawable.img_body_1);
        imageMap.put(binding.btnFilter2, R.drawable.img_body_3);
        imageMap.put(binding.btnFilter3, R.drawable.img_body_3);

        int[] index = {0};
        for (Map.Entry<View, String> entry : skinToneMap.entrySet()) {
            View button = entry.getKey();
            String skinTone = entry.getValue();
            final int currentIndex = index[0];

            button.setOnClickListener(v -> {
                selectedIndex = currentIndex;
                selectedSkinTone = skinTone;
                updateSelectedUI(skinToneMap, button);

                // Set preview image
                binding.imgPreview.setImageResource(imageMap.get(button));
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