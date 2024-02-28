package com.example.bottomsheet;// ... (imports and package statement)

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bottomsheet.MainActivity;
import com.example.bottomsheet.R;
import com.example.bottomsheet.Register1;

public class SplashScreen extends AppCompatActivity {

    // Variables
    Animation top_anim, bottom_anim;
    ImageView image;
    TextView logo, slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        // Animations
        top_anim = AnimationUtils.loadAnimation(this, R.anim.top_anim);
        bottom_anim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);

        // Initialize views
        image = findViewById(R.id.TaskWise);
        logo = findViewById(R.id.logoname);
        slogan = findViewById(R.id.TextTask);

        // Set animation to elements
        image.setAnimation(top_anim);
        logo.setAnimation(bottom_anim);
        slogan.setAnimation(bottom_anim);

        new Handler().postDelayed(() -> {
            // Call next screen
            Intent intent = new Intent(SplashScreen.this, MainActivity.class);
            // Attach all the elements you want to animate in the design
            Pair[] pairs = new Pair[2];
            pairs[0] = new Pair<>(image, "logo_image");
            pairs[1] = new Pair<>(logo, "logo_text");
            // Wrap the call in API level 21 or higher
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, pairs);
                startActivity(intent, options.toBundle());
            } else {
                startActivity(intent);
            }
        }, 3000); // Adjust the duration as needed (in milliseconds)
    }
}