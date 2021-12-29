package com.example.tutorial.contacts

import android.os.Bundle
import android.view.View
import android.widget.EditText
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
        val etAccount = findViewById<EditText>(R.id.et_account)
        val account = etAccount.text.toString()
        val listUsers = FileHelper.getUsers()

        for (usr in listUsers) {
            if (usr == null || usr.name != account) continue
            FileHelper.showMessage(this, "您的密码为：${usr.password}")
            return
        }

        FileHelper.showMessage(this, "未查询到该用户！")
    }
}