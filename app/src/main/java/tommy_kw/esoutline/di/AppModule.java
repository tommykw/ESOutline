package tommy_kw.esoutline.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;

import java.io.File;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RequestInterceptor;
import retrofit.client.Client;
import retrofit.client.OkClient;
import tommy_kw.esoutline.api.ThinkSpainApi;

/**
 * Created by tomita on 15/06/30.
 */
@Module
public class AppModule {
    private static final String HTTP_CACHE_FILE_NAME = "okhttp.cache";
    private static final long MAX_CACHE_SIZE = 4 * 1024 * 1024;
    private static final String SHARED_PREF_NAME = "app_pref";

    private Context mContext;

    public AppModule(Application app) {
        mContext = app;
    }

    @Provides
    public Context privideContext() {
        return mContext;
    }

    @Singleton
    @Provides
    public OkHttpClient provideHttpClient(Context context) {
        File cacheDir = new File(context.getCacheDir(), HTTP_CACHE_FILE_NAME);
        Cache cache = new Cache(cacheDir, MAX_CACHE_SIZE);

        OkHttpClient httpClient = new OkHttpClient();
        httpClient.setCache(cache);
        return httpClient;
    }

    @Provides
    public Client provideRetrofitClient(OkHttpClient httpClient) {
        return new OkClient(httpClient);
    }

    @Singleton
    @Provides
    public ThinkSpainApi provideThinkSpainApi(Client client, RequestInterceptor requestInterceptor) {
        return new ThinkSpainApi(client, requestInterceptor);
    }

    @Provides
    public SharedPreferences provideSharedPreferences(Context context) {
        return context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
    }
}
