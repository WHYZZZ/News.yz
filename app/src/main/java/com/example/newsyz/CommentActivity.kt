package com.example.newsyz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_comment.*

class CommentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment)

        setupViews()
    }

    private fun setupViews(){

        comments_recycler_view.layoutManager=LinearLayoutManager(this)

        btnSubmit.setOnClickListener() {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()

            if(comment_content.text.toString()!=""){
                Toast.makeText(this,R.string.comment_success,Toast.LENGTH_LONG).show()
            }
        }
    }
}
