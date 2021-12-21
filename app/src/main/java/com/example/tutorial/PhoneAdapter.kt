package com.example.tutorial

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class PhoneAdapter(var data: List<Map<String, String>>, var context: Context) : BaseAdapter() {
//    lateinit var context: Context
//    lateinit var data: List<Map<String, String>>

    init {
        print("Phone adapter")
    }

//    constructor(ctx: Context, inData: List<Map<String, String>>) : this (ctx, inData) {
//
//    }
    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(position: Int): Any {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var myView: View =
            convertView ?: LayoutInflater.from(context).inflate(R.layout.item_phone, parent, false)

        val tvName = myView.findViewById<TextView>(R.id.tv_name)
        val tvPhone = myView.findViewById<TextView>(R.id.tv_phone)
        val btnCall = myView.findViewById<TextView>(R.id.btn_call)

        val mapData: Map<String, String> = data[position]
        val name = mapData["name"]
        val phone = mapData["phone"]

        tvName.text = name
        tvPhone.text = phone

        return myView
    }

}