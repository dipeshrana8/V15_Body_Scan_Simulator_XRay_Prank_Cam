package com.bodysim.xrayprank.cam2025.spalsh;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.bodysim.xrayprank.cam2025.R;
import com.bodysim.xrayprank.cam2025.databinding.ActivityAddImageBinding;

public class AddImageActivity extends BaseActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private ActivityAddImageBinding binding;
    private boolean isImageSelected = false;
    private boolean isDoneState = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddImageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String name = sharedPreferences.getString("category", "");

        if (name.equals("Body Scanner")) {
            binding.toolbarLayout.headerTitle.setText("Add Image");
            binding.imgTool.setImageResource(R.drawable.img_add_image_tool);
        } else if (name.equals("btnOldBody")) {
            binding.toolbarLayout.headerTitle.setText("Your Old Body");
            binding.imgTool.setImageResource(R.drawable.img_old_tool);
        } else if (name.equals("btnOpenGallery")) {
            binding.toolbarLayout.headerTitle.setText("Body Scanner");
            binding.imgTool.setImageResource(R.drawable.img_gallary_tool);
        } else if (name.equals("btnBodyFilter")) {
            binding.toolbarLayout.headerTitle.setText("Body Filter");
            binding.imgTool.setImageResource(R.drawable.img_body_filter_tool);
        }

        binding.btnNextToGo.setOnClickListener(v -> {
            if (name.equals("btnOpenGallery")) {
                startActivity(new Intent(this, SkinToneActivity.class));
                finish();
            } else if (name.equals("btnOldBody")) {
                startActivity(new Intent(this, SkinToneDetailsActivity.class));
                finish();
            }
        });

        binding.toolbarLayout.btnBack.setOnClickListener(v -> onBackPressed());

        binding.btnNext.setOnClickListener(v -> {
            if (!isImageSelected) {
                openGallery();
            } else if (!isDoneState) {
                isDoneState = true;
            } else {
                startActivity(new Intent(this, HomeActivity.class));
                finish();
            }
        });
    }

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT); // ✅ No permission required
        intent.setType("image/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri imageUri = data.getData();

            // ✅ Persist URI permission
            final int takeFlags = data.getFlags() & Intent.FLAG_GRANT_READ_URI_PERMISSION;
            getContentResolver().takePersistableUriPermission(imageUri, takeFlags);

            // Preview image
            binding.btnAddImage.setImageURI(imageUri);
            binding.imgTxtPreview.setImageResource(R.drawable.img_add_image_preview_txt);
            binding.toolbarLayout.headerTitle.setText("Image Preview");

            // Save URI to SharedPreferences
            SharedPreferences.Editor editor = getSharedPreferences("MyPrefs", MODE_PRIVATE).edit();
            editor.putString("uri", imageUri.toString());
            editor.apply();

            // Update visibility
            String name = getSharedPreferences("MyPrefs", MODE_PRIVATE).getString("category", "");
            if (name.equals("btnOpenGallery") || name.equals("btnOldBody")) {
                binding.btnNextToGo.setVisibility(View.VISIBLE);
                binding.btnNext.setVisibility(View.GONE);
            }
            if (name.equals("btnFullBodyScan")) {
                binding.btnNext.setVisibility(View.GONE);
            }


            isDoneState = true;
            isImageSelected = true;
        }
    }

    @Override
    public void onBackPressed() {
        myBackActivity();
    }
}