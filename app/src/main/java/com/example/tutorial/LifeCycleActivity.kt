package com.example.tutorial

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LifeCycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("LifeCycleActivity", "创建")
        setContentView(R.layout.activity_lifecycle)

        val name = intent.getStringExtra("name")
        val hobbies = intent.getStringArrayListExtra("hobbies")
        val score = intent.getIntExtra("score", 0)
        val sex = intent.getCharExtra("sex", 'x')
        var user = intent.getSerializableExtra("user")
        Toast.makeText(this, "Welcome $user", Toast.LENGTH_SHORT).show()
//        Toast.makeText(this, "欢迎您，$name, $sex, $score", Toast.LENGTH_SHORT).show()
//        Toast.makeText(this, hobbies.toString(), Toast.LENGTH_SHORT).show()
    }

    public fun jump(view: View) {
        var intent = Intent()
        intent.setClass(this, RecyclerViewActivity::class.java)
        startActivityForResult(intent, 100)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            100 -> {
                Log.i("onActivityResult", "请求码：$requestCode, 结果码：$resultCode, 数据：$data")
            }
            else -> {
                Log.i("onActivityResult", "未知指令")
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("LifeCycleActivity","启动")
    }

    override fun onResume() {
        super.onResume()
        Log.i("LifeCycleActivity","恢复")
    }

    override fun onPause() {
        super.onPause()
        Log.i("LifeCycleActivity","暂停")
    }

    override fun onStop() {
        super.onStop()
        Log.i("LifeCycleActivity","停止")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("LifeCycleActivity","销毁")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("LifeCycleActivity", "重启")
    }
}