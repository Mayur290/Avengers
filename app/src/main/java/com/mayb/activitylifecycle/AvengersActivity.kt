package com.mayb.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AvengersActivity : AppCompatActivity() {
var titleName :String? = "Avengers"
    lateinit var txtMessage :EditText
    lateinit var btnSend : Button
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences=getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)

        setContentView(R.layout.scrollview_example)

        titleName = sharedPreferences.getString("Title","The Avangers")
       title=titleName

        txtMessage = findViewById(R.id.txtMessage)
        btnSend = findViewById(R.id.btnSend)

        btnSend.setOnClickListener {
            var message = txtMessage.text.toString()
            val intent = Intent(this@AvengersActivity,MessageActivity::class.java)
            intent.putExtra("Message",message)
            startActivity(intent)
        }
    }



}
