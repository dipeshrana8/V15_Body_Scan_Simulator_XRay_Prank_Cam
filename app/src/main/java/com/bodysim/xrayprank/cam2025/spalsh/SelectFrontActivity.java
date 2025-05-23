package com.bodysim.xrayprank.cam2025.spalsh;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.bodysim.xrayprank.cam2025.R;
import com.bodysim.xrayprank.cam2025.databinding.ActivityFrontBodyBinding;

public class SelectFrontActivity extends BaseActivity {
    private ActivityFrontBodyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        toolbarHeaderText = "Select Body Type";
        super.onCreate(savedInstanceState);


        binding = ActivityFrontBodyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        showSettings = true;

        binding.toolbarLayout.headerTitle.setText("Select Body Type");
        binding.toolbarLayout.btnBack.setOnClickListener(v -> onBackPressed());

        binding.btnFront.setOnClickListener(v -> {
            binding.imgChange.setImageResource(R.drawable.img_front_body);
            binding.btnChange.setImageResource(R.drawable.img_front_selected);

        });

        binding.btnBackBody.setOnClickListener(v -> {
            binding.imgChange.setImageResource(R.drawable.img_back_body);
            binding.btnChange.setImageResource(R.drawable.img_back_selected);
        });

        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                String name = sharedPreferences.getString("category", "");
                if (name.equals("btnFullBodyScan")) {

                    Intent intent = new Intent(SelectFrontActivity.this, AddImageActivity.class);
                    startActivity(intent);
                }
            }
        });
    }


    @Override
    public void onBackPressed() {
        myBackActivity();
    }

}