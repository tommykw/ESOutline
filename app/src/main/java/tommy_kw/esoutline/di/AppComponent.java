package tommy_kw.esoutline.di;

import javax.inject.Singleton;

import dagger.Component;
import tommy_kw.esoutline.activity.MainActivity;

/**
 * Created by tomita on 15/06/30.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    //void inject(MainActivity activity);
}
