package com.example.tutorial

import android.content.DialogInterface
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog


class AlertDialogActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_dialog)

        val btnActivity = findViewById<Button>(R.id.btn_activity)
        btnActivity.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("活动邀请").setIcon(R.mipmap.ic_launcher).setMessage("今晚五黑不？")
            .setPositiveButton("Ok", DialogInterface.OnClickListener() { dialog: DialogInterface, i: Int ->
                    Toast.makeText(this, "好啊，先上个铂金！", Toast.LENGTH_SHORT).show()
            })
            .setNegativeButton("Cancel", DialogInterface.OnClickListener() { dialog: DialogInterface, i: Int ->
                    Toast.makeText(this, "算了吧，你个坑货", Toast.LENGTH_SHORT).show()
            })

        builder.setView(R.layout.activity_radio_btn)
        val ad = builder.create()
        ad.show()
    }


}