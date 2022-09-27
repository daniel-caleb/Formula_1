package com.example.f1

import  android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var gotoRegister: TextView
    private lateinit var forgotpassword: TextView
    lateinit var etEmail: EditText
    private lateinit var etPass: EditText
    lateinit var btnLogin: Button

    //Creating FirebaseAuth object
    lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_login)

        //Binding od the variables by their 'id'
        gotoRegister = findViewById(R.id.gotoRegister)
        forgotpassword = findViewById(R.id.forgotPassword)
        etEmail = findViewById(R.id.inputEmail)
        etPass = findViewById(R.id.inputPassword)
        btnLogin = findViewById(R.id.btnLogin)

        //Initialising Firebase Auth object
        auth = FirebaseAuth.getInstance()

        btnLogin.setOnClickListener {
            login()
        }

        //Giving function to the declared variable
        gotoRegister.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
            finish()

        }
        forgotpassword.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        }
    }

    private fun login(){
        val email = etEmail.text.toString()
        val pass = etPass.text.toString()
        //Calling signIn with Email and Password i.e email, pass
        //Function using Firebase auth object
        //On successful response Display a Toast Message
        auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this){
            if (it.isSuccessful){
                Toast.makeText(this, "Successfully LoggedIn", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }else
                Toast.makeText(this, "Log In Failed!", Toast.LENGTH_SHORT).show()
        }
    }
}