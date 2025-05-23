package com.bodysim.xrayprank.cam2025.spalsh;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;

import com.bodysim.xrayprank.cam2025.R;
import com.bodysim.xrayprank.cam2025.databinding.ActivityExploreBodyPartBinding;
import com.bodysim.xrayprank.cam2025.model.BodyPartAdapter;
import com.bodysim.xrayprank.cam2025.model.BodyPartModel;

import java.util.ArrayList;
import java.util.List;


public class ExploreBodyPartActivity extends BaseActivity {

    ActivityExploreBodyPartBinding binding;
    BodyPartAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExploreBodyPartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.toolbarLayout.headerTitle.setText("Explore Body Part");
        binding.toolbarLayout.btnBack.setOnClickListener(v -> onBackPressed());
        List<BodyPartModel> items = getBodyParts();
        adapter = new BodyPartAdapter(items, this);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        binding.recyclerView.setAdapter(adapter);

        binding.btnNext.setOnClickListener(v -> {
            BodyPartModel selected = adapter.getSelectedItem();
            if (selected == null) {
                Toast.makeText(this, "Please select a body part", Toast.LENGTH_SHORT).show();
            } else {

                Intent intent = new Intent(this, BodyPartDetailActivity.class);
                intent.putExtra("title", selected.getTitle());
                intent.putExtra("image", selected.getImageResId());
                intent.putExtra("description", selected.getDescription());
                startActivity(intent);


            }
        });
    }

    private List<BodyPartModel> getBodyParts() {
        List<BodyPartModel> list = new ArrayList<>();
        list.add(new BodyPartModel(R.drawable.hair, "Hair", "Hair is one of the most noticeable parts of the human body, found mainly on the head. It plays a key role in appearance, personality, and even health.\n\nIn this scan, we help you focus on the condition, volume, and overall look of your hair. Make sure your head is clearly visible in the photo for better and more accurate scan results.\n\nHair health can reveal details about nutrition, hormones, and overall care. Frequent scanning helps monitor changes and maintain healthy habits."));
        list.add(new BodyPartModel(
                R.drawable.eye,
                "Eye",
                "Eyes are among the most vital and sensitive organs of the human body, responsible for vision and perception of the surrounding world. They allow us to detect light, color, shape, and motion, making them crucial for daily functioning, communication, and safety.\n\n" +
                        "In this scan, we help you focus on the clarity, alignment, and appearance of your eyes. Ensure your eyes are open and well-lit in the photo for optimal scan accuracy. This can help in identifying signs of fatigue, strain, or irregularities such as redness or puffiness.\n\n" +
                        "Eye health can reflect your lifestyle, sleep patterns, hydration levels, and even underlying health conditions. Regular scanning promotes awareness and early detection of visual or aesthetic changes, helping you take better care of your vision and overall wellness."
        ));
        list.add(new BodyPartModel(R.drawable.eyebrow, "Eyebrow", "Eyebrows frame the eyes and enhance facial expressions. They serve both cosmetic and functional purposes, offering insight into emotion and symmetry.\n\nThis scan focuses on the thickness, curve, and position of your eyebrows. It helps ensure even grooming and detects any changes that could indicate stress or health issues.\n\nRegular eyebrow scans improve grooming consistency, shaping balance, and even confidence in social appearances."));
        list.add(new BodyPartModel(R.drawable.neck, "Neck", "The neck supports the head and contains vital structures such as the spine, arteries, and muscles. It's often overlooked in self-care.\n\nWith this scan, we assess skin tone, posture, and symmetry. A good neck scan ensures you're aware of muscle balance and signs of strain or aging.\n\nNeck posture analysis helps prevent long-term issues related to tech-neck, stiffness, and more. It's essential in full body analysis."));
        list.add(new BodyPartModel(R.drawable.hand, "Hand", "Hands are tools of expression, work, and creativity. Each scan helps analyze skin tone, joint condition, and even nail health.\n\nScanning your hands provides insight into circulation, stress levels, and any abnormalities that could be signs of overuse or conditions like arthritis.\n\nDetailed analysis of hands promotes early detection of joint concerns, encourages better ergonomics, and supports hygiene awareness."));
        list.add(new BodyPartModel(R.drawable.tongue, "Tongue", "The tongue is a key indicator of internal health. Color, texture, and coating are all clues that this scan focuses on.\n\nIn this scan, your tongue’s shape and hue are assessed. Changes may point to hydration issues, digestion, or vitamin deficiencies.\n\nMonitoring the tongue regularly gives a simple yet effective window into the body’s overall wellness and dietary balance."));
        list.add(new BodyPartModel(R.drawable.leg, "Leg", "Legs are central to movement, strength, and balance. The scan checks alignment, muscle tone, and potential signs of swelling or fatigue.\n\nDetailed analysis helps in identifying uneven muscle development, early signs of varicose veins, or circulation issues.\n\nLeg scans are helpful for athletes, people with sedentary jobs, and anyone who wants to maintain healthy movement and posture."));
        list.add(new BodyPartModel(R.drawable.chest, "Chest", "The chest houses vital organs and supports posture and respiration. This scan focuses on skin tone, symmetry, and overall condition.\n\nIt helps you monitor chest development, detect any abnormalities, and maintain confidence in your upper body appearance.\n\nChest scans are important in fitness tracking, self-care routines, and early health assessments."));
        list.add(new BodyPartModel(R.drawable.face, "Face", "The face is the most expressive and visible part of our body. Scanning it helps detect changes in skin, symmetry, and features.\n\nIt helps track facial symmetry, blemishes, skin hydration, and more. Great for skincare routines and emotional insight.\n\nRegular face scans promote self-confidence, early skin care adjustments, and a record of overall well-being."));
        list.add(new BodyPartModel(R.drawable.foot, "Foot", "Feet support your entire body and often show signs of wear, posture, or internal issues.\n\nThis scan checks for arch structure, swelling, and skin conditions. It’s especially useful for those on their feet all day.\n\nTracking foot condition helps prevent chronic issues like plantar fasciitis and supports better footwear choices."));
        list.add(new BodyPartModel(R.drawable.nose, "Nose", "The nose is central in breathing and aesthetic balance. This scan helps monitor skin, structure, and shape.\n\nIt helps track changes in the bridge or nostrils that could indicate allergy, health issues, or development over time.\n\nNose scans support grooming, skincare, and overall facial harmony."));
        list.add(new BodyPartModel(R.drawable.ear, "Ear", "Ears aid hearing, balance, and even regulate temperature. This scan checks shape, symmetry, and cleanliness.\n\nIt helps identify any irregularities, such as lumps or swelling, and supports monitoring for infections.\n\nRegular ear scans support hygiene, style decisions (e.g. earrings), and balance."));
        list.add(new BodyPartModel(R.drawable.lip, "Lip", "Lips are sensitive and expressive. Their appearance reveals hydration and health.\n\nThis scan looks at color, moisture, and cracks. It’s ideal for tracking seasonal or dietary changes.\n\nLip scans aid cosmetic care and comfort, ensuring you keep your smile fresh and healthy."));
        list.add(new BodyPartModel(R.drawable.knee, "Knee", "The knees are crucial joints that support walking and balance. This scan checks alignment, joint integrity, and swelling.\n\nIt’s particularly useful for detecting early strain in athletes or people who spend long hours standing or sitting.\n\nRegular knee scans help maintain mobility and prevent injuries."));
        list.add(new BodyPartModel(R.drawable.stomach, "Stomach", "The stomach is key for core strength and posture. Scanning it can help assess muscle tone, fat distribution, and skin.\n\nThis scan tracks changes over time and supports fitness or health goals.\n\nStomach scans are helpful in tracking digestive or physical changes and setting personal fitness milestones."));
        return list;
    }


    @Override
    public void onBackPressed() {
        myBackActivity();
    }
}