package com.bodysim.xrayprank.cam2025.spalsh;

import android.content.Intent;
import android.os.Bundle;

import com.bodysim.xrayprank.cam2025.R;
import com.bodysim.xrayprank.cam2025.databinding.ActivityExploreBinding;

public class XrayCameraActivity extends BaseActivity {

    ActivityExploreBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExploreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.txtDescription.setText("Body Xray Camera");
        binding.imgChange.setImageResource(R.drawable.img_xray_camera);


        binding.btnNext.setOnClickListener(v -> {

            Intent intent = new Intent(XrayCameraActivity.this, HomeActivity.class);
            startActivity(intent);
        });


    }

    @Override
    public void onBackPressed() {
        myBackActivity();
    }
}