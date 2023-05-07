package com.pratyush.quizgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.view.animation.AnimationUtils
import com.pratyush.quizgame.databinding.ActivityWelcomeBinding
import java.util.logging.Handler

class WelcomeActivity : AppCompatActivity() {

    lateinit var splashBinding : ActivityWelcomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashBinding=ActivityWelcomeBinding.inflate(layoutInflater)
        val view = splashBinding.root
        setContentView(R.layout.activity_welcome)

        val alphaAnimation=AnimationUtils.loadAnimation(applicationContext,R.anim.splash_anim)
        splashBinding.textViewSplash.startAnimation(alphaAnimation)

        val handler=android.os.Handler(Looper.getMainLooper())
        handler.postDelayed(object :Runnable{
            override fun run() {
               val intent=Intent(this@WelcomeActivity,LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        },5000)
    }
}