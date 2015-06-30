package tommy_kw.esoutline;

import android.app.Application;
import android.support.annotation.NonNull;

import com.orhanobut.logger.Logger;

/**
 * Created by tomita on 15/06/23.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();


        Logger.init("ESOutline");

    }
}
