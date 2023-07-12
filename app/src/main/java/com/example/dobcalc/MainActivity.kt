package com.example.dobcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker: Button = findViewById(R.id.select_date_btn)

        btnDatePicker.setOnClickListener{
            Toast.makeText(this, "Button Pressed", Toast.LENGTH_SHORT).show()
        }
    }
}