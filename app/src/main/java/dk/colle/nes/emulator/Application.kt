package dk.colle.nes.emulator

import timber.log.Timber

class Application: android.app.Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(
            Timber.DebugTree()
        )
    }
}