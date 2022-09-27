package com.example.f1


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignupActivity : AppCompatActivity() {

    //Declaring Variables
    private lateinit var  fullName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etConfPass: EditText
    private lateinit var etPass: EditText
    private lateinit var btnSignUp: Button
    private lateinit var forgotpassword: ImageView

    // create Firebase authentication object
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_signup)

        // View Bindings
        //Binding od the variables by their 'id'
        fullName = findViewById(R.id.inputFullName)
        etEmail = findViewById(R.id.SinputEmail)
        etConfPass = findViewById(R.id.SconfPassword)
        etPass = findViewById(R.id.SinputPassword)
        btnSignUp = findViewById(R.id.signup_screen)
        forgotpassword = findViewById(R.id.googleLogin)


        // Initialising auth object
        auth = Firebase.auth
        btnSignUp.setOnClickListener { this.signUpUser() }

        //Giving function to the declared variable
        forgotpassword.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            //Use finish the end of the activity
            finish()
        }
    }

    private fun signUpUser() {
        val name: String = fullName.text.toString()
        val email: String = etEmail.text.toString()
        val pass = etPass.text.toString()
        val confirmPassword = etConfPass.text.toString()

        // check pass

        if (name.isBlank()) {
            fullName.error = "Full Name is required!"
            fullName.requestFocus()
            return
        }

        if (email.isBlank() || pass.isBlank() || confirmPassword.isBlank()) {
            Toast.makeText(this, "Email and Password can't be blank", Toast.LENGTH_LONG).show()
            return
        }

        if (pass != confirmPassword) {
            Toast.makeText(this, "Password and Confirm Password do not match", Toast.LENGTH_LONG)
                .show()
            return
        }

        // If all credential are correct
        // We call createUserWithEmailAndPassword
        // using auth object and pass the
        // email and pass in it.
        auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                Toast.makeText(this,"Signed Successfully", Toast.LENGTH_LONG).show()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Signed Up Failed!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

