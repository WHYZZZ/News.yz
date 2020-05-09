package com.example.newsyz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    private val auth by lazy{ FirebaseAuth.getInstance() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        setupViews()
    }

    private fun setupViews(){
        edittextEmail.setText(PreferencesManager.getEmail(this))

        btnLogout.setOnClickListener(){
            auth.signOut()
            PreferencesManager.saveState(this,false)

            val intent= Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
