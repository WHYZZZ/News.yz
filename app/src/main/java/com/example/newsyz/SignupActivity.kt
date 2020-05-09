package com.example.newsyz

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity() {

    private val auth by lazy { FirebaseAuth.getInstance() }

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

        btnSignup.setOnClickListener() {
            if (edittextPwd.text.toString() != "" && edittextId.text.toString() != "") {
                if (edittextPwd.text.toString() == edittextPwdConf.text.toString()) {
                    auth.createUserWithEmailAndPassword(
                        edittextId.text.toString(),
                        edittextPwd.text.toString()
                    )
                        .addOnCompleteListener() { task ->
                            if (task.isSuccessful) {
                                Toast.makeText(
                                    this,
                                    R.string.create_user_success,
                                    Toast.LENGTH_LONG
                                )
                                    .show()

                                auth.signInWithEmailAndPassword(edittextId.text.toString(), edittextPwd.text.toString())
                                PreferencesManager.saveEmail(this, edittextId.text.toString())
                                PreferencesManager.saveState(this, true)

                                val intent = Intent(this, HomeActivity::class.java)
                                startActivity(intent)
                                finish()

                                return@addOnCompleteListener
                            } else {
                                Toast.makeText(this, task.exception?.message, Toast.LENGTH_LONG)
                                    .show()
                            }
                        }
                } else {
                    Toast.makeText(this, R.string.pwd_mismatch, Toast.LENGTH_LONG).show()
                }
            }
            else{
                Toast.makeText(this,R.string.empty_field_err,Toast.LENGTH_LONG).show()
            }
        }

    }

}
