package com.bodysim.xrayprank.cam2025.spalsh;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.bodysim.xrayprank.cam2025.R;
import com.bodysim.xrayprank.cam2025.databinding.ActivitySkinToneDetailsBinding;

public class SkinToneDetailsActivity extends BaseActivity {

    ActivitySkinToneDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySkinToneDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String url = sharedPreferences.getString("uri", "");

        if (!url.isEmpty()) {
            try {
                Uri uri = Uri.parse(url);
                binding.btnAddImage.setImageURI(uri); // ✅ Accesses safely without permission
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this, "Image could not be loaded.", Toast.LENGTH_SHORT).show();
            }
        }

        String skinTone = sharedPreferences.getString("skinTone", "Fair");
        switch (skinTone) {
            case "Fair":
                binding.imgDot.setImageResource(R.drawable.img_fair_dot);
                binding.imgTxtPreview.setImageResource(R.drawable.img_fair_txt);
                break;
            case "Olive":
                binding.imgDot.setImageResource(R.drawable.img_olive_dot);
                binding.imgTxtPreview.setImageResource(R.drawable.img_olive_txt);
                break;
            case "Light":
                binding.imgDot.setImageResource(R.drawable.img_light_dot);
                binding.imgTxtPreview.setImageResource(R.drawable.img_light_txt);
                break;
            case "Brown":
                binding.imgDot.setImageResource(R.drawable.img_brown_dot);
                binding.imgTxtPreview.setImageResource(R.drawable.img_brown_txt);
                break;
            case "Black":
                binding.imgDot.setImageResource(R.drawable.img_black_dot);
                binding.imgTxtPreview.setImageResource(R.drawable.img_black_txt);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        myBackActivity();
    }
}