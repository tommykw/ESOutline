package tommy_kw.esoutline;

import android.app.Application;
import android.support.annotation.NonNull;

import com.orhanobut.logger.Logger;

import tommy_kw.esoutline.di.AppComponent;
import tommy_kw.esoutline.di.AppModule;
import tommy_kw.esoutline.di.DaggerAppComponent;

/**
 * Created by tomita on 15/06/23.
 */
public class App extends Application {
    private static AppComponent sAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        Logger.init("ESOutline");
        initInjector();
    }

    private void initInjector() {
        sAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    @NonNull
    public static AppComponent getAppComponent() {
        return sAppComponent;
    }
}
