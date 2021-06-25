package com.example.favdish

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.favdish.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivitySplashBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Hide the status bar in window, not using full screen theme
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
//            window.insetsController?.hide(WindowInsets.Type.statusBars())
//        } else {
//            window.setFlags(
//                WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN
//            )
//        }

        // Set a animation for app name TextView, it from top to middle
        val splashAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_splash)
        binding.appNameText.animation = splashAnimation
        splashAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                // ("Not yet implemented")
            }

            override fun onAnimationEnd(animation: Animation?) {
                // One second after the animation ended, go to MainActivity
                Handler(Looper.getMainLooper()).postDelayed({
                    startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                    finish()
                }, 1000)
            }

            override fun onAnimationRepeat(animation: Animation?) {
                // ("Not yet implemented")
            }
        })
    }

}