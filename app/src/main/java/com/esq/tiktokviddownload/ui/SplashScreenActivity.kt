package com.esq.tiktokviddownload.ui

import android.Manifest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.esq.tiktokviddownload.MainActivity
import com.esq.tiktokviddownload.R
import com.esq.tiktokviddownload.utils.toast
import com.kotlinpermissions.KotlinPermissions

class SplashScreenActivity : AppCompatActivity() {
    private var TAG: String? = SplashScreenActivity::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        KotlinPermissions.with(this)
            .permissions(Manifest.permission.READ_EXTERNAL_STORAGE)
            .onAccepted {
                Log.d(TAG, "Data is $it")
                Handler().postDelayed({
                    this.startActivity(Intent(this, MainActivity::class.java))
                }, 1000)
            }
            .onDenied { permission ->
                toast("You must allow permission!!!")
                finish()
            }
            .onForeverDenied {
                toast("You must allow permission!!!")
                finish()
            }
            .ask()

    }
}
