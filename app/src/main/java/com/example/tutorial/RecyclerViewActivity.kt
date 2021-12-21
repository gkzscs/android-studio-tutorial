package com.example.tutorial

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class RecyclerViewActivity : Activity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var homeAdapter: HomeAdapter
    var names = arrayListOf("CS", "GYY", "CY", "CG", "CY")
    var introduces = arrayListOf("A Great god!", "Beautiful angle!", "Smart boy", "Strong man", "Interesting body")
    var icons = arrayListOf(R.mipmap.owl, R.mipmap.christmas_girl, R.mipmap.cat, R.mipmap.plane1, R.mipmap.wizard)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("RecyclerViewActivity","创建")

        Log.i("RecyclerViewActivity","准备设置ContentView")
        setContentView(R.layout.activity_recycler)

        Log.i("RecyclerViewActivity","准备赋值recyclerView")
        recyclerView = findViewById(R.id.recycle)

        Log.i("RecyclerViewActivity","准备赋值layoutManager")
        recyclerView.layoutManager = LinearLayoutManager(this)

        Log.i("RecyclerViewActivity","准备赋值homeAdapter")
        homeAdapter = HomeAdapter()

        Log.i("RecyclerViewActivity","准备赋值adapter")
        recyclerView.adapter = homeAdapter

        Log.i("RecyclerViewActivity","结束OnCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.i("RecyclerViewActivity","启动")
    }

    override fun onResume() {
        super.onResume()
        Log.i("RecyclerViewActivity","恢复")
    }

    override fun onPause() {
        super.onPause()
        Log.i("RecyclerViewActivity","暂停")
    }

    override fun onStop() {
        super.onStop()
        Log.i("RecyclerViewActivity","停止")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("RecyclerViewActivity","销毁")
    }

    // Embed class
    inner class HomeAdapter : RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            Log.i("HomeAdapter", "创建ViewHolder")
            return MyViewHolder(
                LayoutInflater.from(this@RecyclerViewActivity)
                    .inflate(R.layout.item_recycler, parent, false)
            )
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            Log.i("HomeAdapter", "绑定ViewHolder")
            holder.tvName.text = names[position]
            holder.tvIntroduce.text = introduces[position]
            holder.ivProfile.setImageResource(icons[position])
        }

        override fun getItemCount(): Int {
            Log.i("HomeAdapter", "获取项目个数")
            return names.size
        }

        // Embed class
        inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var tvName: TextView = itemView.findViewById(R.id.tv_name)
            var tvIntroduce: TextView = itemView.findViewById(R.id.tv_introduce)
            var ivProfile: ImageView = itemView.findViewById(R.id.iv_profile)
        }
    }
}