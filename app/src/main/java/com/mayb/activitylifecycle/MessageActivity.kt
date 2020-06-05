package com.mayb.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MessageActivity : AppCompatActivity() {

    var msg:String? = "Message"
    lateinit var msgText:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        if(intent!=null){
            msg = intent.getStringExtra("Message")
        }
        msgText = findViewById(R.id.msgHere)
        msgText.text = msg
    }
}
