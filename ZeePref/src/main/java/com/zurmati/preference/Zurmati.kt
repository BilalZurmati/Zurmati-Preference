package com.zurmati.preference

import android.app.Application
import android.content.Context

class Zurmati : Application() {
    companion object {
        private lateinit var zInstance: Zurmati

        fun getContext(): Context {
            return zInstance.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        zInstance = this
    }
}