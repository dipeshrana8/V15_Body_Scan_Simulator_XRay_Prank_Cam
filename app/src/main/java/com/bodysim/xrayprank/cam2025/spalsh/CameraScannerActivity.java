package com.bodysim.xrayprank.cam2025.spalsh;

import android.content.Intent;
import android.os.Bundle;

import com.bodysim.xrayprank.cam2025.R;
import com.bodysim.xrayprank.cam2025.databinding.ActivityExploreBinding;

public class CameraScannerActivity extends BaseActivity {

    ActivityExploreBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExploreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.imgTool.setImageResource(R.drawable.img_bodscan_d_tool);
        binding.imgChange.setImageResource(R.drawable.img_camera_scanner);
        binding.btnNext.setImageResource(R.drawable.img_keep_going);
        binding.btnNext.setOnClickListener(v -> {

            Intent intent = new Intent(CameraScannerActivity.this, XrayCameraActivity.class);
            startActivity(intent);
        });


    }

    @Override
    public void onBackPressed() {
        myBackActivity();
    }
}