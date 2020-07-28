package com.binar.synrgy_permission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try {
            this.supportActionBar?.hide()
        } catch (e: NullPointerException) {}

        var iniGambar = gambar
        iniGambar = findViewById(R.id.gambar)
            Glide.with(this).load("https://miro.medium.com/max/798/0*sq-A5xINKPCfU30k.png").into(iniGambar)

    }
}