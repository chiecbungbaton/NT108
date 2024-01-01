package com.example.lab3_bai1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnFadeInXml, btnFadeInCode, btnFadeOutXml, btnFadeOutCode,
            btnBlinkXml,
            btnBlinkCode, btnZoomInXml, btnZoomInCode, btnZoomOutXml,
            btnZoomOutCode, btnRotateXml,
            btnRotateCode, btnMoveXml, btnMoveCode, btnSlideUpXml, btnSlideUpCode,
            btnBounceXml,
            btnBounceCode, btnCombineXml, btnCombineCode;
    private ImageView ivUitLogo;
    private Animation.AnimationListener animationListener;
    private void initVariables() {
        animationListener = new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(getApplicationContext(), "Animation Stopped",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        };
    }
    private void findViewsByIds() {
        ivUitLogo = (ImageView) findViewById(R.id.iv_uit_logo);
        btnFadeInXml = (Button) findViewById(R.id.btn_fade_in_xml);
        btnFadeInCode = (Button) findViewById(R.id.btn_fade_in_code);
        btnFadeOutXml = (Button) findViewById(R.id.btn_fade_out_xml);
        btnFadeOutCode = (Button) findViewById(R.id.btn_fade_out_code);
        btnBlinkXml = (Button) findViewById(R.id.btn_blink_xml);
        btnBlinkCode = (Button) findViewById(R.id.btn_blink_code);
        btnZoomInXml = (Button) findViewById(R.id.btn_zoom_in_xml);
        btnZoomInCode = (Button) findViewById(R.id.btn_zoom_in_code);
        btnZoomOutXml = (Button) findViewById(R.id.btn_zoom_out_xml);
        btnZoomOutCode = (Button) findViewById(R.id.btn_zoom_out_code);
        btnRotateXml = (Button) findViewById(R.id.btn_rotate_xml);
        btnRotateCode = (Button) findViewById(R.id.btn_rotate_code);
        btnMoveXml = (Button) findViewById(R.id.btn_move_xml);
        btnMoveCode = (Button) findViewById(R.id.btn_move_code);
        btnSlideUpXml = (Button) findViewById(R.id.btn_slide_up_xml);
        btnSlideUpCode = (Button) findViewById(R.id.btn_slide_up_code);
        btnBounceXml = (Button) findViewById(R.id.btn_bounce_xml);
        btnBounceCode = (Button) findViewById(R.id.btn_bounce_code);
        btnCombineXml = (Button) findViewById(R.id.btn_combine_xml);
        btnCombineCode = (Button) findViewById(R.id.btn_combine_code);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewsByIds();
        initVariables();

        ivUitLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent NewActivity=new Intent(MainActivity.this, SecondActivity.class);
                startActivity(NewActivity);
                overridePendingTransition(R.anim.anim_fade_in, R.anim.anim_fade_out); // Set animation
            }

        });

        handleClickAnimationXml(btnFadeInXml,R.anim.anim_fade_in);
        handleClickAnimationXml(btnFadeOutXml,R.anim.anim_fade_out);
        handleClickAnimationXml(btnBlinkXml,R.anim.anim_blink);
        handleClickAnimationXml(btnZoomInXml,R.anim.anim_zoom_in);
        handleClickAnimationXml(btnZoomOutXml,R.anim.anim_zoom_out);
        handleClickAnimationXml(btnRotateXml,R.anim.anim_rotate);
        handleClickAnimationXml(btnMoveXml,R.anim.anim_move);
        handleClickAnimationXml(btnSlideUpXml,R.anim.anim_slide_up);
        handleClickAnimationXml(btnBounceXml,R.anim.anim_bounce);
        handleClickAnimationXml(btnCombineXml,R.anim.anim_combine);


        handleClickFadeInCode(btnFadeInCode);
        handleClickFadeoutCode(btnFadeOutCode);
        handleClickBlinkCode(btnBlinkCode);
        handleClickzoomInCode(btnZoomInCode);
        handleClickzoomOutCode(btnZoomOutCode);
        handleRotateCode(btnRotateCode);
        handleBounceCode(btnBounceCode);
        handleMoveCode(btnMoveCode);
        handleslideUpCode(btnSlideUpCode);
        handleCombineCode(btnCombineCode);


    }
    private void handleClickAnimationXml(Button btn, int animId)
    {
        final Animation animation = AnimationUtils.loadAnimation(MainActivity.this, animId);
        animation.setAnimationListener(animationListener);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation);
            }
        });
    }
    private Animation handleClickFadeInCode(Button btn)
    {
        AlphaAnimation fadeInAnimation = new AlphaAnimation(0, 1);
        fadeInAnimation.setDuration(1000);
        fadeInAnimation.setFillAfter(true);
        fadeInAnimation.setAnimationListener(animationListener);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(fadeInAnimation);
            }
        });
        return fadeInAnimation;
    }
    private Animation handleClickFadeoutCode(Button btn)
    {
        AlphaAnimation fadeOutAnimation = new AlphaAnimation(1, 0);
        fadeOutAnimation.setDuration(1000);
        fadeOutAnimation.setFillAfter(true);
        fadeOutAnimation.setAnimationListener(animationListener);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(fadeOutAnimation);
            }
        });
        return fadeOutAnimation;
    }
    private AlphaAnimation handleClickBlinkCode(Button btn)
    {
        AlphaAnimation blinkAnimation = new AlphaAnimation(0, 1);
        blinkAnimation.setDuration(300);
        blinkAnimation.setRepeatMode(Animation.REVERSE);
        blinkAnimation.setRepeatCount(3);
        blinkAnimation.setFillAfter(true);
        blinkAnimation.setAnimationListener(animationListener);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(blinkAnimation);
            }
        });
        return blinkAnimation;
    }
    private Animation handleClickzoomInCode(Button btn)
    {
        ScaleAnimation zoomInAnimation = new ScaleAnimation(1, 3, 1, 3, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        zoomInAnimation.setDuration(1000);
        zoomInAnimation.setFillAfter(true);
        zoomInAnimation.setAnimationListener(animationListener);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(zoomInAnimation);
            }
        });
        return zoomInAnimation;
    }
    private Animation handleClickzoomOutCode(Button btn) {
        ScaleAnimation zoomOutAnimation = new ScaleAnimation(1, 0.5f, 1, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        zoomOutAnimation.setDuration(1000);
        zoomOutAnimation.setFillAfter(true);
        zoomOutAnimation.setAnimationListener(animationListener);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(zoomOutAnimation);
            }
        });
        return zoomOutAnimation;
    }
    private Animation handleRotateCode(Button btn)
    {
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(600);
        rotateAnimation.setRepeatMode(Animation.RESTART);
        rotateAnimation.setRepeatCount(2);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setAnimationListener(animationListener);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(rotateAnimation);
            }
        });
        return rotateAnimation;
    }
    private void handleMoveCode(Button btn)
    {
        TranslateAnimation moveAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0f,
                Animation.RELATIVE_TO_PARENT, 0.75f,
                Animation.RELATIVE_TO_PARENT, 0f,
                Animation.RELATIVE_TO_PARENT, 0f
        );
        moveAnimation.setDuration(800);
        moveAnimation.setFillAfter(true);
        moveAnimation.setAnimationListener(animationListener);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(moveAnimation);
            }
        });
    }
    private Animation handleslideUpCode(Button btn)
    {
        ScaleAnimation slideAnimation = new ScaleAnimation(1,1,1,0);
        slideAnimation.setDuration(500);
        slideAnimation.setFillAfter(true);
        slideAnimation.setAnimationListener(animationListener);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(slideAnimation);
            }
        });
        return slideAnimation;
    }
    private Animation handleBounceCode(Button btn)
    {
        ScaleAnimation bounceAnimation = new ScaleAnimation(1,1,0,1);
        bounceAnimation.setDuration(500);
        bounceAnimation.setFillAfter(true);
        BounceInterpolator bounceInterpolator = new BounceInterpolator();
        bounceAnimation.setInterpolator(bounceInterpolator);
        bounceAnimation.setAnimationListener(animationListener);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(bounceAnimation);
            }
        });
        return bounceAnimation;
    }
    private Animation handleCombineCode(Button btn)
    {
        AnimationSet combineAnimation = new AnimationSet(true);

        // Scale animation
        Animation scaleAnimation = new ScaleAnimation(1f, 3f, 1f, 3f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(4000);
        combineAnimation.addAnimation(scaleAnimation);

        // Rotate animation
        Animation rotateAnimation = new RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(500);
        rotateAnimation.setRepeatCount(2);
        rotateAnimation.setRepeatMode(Animation.RESTART);
        combineAnimation.addAnimation(rotateAnimation);
        combineAnimation.setFillAfter(true);
        combineAnimation.setAnimationListener(animationListener);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(combineAnimation);
            }
        });
        return combineAnimation;
    }


}