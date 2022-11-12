package com.bignerdranch.android.criminalintent

import android.app.Application

class KoalaApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        CrimeRepository.initialize(this)
    }
}
