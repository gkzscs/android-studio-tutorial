package com.example.tutorial

import android.R.*
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.appcompat.app.AppCompatActivity

class ListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val listView = findViewById<ListView>(R.id.lv)
        val m1 = mapOf("number" to "One", "info" to "First")
        val m2 = mapOf("number" to "Twenty", "info" to "abc")
        val m3 = mapOf("number" to "Three")
        val m4 = mapOf("info" to "Last", "number" to "444")
        val data = listOf(m1, m2, m3, m4)
        var from = arrayOf("number", "info")
        var to = intArrayOf(android.R.id.text1, android.R.id.text2)
//        var to = IntArray(2) { android.R.id.text1 }
//        var to = arrayOf(android.R.id.text1, android.R.id.text2)
        var adapter = SimpleAdapter(this, data, android.R.layout.simple_list_item_2, from, to)
//        var adapter = ArrayAdapter<String>(this, R.layout.activity_alert_dialog)
        listView.adapter = adapter
    }

}