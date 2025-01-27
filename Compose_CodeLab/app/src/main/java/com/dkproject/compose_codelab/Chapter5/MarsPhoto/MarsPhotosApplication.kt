package com.dkproject.compose_codelab.Chapter5.MarsPhoto

import android.app.Application
import com.dkproject.compose_codelab.Chapter5.MarsPhoto.data.AppContainer
import com.dkproject.compose_codelab.Chapter5.MarsPhoto.data.DefaultAppContainer

class MarsPhotosApplication: Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}