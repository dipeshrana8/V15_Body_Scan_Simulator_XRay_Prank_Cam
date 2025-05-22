package com.bodysim.xrayprank.cam2025.spalsh;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bodysim.xrayprank.cam2025.R;
import com.bodysim.xrayprank.cam2025.databinding.ActivityAgeBinding;

public class AgeActivity extends BaseActivity {

    private final int MIN_AGE = 15;
    private ActivityAgeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAgeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int initialProgress = 5;
        binding.seekBarAge.setProgress(initialProgress);
        binding.tvAge.setText(String.valueOf(MIN_AGE + initialProgress));


        SharedPreferences sharedPreferences1 = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String name1 = sharedPreferences1.getString("category", "");


        if (name1.equals("btnOldBody")) {
            binding.imgOld.setImageResource(R.drawable.img_select_age_old);
        } else {
            binding.imgOld.setImageResource(R.drawable.img_select_age);
        }

        // Listener
        binding.seekBarAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int age = MIN_AGE + progress;
                binding.tvAge.setText(String.valueOf(age));
                moveTextAboveThumb(seekBar, binding.tvAge);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        binding.seekBarAge.post(() -> moveTextAboveThumb(binding.seekBarAge, binding.tvAge));

        binding.btnConfirm.setOnClickListener(v -> {


            SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
            String name = sharedPreferences.getString("category", "");


            if (name.equals("btnFullBodyScan")) {

                Intent intent = new Intent(AgeActivity.this, SkinToneActivity.class);
                startActivity(intent);
            } else if (name.equals("btnOldBody")) {

                Intent intent = new Intent(AgeActivity.this, SkinToneActivity.class);
                startActivity(intent);
            } else if (name.equals("btnBodyPartName")) {

                Intent intent = new Intent(AgeActivity.this, ExploreBodyPartActivity.class);
                startActivity(intent);
            } else if (name.equals("btnBodyFilter")) {

                Intent intent = new Intent(AgeActivity.this, SkinToneActivity.class);
                startActivity(intent);
            } else if (name.equals("btnHumanSpecies")) {

                Intent intent = new Intent(AgeActivity.this, HumanSpeciesActivity.class);
                startActivity(intent);
            }


        });
    }

    private void moveTextAboveThumb(SeekBar seekBar, TextView textView) {
        int progress = seekBar.getProgress();
        int max = seekBar.getMax();
        int width = seekBar.getWidth() - seekBar.getPaddingLeft() - seekBar.getPaddingRight();

        float thumbPos = ((float) progress / max) * width;
        float x = seekBar.getX() + seekBar.getPaddingLeft() + thumbPos - textView.getWidth() / 2f;
        textView.setX(x);
    }


    @Override
    public void onBackPressed() {
        myBackActivity();
    }
}