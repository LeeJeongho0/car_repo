package com.example.a0401

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.a0401.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding:ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView1.setOnClickListener {
            Toast.makeText(applicationContext,"벤틀리 플라잉스퍼",Toast.LENGTH_SHORT).show()
        }
        binding.imageView2.setOnClickListener {
            Toast.makeText(applicationContext,"벤틀리 뮬리너 바투르",Toast.LENGTH_SHORT).show()
        }
        binding.imageView3.setOnClickListener {
            Toast.makeText(applicationContext,"벤틀리 벤테이가",Toast.LENGTH_SHORT).show()
        }

    }
}