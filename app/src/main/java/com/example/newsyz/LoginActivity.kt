package com.example.newsyz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private val auth by lazy { FirebaseAuth.getInstance() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        setupViews()

        edittextEmail.setText(PreferencesManager.getEmail(this))
    }

    private fun setupViews(){
        signUpLink.setOnClickListener(){
            val intent=Intent(this,SignupActivity::class.java)
            startActivity(intent)
        }


            btnLogin.setOnClickListener(){
                if(edittextPwd.text.toString()!="" && edittextEmail.text.toString()!=""){
                    auth.signInWithEmailAndPassword(edittextEmail.text.toString(), edittextPwd.text.toString())
                        .addOnCompleteListener(){task ->
                            if (task.isSuccessful){
                                val intent=Intent(this,HomeActivity::class.java)
                                startActivity(intent)
                                PreferencesManager.saveEmail(this,edittextEmail.text.toString())
                                Toast.makeText(this,PreferencesManager.getEmail(this),Toast.LENGTH_LONG).show()
                                PreferencesManager.saveState(this,true)
                                finish()
                            }
                            else{
                                Toast.makeText(this,task.exception?.message,Toast.LENGTH_LONG).show()
                            }
                        }

                    }
                else{
                    Toast.makeText(this,R.string.empty_field_err,Toast.LENGTH_LONG).show()
                }
        }

    }
}
