package com.bodysim.xrayprank.cam2025.spalsh;

import android.os.Bundle;
import android.view.View;

import com.bodysim.xrayprank.cam2025.databinding.ActivityHumanSpeciesBinding;

public class HumanSpeciesActivity extends BaseActivity {


    ActivityHumanSpeciesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHumanSpeciesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.toolbarLayout.headerTitle.setText("Human Species");
        binding.toolbarLayout.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myBackActivity();
            }
        });
    }

    @Override
    public void onBackPressed() {
        myBackActivity();
    }
}