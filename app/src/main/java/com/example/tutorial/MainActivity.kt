package com.example.tutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.content.Context
import android.widget.Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_btn)

        val btn = findViewById<Button>(R.id.btn2)
        btn.setOnClickListener() {
            Toast.makeText(this, "Clicked Inner", Toast.LENGTH_SHORT).show()
        }
    }

    public fun clickEvent(v: View) {
        val btn = findViewById<Button>(R.id.btn2)
        Toast.makeText(this, btn.background.toString(), Toast.LENGTH_SHORT).show()
    }
}