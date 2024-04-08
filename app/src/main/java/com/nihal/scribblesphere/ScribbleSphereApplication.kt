package com.nihal.scribblesphere

import android.app.Application
import com.nihal.scribblesphere.services.notification.createNotificationChannel
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ScribbleSphereApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        createNotificationChannel(this)
    }
}
