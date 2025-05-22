package com.bodysim.xrayprank.cam2025.spalsh;

import android.content.Intent;
import android.os.Bundle;

import com.bodysim.xrayprank.cam2025.R;
import com.bodysim.xrayprank.cam2025.databinding.ActivityBodyPartDetailBinding;

public class BodyPartDetailActivity extends BaseActivity {

    private ActivityBodyPartDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBodyPartDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.toolbarLayout.headerTitle.setText("Explore Body Part");
        binding.toolbarLayout.btnBack.setOnClickListener(v -> onBackPressed());
        Intent intent = getIntent();

        int image = intent.getIntExtra("image", R.mipmap.ic_launcher);
        String description = intent.getStringExtra("description");
        String title = intent.getStringExtra("title");

        binding.imgBodyPart.setImageResource(image);
        binding.txtDescription.setText(description);
        binding.txtTitle.setText(title);

    }

    @Override
    public void onBackPressed() {
        myBackActivity();
    }
}