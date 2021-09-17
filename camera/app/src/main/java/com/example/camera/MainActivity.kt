package com.example.camera

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private var CAMERA_REQUEST_CODE: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnVerify = findViewById<Button>(R.id.btn_verify)
        btnVerify.setOnClickListener {
            checkCameraPermission()
        }
    }

    private fun checkCameraPermission() {
        // request permission
        // if camera don't have permission
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED ) {
            requestCameraPermission()
        } else {
            Toast.makeText(
                this,
                "Ya se cuenta con acceso a la camara",
                Toast.LENGTH_SHORT
            ).show()
        }


    }

    private fun requestCameraPermission() {
        // permission has been requested
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
            Toast.makeText(
                this,
                "Rechazo el permiso antes, habilitelo manualmente",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            // first time permission is requested
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), CAMERA_REQUEST_CODE)
        }
    }

    // method for listen permission (called when it runs ActivityCompat.requestPermissions)
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            CAMERA_REQUEST_CODE ->
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission accepted
                    Toast.makeText(
                        this,
                        "se autorizo el permiso",
                        Toast.LENGTH_SHORT
                    ).show()

                    // TODO: action for use camera !!

                } else {
                    Toast.makeText(
                        this,
                        "se denego el permiso",
                        Toast.LENGTH_SHORT
                    ).show()
                }
        }
        return
    }
}