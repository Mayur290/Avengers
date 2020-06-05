package com.mayb.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity(){


    lateinit var etMobileNumber : EditText
    lateinit var etPassword :EditText
    lateinit var btnLogin : Button
    lateinit var txtForgotPassword: TextView
    lateinit var txtRegister:TextView
    lateinit var sharedPreferences: SharedPreferences

    val validMobileNumber = "1234567890"
    val validPassword = arrayOf("tony","steve","bruce","thanos")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn",false)
        if(isLoggedIn){
            val intent = Intent(this@LoginActivity, AvengersActivity::class.java)
            startActivity(intent)
            finish()
        }


        title = "Log In"

        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        txtForgotPassword = findViewById(R.id.btnLogin)
        txtRegister = findViewById(R.id.txtRegister)

        btnLogin.setOnClickListener {
            val mobileNumber = etMobileNumber.text.toString()
            val password = etPassword.text.toString()
            var nameOfAvanger = "Avanger"
            val intent = Intent(this@LoginActivity, AvengersActivity::class.java)

            if (mobileNumber == validMobileNumber) {
                when (password) {
                    validPassword[0] -> {

                        nameOfAvanger = "Iron man"
                        savePreferences(nameOfAvanger)
                        startActivity(intent)
                    }

                    validPassword[1] -> {

                        nameOfAvanger = "Captain America"
                        savePreferences(nameOfAvanger)
                        startActivity(intent)
                    }
                    validPassword[2] -> {

                        nameOfAvanger = "The hulk"
                        savePreferences(nameOfAvanger)
                        startActivity(intent)
                    }
                    validPassword[3] -> {

                        nameOfAvanger = "The Avangers"
                        savePreferences(nameOfAvanger)
                        startActivity(intent)
                    }
                    else -> {
                        Toast.makeText(
                            this@LoginActivity,
                            "Incorrect Credentials",
                            Toast.LENGTH_LONG
                        ).show()

                    }
                }


            }
        }
    }
    override fun onPause() {
        super.onPause()
        finish()
    }
    fun savePreferences(title:String){
        sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()
        sharedPreferences.edit().putString("Title",title).apply()
    }

}
