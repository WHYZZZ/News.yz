package com.example.newsyz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        setupViews()
    }

    private fun setupViews(){
        logInLink.setOnClickListener(){
            val intent=Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

        btnSignup.setOnClickListener(){
            val intent=Intent(this,HomeActivity::class.java)
            startActivity(intent)

            finish()
        }
    }

}
