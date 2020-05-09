package com.example.newsyz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private val auth by lazy { FirebaseAuth.getInstance() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        label_username.setText(PreferencesManager.getEmail(this))
        setupViews()
    }

    var liked=false
    private fun setupViews(){
        buttonLike.setOnClickListener(){
            if(liked){
                liked=false
                buttonLike.setBackgroundResource(R.drawable.button_not_liked)
            }
            else{
                liked=true
                buttonLike.setBackgroundResource(R.drawable.button_like)

                Toast.makeText(this,R.string.like_clicked,Toast.LENGTH_LONG).show()
            }
        }

        buttonComment.setOnClickListener(){
            val intent = Intent(this,CommentActivity::class.java)
            startActivity(intent)
        }

        label_username.setOnClickListener(){
            val intent=Intent(this,ProfileActivity::class.java)
            startActivity(intent)
            finish()


        }
    }
}
