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

//public class ExploreBodyPartActivity extends BaseActivity {
//
//    private ActivityExploreBodyPartBinding binding;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        binding = ActivityExploreBodyPartBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        binding.toolbarLayout.headerTitle.setText("Explore Body Part");
//        binding.toolbarLayout.btnBack.setOnClickListener(v -> onBackPressed());
//
//        setClickListeners();
//    }
//
//
//    private void setClickListeners() {
//        binding.btnHair.setOnClickListener(v -> openDetails("Hair", R.drawable.hair,
//                "Hair is a protein filament that grows from follicles found in the dermis, primarily serving as a protective and thermoregulatory feature. It covers most of the human scalp, shielding the skin from UV radiation, dust, and other environmental factors. Hair also plays a role in sensory perception, as the follicles are surrounded by nerve endings that can detect movement. Additionally, hair contributes to personal identity and cultural expression through various styles and colors.\n\n" +
//                        "The structure of hair consists of three layers: the cuticle, cortex, and medulla, each contributing to its strength and flexibility. The cuticle is the outermost layer, protecting the inner layers from damage, while the cortex provides elasticity and color through melanin. Hair growth occurs in cycles—anagen (growth), catagen (transitional), and telogen (resting)—with each strand growing about half an inch per month during the anagen phase. Healthy hair maintenance involves proper nutrition, hydration, and avoiding excessive heat or chemical treatments.\n\n" +
//                        "Beyond its biological functions, hair has significant social and psychological importance across cultures and history. In many societies, hair symbolizes beauty, strength, or status, often styled to reflect personal or cultural identity. For example, long hair might be associated with femininity in some cultures, while shaved heads can signify rebellion or spiritual devotion. Hair also plays a role in nonverbal communication, as its appearance can convey emotions or social cues, making it a vital aspect of human interaction."
//        ));
//
//        binding.btnEyebrow.setOnClickListener(v -> openDetails("Eyebrow", R.drawable.eyebrow,
//                "Eyebrows are patches of hair above the eyes that serve both functional and expressive purposes in the human body. They act as a barrier, preventing sweat, water, and debris from dripping into the eyes, thus protecting vision. Eyebrows are also highly sensitive, with nerve endings that can detect potential irritants, prompting a reflexive blink. Their distinct arch or shape varies widely among individuals, often influenced by genetics and grooming habits.\n\n" +
//                        "The structure of eyebrows is similar to scalp hair, consisting of short, coarse hairs embedded in follicles, but their growth cycle is shorter, lasting only a few months. Each eyebrow contains about 250 to 1,000 hairs, which are replaced regularly as they fall out during the telogen phase. Eyebrows also contain sebaceous glands that produce oil to keep the hairs healthy and flexible. Grooming practices like plucking, waxing, or threading are common to shape eyebrows, often to align with cultural beauty standards.\n\n" +
//                        "Eyebrows play a crucial role in facial expression and communication, helping convey emotions such as surprise, anger, or curiosity. For instance, raised eyebrows often signal surprise or questioning, while furrowed brows might indicate concern or confusion. In many cultures, eyebrows are a focal point of beauty, with trends like thick, bold brows or thin, arched ones cycling through fashion history. They also aid in facial recognition, as their unique shape and position help distinguish one person from another."
//        ));
//
//        binding.btnNeck.setOnClickListener(v -> openDetails("Neck", R.drawable.neck,
//                "The neck is a vital structure that connects the head to the torso, providing support and a wide range of motion for the head. It houses critical anatomical components, including the cervical spine, which consists of seven vertebrae that allow for nodding, turning, and tilting movements. The neck also contains major blood vessels like the carotid arteries and jugular veins, which supply blood to and from the brain. Additionally, the trachea and esophagus pass through the neck, facilitating breathing and swallowing.\n\n" +
//                        "Muscles in the neck, such as the sternocleidomastoid and trapezius, play a key role in movement and posture, enabling the head to rotate up to 180 degrees. The neck is also home to the thyroid gland, which regulates metabolism, and the larynx, which is essential for voice production. Skin on the neck is thinner than on other body parts, making it more prone to aging signs like wrinkles or sagging. Proper posture and exercises like neck stretches can help maintain its strength and flexibility.\n\n" +
//                        "Culturally, the neck has been a symbol of elegance and beauty in various societies, often accentuated by jewelry like chokers or long necklaces. In some cultures, neck elongation practices, such as those of the Kayan women in Myanmar who wear brass coils, signify beauty and status. The neck’s vulnerability also makes it a focal point in self-defense training, as it houses critical structures that require protection. Its role in body language is significant, as tilting the head can signal curiosity, submission, or attentiveness."
//        ));
//
//        binding.btnEye.setOnClickListener(v -> openDetails("Eye", R.drawable.eye,
//                "Eyes are complex organs responsible for vision, allowing humans to perceive light, color, and depth in their surroundings. They function by capturing light through the cornea, which focuses it onto the retina, a layer of photoreceptor cells at the back of the eye. The retina converts light into electrical signals, which the optic nerve transmits to the brain for interpretation as visual images. The iris, the colored part of the eye, controls the amount of light entering by adjusting the pupil’s size.\n\n" +
//                        "The eye is protected by several structures, including the eyelids, eyelashes, and tear glands, which keep it moist and free of debris. The sclera, or white of the eye, provides structural support, while the lens behind the iris helps fine-tune focus for near and far objects. Humans have binocular vision, meaning both eyes work together to provide depth perception, which is crucial for activities like reading or catching a ball. Eye health can be maintained through a diet rich in vitamins A, C, and E, as well as regular check-ups to detect issues like glaucoma or cataracts.\n\n" +
//                        "Beyond their biological role, eyes are often considered a window to the soul, playing a significant role in emotional expression and communication. Eye contact is a powerful form of nonverbal communication, conveying trust, interest, or aggression depending on the context. In art and literature, eyes are frequently used as symbols of perception, wisdom, or mystery, as seen in phrases like 'the eyes never lie.' Culturally, eye color and shape often contribute to beauty standards, with practices like eyeliner or eyeshadow used to enhance their appearance."
//        ));
//
//        binding.btnHand.setOnClickListener(v -> openDetails("Hand", R.drawable.hand,
//                "Hands are remarkably versatile structures that enable humans to interact with their environment through touch, grasping, and manipulation. Each hand consists of 27 bones, including the carpals in the wrist, metacarpals in the palm, and phalanges in the fingers, all connected by joints that allow for a wide range of motion. The opposable thumb, a defining feature of human hands, enables precision grips, such as those used in writing or threading a needle. Hands are also rich in sensory nerves, making them highly sensitive to touch, temperature, and pain.\n\n" +
//                        "The muscles controlling hand movements are divided into intrinsic muscles (within the hand) and extrinsic muscles (in the forearm), working together to perform complex tasks. The skin on the hands features unique ridge patterns, or fingerprints, which are used for identification due to their individuality. Hands require dexterity and strength, which can be maintained through exercises like grip training or stretching to prevent conditions like carpal tunnel syndrome. Proper hand hygiene is also crucial, as hands are a primary vector for transmitting germs.\n\n" +
//                        "Hands hold immense cultural and symbolic significance, often representing action, connection, or creativity across societies. Gestures like waving, pointing, or clapping are universal forms of communication, while specific hand signs, such as those in sign language, convey detailed messages. In many cultures, hands are central to rituals, such as the Hindu Namaste greeting, which involves pressing the palms together to show respect. Hands also play a starring role in art, literature, and expressions, symbolizing power, care, or labor, as in the phrase 'lending a hand.'"
//        ));
//
//        binding.btnTongue.setOnClickListener(v -> openDetails("Tongue", R.drawable.tongue,
//                "The tongue is a muscular organ in the mouth that plays a critical role in tasting, swallowing, and speaking. It is covered with thousands of taste buds, which detect five basic tastes—sweet, sour, salty, bitter, and umami—allowing humans to enjoy a wide range of flavors. The tongue’s surface is lined with papillae, small bumps that house taste buds and give it a rough texture, aiding in food manipulation. Its flexibility and strength come from a complex network of intrinsic and extrinsic muscles that allow it to move in various directions.\n\n" +
//                        "Beyond taste, the tongue is essential for digestion and communication, as it helps form food into a bolus for swallowing and shapes sounds into speech. It works in tandem with the salivary glands to keep the mouth moist, aiding in the breakdown of starches through enzymes like amylase. The tongue’s health can be an indicator of overall well-being, with changes in color or texture sometimes signaling issues like dehydration or infection. Maintaining oral hygiene, including regular tongue cleaning, helps prevent bad breath and bacterial buildup.\n\n" +
//                        "The tongue also holds cultural and symbolic significance, often associated with speech and expression in phrases like 'tongue-tied' or 'speaking in tongues.' In some cultures, sticking out the tongue can be a sign of disrespect, while in others, like the Maori of New Zealand, it is part of traditional greetings or war dances to show strength. The tongue’s role in sensory exploration, such as tasting new foods, makes it a key part of culinary traditions worldwide. Its versatility and sensitivity make it a unique organ, central to both survival and social interaction."
//        ));
//
//        binding.btnLeg.setOnClickListener(v -> openDetails("Leg", R.drawable.leg,
//                "Legs are essential for human mobility, providing support, balance, and the ability to walk, run, and jump. Each leg is composed of several bones, including the femur (thigh bone), tibia, and fibula in the lower leg, connected by joints like the hip, knee, and ankle. The femur is the longest and strongest bone in the body, capable of supporting significant weight during movement. Leg muscles, such as the quadriceps, hamstrings, and calves, work together to facilitate motion and maintain stability.\n\n" +
//                        "The legs also play a role in circulation, as muscle contractions in the calves help pump blood back to the heart, a mechanism known as the 'calf pump.' Proper leg health is crucial for overall mobility, and regular exercise like walking or stretching can prevent issues like varicose veins or muscle cramps. The skin on the legs is often exposed to environmental factors, making it prone to dryness or injury, so moisturizing and protective clothing are beneficial. Additionally, the legs’ alignment and strength impact posture, with imbalances potentially leading to back or joint pain.\n\n" +
//                        "Culturally, legs are often celebrated for their strength and beauty, with long, toned legs frequently considered a standard of attractiveness in many societies. In sports and dance, legs are central to performance, as seen in activities like ballet or soccer, where agility and power are key. Legs also carry symbolic meaning, with expressions like 'standing on your own two legs' representing independence and resilience. Across history, legs have been a focus of fashion, from ancient sandals to modern high heels, highlighting their aesthetic and functional importance."
//        ));
//
//        binding.btnChest.setOnClickListener(v -> openDetails("Chest", R.drawable.chest,
//                "The chest, or thorax, is the upper part of the torso, housing vital organs like the heart, lungs, and major blood vessels, all protected by the rib cage. The rib cage consists of 12 pairs of ribs, the sternum (breastbone), and part of the spine, forming a sturdy yet flexible structure that allows for breathing. The diaphragm, a dome-shaped muscle at the base of the chest, contracts and relaxes to facilitate inhalation and exhalation. The chest also contains the thymus gland, which plays a role in immune system development during childhood.\n\n" +
//                        "Muscles in the chest, such as the pectoralis major and intercostal muscles, support movement and respiration, enabling actions like lifting the arms or expanding the lungs. The chest is a common area for fat storage, and its appearance can be influenced by exercise, particularly strength training that targets the pectoral muscles. Conditions like pneumonia or heart disease can affect the chest, making regular health check-ups important for early detection. Breathing exercises and good posture can help maintain chest health and lung capacity.\n\n" +
//                        "The chest holds deep symbolic meaning across cultures, often associated with emotions and vitality, as in the phrase 'get it off your chest,' which refers to emotional release. In many societies, a broad chest is seen as a sign of strength and masculinity, often emphasized in sports like bodybuilding. The chest is also a focal point in rituals and gestures, such as placing a hand over the heart to show sincerity or respect. In art and literature, the chest frequently symbolizes protection and life, reflecting its role as the guardian of the body’s most essential organs."
//        ));
//
//        binding.btnFoot.setOnClickListener(v -> openDetails("Foot", R.drawable.foot,
//                "Feet are complex structures that support the entire body, enabling walking, running, and balance through a network of 26 bones, 33 joints, and over 100 muscles, tendons, and ligaments. The foot’s arch, formed by the tarsal and metatarsal bones, acts as a natural shock absorber, distributing weight evenly during movement. The toes, particularly the big toe, provide leverage and stability, helping to push off the ground with each step. Feet are also highly sensitive, with thousands of nerve endings that detect pressure, pain, and temperature.\n\n" +
//                        "The skin on the soles of the feet is thicker than anywhere else on the body, designed to withstand constant pressure and friction, though it can develop calluses or blisters if overworked. Feet are prone to conditions like plantar fasciitis or athlete’s foot, often due to improper footwear or poor hygiene, so wearing supportive shoes and keeping feet clean and dry is essential. The foot’s alignment affects the entire body’s posture, with issues like flat feet or high arches potentially leading to knee or back pain. Regular stretching and foot massages can help maintain flexibility and reduce discomfort.\n\n" +
//                        "Feet hold cultural significance in many societies, often symbolizing humility or grounding, as seen in practices like foot-washing ceremonies in religious traditions. In some cultures, exposing the soles of the feet is considered disrespectful, while in others, intricate foot decorations like henna are part of celebratory rituals. Feet are also celebrated in dance and sports, where their strength and precision are showcased in activities like ballet or soccer. Expressions like 'putting your best foot forward' reflect the foot’s symbolic role in progress and effort, highlighting its foundational importance in human life."
//        ));
//
//        binding.btnFace.setOnClickListener(v -> openDetails("Face", R.drawable.face,
//                "The face is the most distinctive part of the human body, serving as the primary canvas for emotional expression and identity. It houses key sensory organs—eyes, nose, mouth, and ears—each contributing to functions like vision, smell, taste, and hearing, all coordinated by the brain. The face is covered by a complex network of muscles, unique in that they insert directly into the skin rather than bone, allowing for a wide range of expressions like smiling or frowning. The skin on the face is thinner and more sensitive than on other body parts, making it prone to environmental damage and aging.\n\n" +
//                        "Facial features are determined by genetics, with bone structure, skin tone, and hair patterns varying widely among individuals and ethnic groups. The face also plays a role in thermoregulation, as blood vessels near the surface help dissipate heat, which is why the face often flushes during exercise or embarrassment. Skincare routines, including cleansing, moisturizing, and sun protection, are essential for maintaining facial health and appearance. Additionally, facial expressions are universal to some extent, with emotions like happiness or anger recognizable across cultures, though cultural norms can influence how they are displayed.\n\n" +
//                        "The face holds immense cultural and social significance, often considered a reflection of one’s inner self, as in the phrase 'face value.' In many societies, facial beauty standards drive industries like cosmetics and plastic surgery, with features like symmetry or high cheekbones often prized. The face is also central to art and media, from ancient portraiture to modern selfies, serving as a primary means of recognition and connection. Practices like face painting or tattooing in various cultures highlight its role as a medium of expression, identity, and belonging."
//        ));
//
//        binding.btnNose.setOnClickListener(v -> openDetails("Nose", R.drawable.nose,
//                "The nose is a prominent facial feature responsible for breathing and the sense of smell, playing a crucial role in respiratory and sensory functions. Air enters through the nostrils, where it is filtered by tiny hairs, warmed, and humidified before reaching the lungs, helping to protect the respiratory system from irritants. The nasal cavity contains olfactory receptors that detect odors, sending signals to the brain to identify smells, which are closely tied to memory and emotion. The nose also contributes to the resonance of the voice, affecting speech quality.\n\n" +
//                        "Structurally, the nose is composed of bone, cartilage, and soft tissue, with its shape varying widely among individuals due to genetic and environmental factors. The septum divides the nasal cavity into two passages, and deviations in this structure can lead to breathing difficulties or snoring. The nose is prone to conditions like allergies, sinus infections, or nosebleeds, often due to dry air or irritants, so keeping the nasal passages moist and clean is important. External factors like trauma or aging can alter the nose’s shape, sometimes leading to cosmetic procedures like rhinoplasty.\n\n" +
//                        "Culturally, the nose holds symbolic and aesthetic significance, often featured in beauty standards across societies, with small, upturned noses prized in some cultures and strong, prominent noses in others. In literature and art, the nose is sometimes used to signify character traits, as in the story of Pinocchio, where a growing nose represents lying. Practices like nose piercing are common in many cultures, symbolizing beauty, status, or rites of passage. The nose’s role in smell also makes it central to experiences like cooking or perfumery, where it enhances sensory enjoyment and connection."
//        ));
//
//        binding.btnEar.setOnClickListener(v -> openDetails("Ear", R.drawable.ear,
//                "Ears are intricate organs responsible for hearing and maintaining balance, making them essential for communication and spatial orientation. The ear is divided into three parts: the outer ear, which captures sound waves; the middle ear, which amplifies them through tiny bones called ossicles; and the inner ear, which converts sound into electrical signals for the brain. The inner ear also contains the vestibular system, which uses fluid-filled canals to detect head movement and help maintain equilibrium. Ears are unique in that they never stop growing throughout a person’s life, though at a slow rate.\n\n" +
//                        "The outer ear, or pinna, is made of cartilage and skin, designed to funnel sound waves into the ear canal, where they vibrate the eardrum. Earwax, produced in the ear canal, protects the ear by trapping dust and bacteria, but excessive buildup can impair hearing, requiring careful cleaning. The ears are sensitive to loud noises, which can damage the delicate hair cells in the inner ear, leading to hearing loss, so using ear protection in noisy environments is crucial. Regular check-ups can help detect issues like infections or tinnitus, a ringing in the ears.\n\n" +
//                        "Ears hold cultural and symbolic significance, often associated with listening and understanding, as in the phrase 'lend me your ear.' In many societies, ear adornments like earrings are a form of self-expression, with styles varying from simple studs to elaborate hoops. The shape and size of ears can also play a role in beauty standards, with some cultures valuing small, symmetrical ears. Ears are also central to music and language appreciation, enabling humans to enjoy melodies or understand spoken words, making them a vital link to the auditory world."
//        ));
//
//        binding.btnMouth.setOnClickListener(v -> openDetails("Mouth", R.drawable.mouth,
//                "The mouth is a multifunctional organ at the start of the digestive tract, playing a key role in eating, speaking, and breathing. It contains the teeth, tongue, and salivary glands, which work together to break down food through chewing and the release of enzymes like amylase, preparing it for digestion. The mouth also serves as an entry point for air, acting as a secondary pathway for breathing when the nose is obstructed. Its mucosal lining is highly sensitive, detecting temperature, texture, and taste, enhancing the eating experience.\n\n" +
//                        "The mouth is essential for communication, as the lips, tongue, and palate shape sounds into speech, allowing humans to express thoughts and emotions verbally. The health of the mouth is closely tied to overall well-being, with poor oral hygiene potentially leading to cavities, gum disease, or even systemic issues like heart disease. Brushing, flossing, and regular dental check-ups are crucial for maintaining oral health and preventing bad breath. The mouth’s appearance, including the alignment of teeth and the brightness of a smile, can significantly impact self-esteem and social interactions.\n\n" +
//                        "Culturally, the mouth is a symbol of expression and sustenance, often featured in art and literature as a source of life or truth, as in the phrase 'straight from the horse’s mouth.' In many societies, a smile is a universal sign of friendliness and warmth, transcending language barriers. Practices like lip painting or piercing highlight the mouth’s aesthetic role, while traditions like communal eating emphasize its role in social bonding. The mouth’s versatility—whether in kissing, singing, or storytelling—makes it a central feature of human connection and creativity."
//        ));
//
//        binding.btnHead.setOnClickListener(v -> openDetails("Head", R.drawable.head,
//                "The head is the uppermost part of the human body, serving as the command center by housing the brain, the organ responsible for thought, memory, and coordination. The skull, made up of 22 bones, protects the brain from injury while providing structural support for the face and sensory organs. The head also contains the cranial nerves, which control functions like facial expressions, hearing, and taste, connecting the brain to the rest of the body. Blood vessels in the scalp help regulate temperature, as the head is a major site of heat loss.\n\n" +
//                        "The head’s mobility is facilitated by the neck, allowing it to turn, tilt, and nod, which is essential for scanning the environment and communicating nonverbally. The scalp, covered in hair, protects the skull and hosts a high density of nerve endings, making it sensitive to touch and pain. Conditions like migraines or concussions can affect the head, highlighting the importance of protective gear during activities like sports. Mental exercises, a balanced diet, and adequate sleep are key to supporting brain health and overall head function.\n\n" +
//                        "The head holds profound symbolic meaning, often representing intelligence, leadership, or identity, as in the phrase 'head of the family.' In many cultures, headgear like crowns or turbans signifies authority or status, while head movements, such as nodding, are universal signs of agreement or acknowledgment. The head is also a focal point in art and portraiture, capturing individuality through features like hairstyle or facial expression. Practices like head shaving in certain religious traditions symbolize humility or renewal, underscoring the head’s role as a physical and cultural centerpiece."
//        ));
//
//        binding.btnLip.setOnClickListener(v -> openDetails("Lip", R.drawable.lip,
//                "Lips are soft, flexible structures surrounding the mouth, playing a key role in speech, eating, and facial expression. They are made of muscle tissue covered by a thin layer of skin, with a rich supply of blood vessels giving them their pink or red color due to their proximity to the surface. Lips are highly sensitive, with numerous nerve endings that detect touch, temperature, and pressure, making them essential for sensory exploration, such as feeling the texture of food. They also help seal the mouth during chewing and drinking, preventing leakage.\n\n" +
//                        "The lips contribute to speech by shaping sounds, particularly consonants like 'p' and 'b,' and their movements are integral to nonverbal communication, such as smiling or pursing in displeasure. The skin on the lips lacks oil glands, making them prone to dryness and chapping, especially in harsh weather, so regular moisturizing with lip balm is recommended. Lips can also be affected by conditions like cold sores or angular cheilitis, often due to infections or nutritional deficiencies. Their appearance, including fullness and shape, can be enhanced with cosmetics like lipstick or gloss, a practice common across cultures.\n\n" +
//                        "Lips hold significant cultural and aesthetic value, often symbolizing sensuality, beauty, or emotion, as in the phrase 'sealed with a kiss.' In many societies, full lips are considered a standard of attractiveness, driving trends in makeup and cosmetic procedures like lip fillers. Kissing, a universal act involving the lips, signifies affection, greeting, or respect, varying in meaning across cultures—from a familial peck to a romantic gesture. In art and literature, lips are frequently depicted as a focal point of beauty and expression, capturing the essence of human connection and emotion."
//        ));
//
//
//        binding.btnArm.setOnClickListener(v -> openDetails("Arm", R.drawable.arm,
//                "Arms are upper limbs that extend from the shoulders to the hands, playing a crucial role in lifting, reaching, and performing daily tasks. Each arm consists of three main bones—the humerus in the upper arm, and the radius and ulna in the forearm—connected by joints like the shoulder, elbow, and wrist. The shoulder joint, a ball-and-socket structure, provides the greatest range of motion in the body, allowing the arm to rotate and swing. Arm muscles, such as the biceps and triceps, enable flexion and extension, facilitating actions like throwing or pushing.\n\n" +
//                        "The arms are also essential for balance and coordination, working in tandem with the torso and legs during activities like walking or climbing. The skin on the arms is often exposed to the sun, making it prone to UV damage, so sunscreen and protective clothing are recommended. Arm strength and flexibility can be maintained through exercises like push-ups or yoga, which also help prevent injuries like tendonitis or frozen shoulder. The arms’ sensory nerves make them sensitive to touch, allowing them to explore and interact with the environment.\n\n" +
//                        "Arms hold symbolic significance in many cultures, often representing strength, protection, or labor, as in the phrase 'strong-arm tactics.' In body language, crossed arms can signal defensiveness, while open arms suggest welcoming or surrender. In various societies, arm adornments like tattoos or bangles are common, serving as expressions of identity or status. Arms are also celebrated in sports and dance, where their power and grace are showcased in activities like swimming or ballet, highlighting their versatility and importance in human movement."
//        ));
//
//        binding.btnKnee.setOnClickListener(v -> openDetails("Knee", R.drawable.knee,
//                "The knee is the largest hinge joint in the body, connecting the thigh to the lower leg and enabling movements like walking, running, and jumping. It is formed by the femur, tibia, and patella (kneecap), supported by ligaments like the ACL and MCL, which provide stability during motion. Cartilage, including the meniscus, acts as a cushion between the bones, absorbing shock and reducing friction during movement. The knee’s design allows for flexion, extension, and slight rotation, making it essential for mobility.\n\n" +
//                        "The knee is surrounded by powerful muscles, such as the quadriceps and hamstrings, which drive its movement and help support body weight, especially during high-impact activities. However, the knee is prone to injuries like ligament tears or osteoarthritis due to its constant use and weight-bearing role, so maintaining a healthy weight and strong muscles is crucial. Low-impact exercises like swimming or cycling can help strengthen the knee without excessive strain. Proper footwear and avoiding repetitive stress also reduce the risk of knee pain or damage.\n\n" +
//                        "Culturally, the knee is often associated with submission or respect, as in the act of kneeling during prayer or proposals in many traditions. In sports, the knee’s health is critical, with injuries like ACL tears being common in activities like soccer or basketball, often requiring surgery and rehabilitation. The knee also features in expressions like 'weak in the knees,' symbolizing fear or excitement, reflecting its role in physical stability. Historically, knee-high garments like stockings or boots have been fashion staples, highlighting the knee’s aesthetic and functional significance in human life."
//        ));
//
//        binding.btnStomach.setOnClickListener(v -> openDetails("Stomach", R.drawable.stomach,
//                "The stomach is a muscular organ in the digestive system, located between the esophagus and small intestine, where it breaks down food into a semi-liquid form. It secretes gastric juices, including hydrochloric acid and enzymes like pepsin, which digest proteins and kill harmful bacteria, preparing food for nutrient absorption in the intestines. The stomach’s walls are lined with a protective mucous layer to prevent self-digestion, and its muscles contract to churn food, typically processing a meal in 2 to 4 hours. The stomach can expand to hold up to 4 liters of food and liquid, contracting when empty.\n\n" +
//                        "The stomach plays a role in hunger regulation, as hormones like ghrelin signal the brain when it’s time to eat, while feelings of fullness are communicated by stretch receptors. Stress, diet, and infections can affect stomach health, leading to issues like acid reflux, ulcers, or gastritis, so eating smaller, balanced meals and managing stress are important. The stomach’s acidic environment also acts as a barrier against pathogens, contributing to the immune system. Maintaining a healthy gut microbiome through probiotics and fiber supports overall digestive health, including stomach function.\n\n" +
//                        "The stomach holds cultural significance, often symbolizing sustenance and satisfaction, as in the phrase 'full stomach, happy heart.' In many societies, a rounded stomach is seen as a sign of prosperity, while in others, a flat stomach is a fitness ideal, driving trends in diet and exercise. The stomach is also central to culinary traditions, as it processes the flavors and nutrients of cultural foods, from spicy curries to hearty stews. In body language, rubbing the stomach can signal hunger or contentment, reflecting its role as a physical and emotional center of nourishment."
//        ));
//    }
//
//    private void openDetails(String title, int imageResId, String description) {
//
//        Intent intent = new Intent(this, BodyPartDetailActivity.class);
//        intent.putExtra("title", title);
//        intent.putExtra("image", imageResId);
//        intent.putExtra("description", description);
//        startActivity(intent);
//    }
//
//    @Override
//    public void onBackPressed() {
//        myBackActivity();
//    }
//}


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
        adapter = new BodyPartAdapter(items);
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