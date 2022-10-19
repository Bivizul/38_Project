package aaa.bivizul.a38project.android

import aaa.bivizul.a38project.domain.util.Spohowcon
import android.app.Application
import com.onesignal.OneSignal

class A38PApp : Application() {

    override fun onCreate() {
        super.onCreate()

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId(Spohowcon.SPOHOWOSAI)

    }

}