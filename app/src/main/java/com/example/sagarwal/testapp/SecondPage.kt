package com.example.sagarwal.testapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_second_page.*

class SecondPage : AppCompatActivity() {


    lateinit var s : String
    lateinit var s2 : String
    lateinit var s3 : String
    lateinit var s4 : String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_page)
        s = intent.getStringExtra("fname")
        s2 = intent.getStringExtra("lname")
        s3 = intent.getStringExtra("email")
        s4 = intent.getStringExtra("gender")
        val t : TextView = findViewById(R.id.textView)
        textView.text = "Name: " + s
        textView2.text = "Last Name: " +  s2
        textView3.text = "Email: " + s3
        textView4.text = "Gender: " + s4

    }


}
