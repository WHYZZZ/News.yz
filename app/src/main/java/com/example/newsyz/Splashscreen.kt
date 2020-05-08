package com.example.newsyz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class Splashscreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        Handler().postDelayed({
            if (PreferencesManager.getState(this)) {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)

                finish()
            }
            else{
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)

                finish()
            }
        }, 3500)
    }
}
