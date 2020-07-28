package com.binar.synrgy_permission

import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.LocaleList
import androidx.core.app.ActivityCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.OnSuccessListener
import kotlinx.android.synthetic.main.activity_main.*
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {

    private var PERMISSION_ID : Int = 10

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

    // create fun to check the uses permissions
    private fun CheckPermission():Boolean{
        if(
            ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED ||
            ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
        ){
            return true
        }
            return false
    }

    // fun allow to get user permission
    private fun RequestPermission(){
        ActivityCompat.requestPermissions(
            this,
            arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION,android.Manifest.permission.ACCESS_COARSE_LOCATION),PERMISSION_ID
        )
    }

    // function to check if the location of the device is enable
    private fun isLocationEnabled():Boolean{
        var locationManager: Any = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled()

    }
} 

