package com.test.testterminal

import android.app.Application
import com.stripe.stripeterminal.TerminalLifecycleObserver

// Substitue with your application name
class StripeTerminalApplication : Application() {

    private val observer: TerminalLifecycleObserver = TerminalLifecycleObserver.getInstance()

    override fun onCreate() {
        super.onCreate()

        // Register our observer for all lifecycle hooks!
        registerActivityLifecycleCallbacks(observer)
    }

    // Don't forget to let the observer know if your application is running low on memory!
    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        observer.onTrimMemory(level, this)
    }
}