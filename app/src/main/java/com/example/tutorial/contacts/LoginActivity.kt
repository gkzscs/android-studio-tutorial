package com.example.tutorial.contacts

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.tutorial.R
import java.io.File
import java.util.jar.Manifest

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts_login)

        Log.i("LoginActivity", "创建")
        handlePermission()

        Log.i("LoginActivity", filesDir.absolutePath)
        FileHelper.setFilePath(filesDir.absolutePath)

        val etAccouont = findViewById<EditText>(R.id.et_account)
        etAccouont.onFocusChangeListener = View.OnFocusChangeListener() { _: View, b: Boolean ->
            if (b) return@OnFocusChangeListener

            // Get last user and compare information
            val lastUsr = FileHelper.lastUser() ?: return@OnFocusChangeListener
            if (lastUsr.name != etAccouont.text.toString()) return@OnFocusChangeListener

            val etPassword = findViewById<EditText>(R.id.et_password)
            etPassword.setText(lastUsr.password)
        }
    }

    fun register(view: View) {
        jumpPage(RegisterActivity::class.java)
    }

    fun login(view: View) {
        validateAccount()
    }

    fun rememberPassword(view: View) {
        // Do nothing
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

    private fun handlePermission() {
        val permissions = arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
        for (permission in permissions) {
            val selfPermission = ActivityCompat.checkSelfPermission(this, permission)
            if (selfPermission == PackageManager.PERMISSION_GRANTED) {
                Log.i("LoginActivity", "Already get permission")
                continue
            }
        }

        myRequestPermission()
    }

    private fun myRequestPermission() {
        val permissions = arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
        Log.i("LoginActivity", "permissions:${permissions.first()}")
        ActivityCompat.requestPermissions(this, permissions, 1)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        Log.i("LoginActivity", "grant results:${grantResults.size}, ${permissions.first()}")
        var i = 0
        for (result in grantResults) {
            if (result == PackageManager.PERMISSION_GRANTED) {
                Log.i("LoginActivity", "Got permission: ${permissions[i++]}")
            } else {
                Log.i("LoginActivity", "Denied permission: ${permissions[i++]}")
            }
        }
    }

    /**
     * 验证用户信息
     */
    private fun validateAccount() : Boolean {
        val etAccount = findViewById<EditText>(R.id.et_account)
        val etPassword = findViewById<EditText>(R.id.et_password)
        val account = etAccount.text.toString()
        val password = etPassword.text.toString()
        val listUsers = FileHelper.getUsers()

        for (usr in listUsers) {
            if (usr == null) continue
            if (usr.name == account && usr.password == password) {
                FileHelper.showMessage(this, "${usr.name}，登录成功！")
                updateLastUser(account, password)
                return true
            }
        }

        FileHelper.showMessage(this, "用户名或密码错误！")
        return false
    }

    /**
     * 更新当前登录的用户信息
     */
    private fun updateLastUser(name: String, pwd: String) {
        val chkRememberPwd = findViewById<CheckBox>(R.id.chk_remember_password)
        val flag = chkRememberPwd.isChecked
        var usr = User()

        if (flag) {
            usr.name = name
            usr.password = pwd
        }

        FileHelper.setLastUser(usr)
    }
}