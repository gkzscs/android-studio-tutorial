package com.example.tutorial.contacts

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.tutorial.R

class RegisterActivity : AppCompatActivity() {
    lateinit var etAccount: EditText
    lateinit var etPassword: EditText
    lateinit var etConfirmPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts_register)

        etAccount = findViewById(R.id.et_account)
        etPassword = findViewById(R.id.et_password)
        etConfirmPassword = findViewById(R.id.et_confirm_password)
    }

    fun back(view: View) {
        finish()
    }

    fun register(view: View) {
        val succeed = validateAccount()
        if (!succeed) return

        // Store the account data
        storeAccount()
        finish()
    }

    /******************************************* Private Methods ***************************************/
    private fun validateAccount() : Boolean {
        val account = etAccount.text.toString()
        val password = etPassword.text.toString()
        val confirmPassword = etConfirmPassword.text.toString()

        if (account.isEmpty()) {
            FileHelper.showMessage(this, "用户名不能为空")
        } else if (password.isEmpty()) {
            FileHelper.showMessage(this, "密码不能为空")
        } else if (confirmPassword.isEmpty()) {
            FileHelper.showMessage(this, "确认密码不能为空")
        } else if (password != confirmPassword) {
            FileHelper.showMessage(this, "再次输入的密码不匹配")
        } else if (FileHelper.existsUser(account)) {
            FileHelper.showMessage(this, "该用户已存在，请直接登录！")
        } else {
            return true
        }

        return false
    }

    private fun storeAccount() {
        var usr = User()
        usr.name = etAccount.text.toString()
        usr.password = etPassword.text.toString()
        Log.i("Register Activity", "Store account: $usr")

        // Save to file
        FileHelper.addUser(usr)
        FileHelper.showMessage(this, "注册成功，请登录！")
    }
}