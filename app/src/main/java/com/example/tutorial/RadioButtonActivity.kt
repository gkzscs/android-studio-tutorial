package com.example.tutorial

import android.content.Context
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RadioButtonActivity : AppCompatActivity(), RadioGroup.OnCheckedChangeListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio_btn)

        val rgSex = findViewById<RadioGroup>(R.id.rg_sex)
        rgSex.setOnCheckedChangeListener(this)
    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        val rg = findViewById<RadioGroup>(R.id.rg_sex)
        if (rg != group) return

        var rb = findViewById<RadioButton>(checkedId)
//        if (rb == null) return null

        when (checkedId) {
            R.id.rb_male ->
                Toast.makeText(this, rb.text, Toast.LENGTH_SHORT).show()
            R.id.rb_female ->
                Toast.makeText(this, rb.text, Toast.LENGTH_SHORT).show()
        }
    }
}

//private fun RadioGroup.setOnCheckedChangeListener(content: Context, group: RadioGroup?, checkedId: Int) {
//    val rg = findViewById<RadioGroup>(R.id.rg_sex)
//    if (rg != group) return
//
//    var rb = findViewById<RadioButton>(checkedId)
////        if (rb == null) return null
//
//    when (checkedId) {
//        R.id.rb_male ->
//            Toast.makeText(content, rb.text, Toast.LENGTH_SHORT).show()
//        R.id.rb_female ->
//            Toast.makeText(content, rb.text, Toast.LENGTH_SHORT).show()
//    }
//}


