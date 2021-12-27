package com.example.tutorial.contacts

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.tutorial.R

class ForgetPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts_forget_password)
    }

    fun back(view: View) {
        finish()
    }

    fun searchPassword(view: View) {

    }
}