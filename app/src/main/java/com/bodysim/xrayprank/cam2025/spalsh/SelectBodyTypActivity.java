package com.bodysim.xrayprank.cam2025.spalsh;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.bodysim.xrayprank.cam2025.R;
import com.bodysim.xrayprank.cam2025.databinding.ActivityLowerBodyBinding;

public class SelectBodyTypActivity extends BaseActivity {
    private ActivityLowerBodyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        toolbarHeaderText = "Select Body Type";
        super.onCreate(savedInstanceState);


        binding = ActivityLowerBodyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        showSettings = true;

        binding.toolbarLayout.headerTitle.setText("Select Body Type");
        binding.toolbarLayout.btnBack.setOnClickListener(v -> onBackPressed());

        binding.frameUpper.setOnClickListener(v -> {
            binding.frameUpper.setBackgroundResource(R.drawable.bg_country_select);
            binding.frameLower.setBackgroundResource(R.drawable.bg_country_unselect);
            binding.imgUpper.setImageResource(R.drawable.ic_selected);
            binding.imgLower.setImageResource(R.drawable.ic_unselected);

            binding.imgChange.setImageResource(R.drawable.img_upper_body);
            binding.imgHeader.setImageResource(R.drawable.img_header_upper);
        });

        binding.frameLower.setOnClickListener(v -> {
            binding.frameLower.setBackgroundResource(R.drawable.bg_country_select);
            binding.frameUpper.setBackgroundResource(R.drawable.bg_country_unselect);
            binding.imgLower.setImageResource(R.drawable.ic_selected);
            binding.imgUpper.setImageResource(R.drawable.ic_unselected);
            binding.imgChange.setImageResource(R.drawable.img_lower_body);
            binding.imgHeader.setImageResource(R.drawable.img_header_lower);
        });

        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                String name = sharedPreferences.getString("category", "");
                if (name.equals("btnFullBodyScan")) {

                    Intent intent = new Intent(SelectBodyTypActivity.this, AddImageActivity.class);
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