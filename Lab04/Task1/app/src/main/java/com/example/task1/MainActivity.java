package com.example.task1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button btnFadeInXml, btnFadeInCode, btnFadeOutXml, btnFadeOutCode,
            btnBlinkXml, btnBlinkCode, btnZoomInXml, btnZoomInCode, btnZoomOutXml,
            btnZoomOutCode, btnRotateXml, btnRotateCode, btnMoveXml, btnMoveCode, btnSlideUpXml, btnSlideUpCode,
            btnBounceXml, btnBounceCode, btnCombineXml, btnCombineCode;
    private ImageView ivUitLogo;
    private Animation.AnimationListener animationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        findViewsByIds();
        initVariables();

        final Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_fade_in);

        animation.setAnimationListener(animationListener);

        btnFadeInXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation);
            }
        });

        // HandleClickAnimationXML
        handleClickAnimationXml(btnFadeInXml, R.anim.anim_fade_in);
        handleClickAnimationXml(btnFadeOutXml, R.anim.anim_fade_out);
        handleClickAnimationXml(btnBlinkXml, R.anim.anim_blink);
        handleClickAnimationXml(btnZoomInXml, R.anim.anim_zoom_in);
        handleClickAnimationXml(btnZoomOutXml, R.anim.anim_zoom_out);
        handleClickAnimationXml(btnRotateXml, R.anim.anim_rotate);
        handleClickAnimationXml(btnMoveXml, R.anim.anim_move);
        handleClickAnimationXml(btnSlideUpXml, R.anim.anim_slide_up);
        handleClickAnimationXml(btnBounceXml, R.anim.anim_bounce);
        handleClickAnimationXml(btnCombineXml, R.anim.anim_combine);

        handleClickAnimationCode(btnFadeInCode, initFadeInAnimation());
        handleClickAnimationCode(btnFadeOutCode, initFadeOutAnimation());
        handleClickAnimationCode(btnBlinkCode, initBlinkAnimation());
        handleClickAnimationCode(btnZoomInCode, initZoomInAnimation());
        handleClickAnimationCode(btnZoomOutCode, initZoomOutAnimation());
        handleClickAnimationCode(btnRotateCode, initRotateAnimation());
        handleClickAnimationCode(btnMoveCode, initMoveAnimation());
        handleClickAnimationCode(btnSlideUpCode, initSlideUpAnimation());
        handleClickAnimationCode(btnBounceCode, initBounceAnimation());
        handleClickAnimationCode(btnCombineCode, initCombineAnimation());

        ivUitLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, NextActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

    }

    private Animation initFadeOutAnimation() {
        AlphaAnimation animation = new AlphaAnimation(1f, 0f);
        animation.setDuration(1000);
        animation.setFillAfter(true); // Giữ trạng thái sau khi animation kết thúc
        animation.setAnimationListener(animationListener);
        return animation;
    }


    private Animation initBlinkAnimation() {
        AlphaAnimation blinkAnimation = new AlphaAnimation(0.0f, 1.0f);
        blinkAnimation.setDuration(300); // Thời gian cho mỗi lần blink
        blinkAnimation.setRepeatMode(Animation.REVERSE); // Quay lại từ từAlpha sau khi tới toAlpha
        blinkAnimation.setRepeatCount(3); // Lặp lại 3 lần

        blinkAnimation.setAnimationListener(animationListener);
        return blinkAnimation;
    }

    private Animation initFadeInAnimation() {
        AlphaAnimation animation = new AlphaAnimation(0f, 1f);
        animation.setDuration(1000);
        animation.setFillAfter(true);

        animation.setAnimationListener(animationListener);
        return animation;
    }

    private Animation initZoomInAnimation() {
        ScaleAnimation animation = new ScaleAnimation(
                1f, 3f, // fromXScale, toXScale
                1f, 3f, // fromYScale, toYScale
                Animation.RELATIVE_TO_SELF, 0.5f, // pivotX
                Animation.RELATIVE_TO_SELF, 0.5f // pivotY
        );
        animation.setDuration(1000);
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return animation;
    }

    private Animation initZoomOutAnimation() {

        ScaleAnimation animation = new ScaleAnimation(
                1f, 0.5f,
                1f, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );
        animation.setDuration(1000);  // Duration of 1 second
        animation.setFillAfter(true);  // Keep the end state after the animation
        animation.setAnimationListener(animationListener);  // Set the animation listener
        return animation;
    }

    private Animation initRotateAnimation() {
        RotateAnimation rotateAnimation = new RotateAnimation(
                0, 360, // Quay từ 0 đến 360 độ
                Animation.RELATIVE_TO_SELF, 0.5f, // Chỉ định trục quay tại chính giữa của view
                Animation.RELATIVE_TO_SELF, 0.5f);

        rotateAnimation.setDuration(600); // Thời gian quay là 600ms
        rotateAnimation.setRepeatCount(2); // Lặp lại 2 lần
        rotateAnimation.setRepeatMode(Animation.RESTART); // Lặp lại khi quay đến cuối
        rotateAnimation.setInterpolator(AnimationUtils.loadInterpolator(this, android.R.anim.cycle_interpolator));

        rotateAnimation.setAnimationListener(animationListener);
        return rotateAnimation;
    }

    private Animation initMoveAnimation() {
        TranslateAnimation animation = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.75f
        );

        animation.setDuration(800);
        animation.setInterpolator(AnimationUtils.loadInterpolator(MainActivity.this, android.R.anim.linear_interpolator));
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);

        return animation;
    }

    private Animation initSlideUpAnimation() {
        TranslateAnimation animation = new TranslateAnimation(0f, 0f, 200f, 0f);
        animation.setDuration(1000);
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return animation;
    }

    private Animation initBounceAnimation() {
        ScaleAnimation animation = new ScaleAnimation(
                1.0f, 1.0f,
                0.0f, 1.0f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );
        animation.setDuration(500);
        animation.setFillAfter(true);
        animation.setInterpolator(new android.view.animation.BounceInterpolator());

        animation.setAnimationListener(animationListener);
        return animation;
    }

    private Animation initCombineAnimation() {
        // Tạo hiệu ứng Scale Animation
        ScaleAnimation scaleAnimation = new ScaleAnimation(
                1f, 3f, // Từ 1 lần kích thước gốc đến 3 lần
                1f, 3f, // Từ 1 lần kích thước gốc đến 3 lần
                Animation.RELATIVE_TO_SELF, 0.5f, // Tâm X là 50%
                Animation.RELATIVE_TO_SELF, 0.5f // Tâm Y là 50%
        );
        scaleAnimation.setDuration(4000); // Thời gian thực hiện
        scaleAnimation.setFillAfter(true); // Giữ lại trạng thái sau khi kết thúc



        RotateAnimation rotateAnimation = new RotateAnimation(
                0, 360, // Xoay từ 0 đến 360 độ
                Animation.RELATIVE_TO_SELF, 0.5f, // Tâm X là 50%
                Animation.RELATIVE_TO_SELF, 0.5f // Tâm Y là 50%
        );
        rotateAnimation.setDuration(500); // Thời gian thực hiện
        rotateAnimation.setRepeatCount(2); // Lặp lại 2 lần
        rotateAnimation.setRepeatMode(Animation.RESTART); // Bắt đầu lại khi lặp lại

        // Kết hợp hai hiệu ứng trong AnimationSet
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setInterpolator(this, android.R.interpolator.linear);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(rotateAnimation);

        animationSet.setAnimationListener(animationListener);

        return animationSet;
    }


    private void handleClickAnimationXml(Button btn, int animId)
    {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, animId);
                animation.setAnimationListener(animationListener);
                ivUitLogo.startAnimation(animation);
            }
        });
    }

    private void handleClickAnimationCode(Button btn, final Animation animation) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation);
            }
        });
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

}