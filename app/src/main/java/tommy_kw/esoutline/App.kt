package tommy_kw.esoutline

import android.app.Application

import com.orhanobut.logger.Logger

import tommy_kw.esoutline.di.AppComponent
import tommy_kw.esoutline.di.AppModule
import tommy_kw.esoutline.di.DaggerAppComponent

/**
 * Created by tomita on 15/06/23.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        Logger.init("ESOutline")
        initInjector()
    }

    private fun initInjector() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    companion object {
        var appComponent: AppComponent? = null
            private set
    }
}
