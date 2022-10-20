package com.example.myapplication

import android.app.Application
import com.contus.flycommons.LogMessage
import com.contusflysdk.ChatSDK

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        //For chat logging
        LogMessage.enableDebugLogging(BuildConfig.DEBUG)

        ChatSDK.Builder()
            .setDomainBaseUrl(BuildConfig.SDK_BASE_URL)
            .setLicenseKey(BuildConfig.LICENSE)
            .setIsTrialLicenceKey(true)
            .build()

    }
}
