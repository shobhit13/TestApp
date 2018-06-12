package com.example.sagarwal.testapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Pattern
import android.widget.RadioGroup



class MainActivity : AppCompatActivity() {
    lateinit var i: Intent
    lateinit var b: Button
    lateinit var fname: EditText
    lateinit var lname: EditText
    lateinit var email: EditText
    lateinit var btn: Button
    lateinit var s : String
    fun isValid(email: String?): Boolean {
        val emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$"

        val pat = Pattern.compile(emailRegex)
        return if (email == null) false else pat.matcher(email).matches()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindViews()
        radiog.setOnCheckedChangeListener( { group, checkedId ->
            when (checkedId) {
                R.id.m -> {
                    s = "Male"
                }
                R.id.f -> {
                    s = "Female"
                }
            }// do operations specific to this selection
            // do operations specific to this selection
            // do operations specific to this selection
        })
        btn.setOnClickListener {
            if (fname.text.toString() == "") {
                Toast.makeText(this, "Please make sure that you enter a name/last name/email and have chosen a gender. Do not forget to accept the terms/conditions.", Toast.LENGTH_SHORT).show()
            } else if (!checkbox.isChecked) {
                Toast.makeText(this, "Please make sure that you enter a name/last name/email and have chosen a gender. Do not forget to accept the terms/conditions.", Toast.LENGTH_SHORT).show()
            } else if (lname.text.toString() == "") {
                Toast.makeText(this, "Please make sure that you enter a name/last name/email and have chosen a gender. Do not forget to accept the terms/conditions.", Toast.LENGTH_SHORT).show()
            } else if (radiog.checkedRadioButtonId == -1) {
                Toast.makeText(this, "Please make sure that you enter a name/last name/email and have chosen a gender. Do not forget to accept the terms/conditions.", Toast.LENGTH_SHORT).show()
            } else {
                assignClicks()
            }
        }

    }

    fun assignClicks() {

        i = Intent(this, SecondPage::class.java)
        val firstname: String = fname.text.toString()
        val lastname: String = fname.text.toString()
        val email: String = fname.text.toString()
        i.putExtra("fname", firstname)
        i.putExtra("lname", lastname)
        i.putExtra("email", email)
        i.putExtra("gender", s)
        startActivity(i)

    }


    private fun bindViews() {
        b = findViewById(R.id.button)
        fname = findViewById(R.id.editText)
        lname = findViewById(R.id.editText3)
        email = findViewById<EditText>(R.id.editText4)
        btn = findViewById(R.id.button)
    }
}
