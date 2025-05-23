package com.bodysim.xrayprank.cam2025.spalsh;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.bodysim.xrayprank.cam2025.R;
import com.bodysim.xrayprank.cam2025.databinding.ActivityUpperBodyBinding;

public class SelectUpperActivity extends BaseActivity {
    private ActivityUpperBodyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        toolbarHeaderText = "Select Body Type";
        super.onCreate(savedInstanceState);


        binding = ActivityUpperBodyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        showSettings = true;

        binding.toolbarLayout.headerTitle.setText("Select Body Type");
        binding.toolbarLayout.btnBack.setOnClickListener(v -> onBackPressed());

        binding.btnUpper.setOnClickListener(v -> {
            binding.imgChange.setImageResource(R.drawable.img_upper_body);
            binding.btnChange.setImageResource(R.drawable.img_upper_selected);

        });

        binding.btnLower.setOnClickListener(v -> {
            binding.imgChange.setImageResource(R.drawable.img_lower_body);
            binding.btnChange.setImageResource(R.drawable.img_lower_select);
        });

        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                String name = sharedPreferences.getString("category", "");
                if (name.equals("btnFullBodyScan")) {

                    Intent intent = new Intent(SelectUpperActivity.this, SelectFrontActivity.class);
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