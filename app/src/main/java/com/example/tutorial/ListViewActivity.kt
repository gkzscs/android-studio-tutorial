package com.example.tutorial

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.appcompat.app.AppCompatActivity

class ListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

//        testSimpleAdapter()
//        testArrayAdapter()
        testPhoneAdapter()
    }

    private fun testSimpleAdapter()
    {
        val listView = findViewById<ListView>(R.id.lv)
        val m1 = mapOf("number" to "One", "info" to "First")
        val m2 = mapOf("number" to "Twenty", "info" to "abc")
        val m3 = mapOf("number" to "Three")
        val m4 = mapOf("info" to "Last", "number" to "444")
        val data = listOf(m1, m2, m3, m4)
        val from = arrayOf("number", "info")
        val to = intArrayOf(android.R.id.text1, android.R.id.text2)
        var adapter = SimpleAdapter(this, data, android.R.layout.simple_list_item_2, from, to)
        listView.adapter = adapter
    }

    private fun testArrayAdapter()
    {
        val listView = findViewById<ListView>(R.id.lv)
        val data = arrayOf("abd", 456, 789)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, data)
        listView.adapter = adapter
    }

    private fun testPhoneAdapter()
    {
        val listView = findViewById<ListView>(R.id.lv)
        val m1 = mapOf("name" to "One", "phone" to "7777777")
        val m2 = mapOf("name" to "Twenty", "phone" to "6666666")
        val m3 = mapOf("name" to "Three", "phone" to "7654321")
        val m4 = mapOf("phone" to "Last", "name" to "444")
        val data = listOf(m1, m2, m3, m4)
        val adapter = PhoneAdapter(data, this)
        listView.adapter = adapter
    }
}