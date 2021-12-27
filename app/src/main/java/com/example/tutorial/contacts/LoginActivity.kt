package com.example.tutorial.contacts

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.tutorial.R

class LoginActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts_login)

    }

    fun register(view: View) {
        jumpPage(RegisterActivity::class.java)
    }

    fun login(view: View) {
        jumpPage(LoginActivity::class.java)
    }

    fun rememberPassword(view: View) {

    }

    fun forgetPassword(view: View) {
        jumpPage(ForgetPasswordActivity::class.java)
    }

    /****************************** Helper Methods ***********************************/
    private fun jumpPage(cls: Class<*>) {
        val intent = Intent()
        intent.setClass(this, cls)
        startActivity(intent)
    }
}