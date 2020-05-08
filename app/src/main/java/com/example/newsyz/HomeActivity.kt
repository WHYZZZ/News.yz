package com.example.newsyz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

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
            }
        }

        buttonComment.setOnClickListener(){
            val intent = Intent(this,CommentActivity::class.java)
            startActivity(intent)
        }
    }
}
