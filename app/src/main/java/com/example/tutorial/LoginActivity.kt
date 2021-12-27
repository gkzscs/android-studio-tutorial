package com.example.tutorial

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tutorial.model.User

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    /**
     * 注册
     */
    fun register(view: View) {
        Toast.makeText(this, "当前无法注册", Toast.LENGTH_SHORT).show()
    }

    /**
     * 登录
     */
    fun login(view: View) {
        val etAccount = findViewById<EditText>(R.id.et_account)
        val etPassword = findViewById<EditText>(R.id.et_password)
        val account = etAccount.text.toString()
        val pwd = etPassword.text.toString()

        val succeed = (account == "cs" && pwd == "123")
        if (succeed) {
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show()

            var intent = Intent()
            intent.putExtra("name", account)
            intent.putExtra("hobbies", arrayListOf<String>("Video Games", "Soccer", "Chess"))

            // Bundle
            var b = Bundle()
            var c = Bundle()
            b.putInt("score", 150)
            c.putChar("sex", '男')
            b.putBundle("bundle-c", c)
            intent.putExtras(b)

            // Serializable
            var usr = User("gyy", '女', 18)
            intent.putExtra("user", usr)

            intent.setClass(this, LifeCycleActivity::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, "用户名或密码错误！", Toast.LENGTH_SHORT).show()
        }
    }

    fun forgetPassword(view: View) {
        Toast.makeText(this, "Forget password", Toast.LENGTH_SHORT).show()
    }
}