package tommy_kw.esoutline.api;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import retrofit.RequestInterceptor;

/**
 * Created by tomita on 15/07/01.
 */
public class AppRequestInterceptor implements RequestInterceptor {
    private final ConnectivityManager mConnectivityManager;

    public AppRequestInterceptor(Context context) {
        mConnectivityManager = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
    }

    @Override
    public void intercept(RequestFacade request) {
        if (isConnected()) {
            request.addHeader("cache-control", "public, max-age=100");
        } else {
            request.addHeader("cache-control", "public, only-if-cached, max-stale=3600");
        }
        request.addHeader("user-agent", "ESOutline");
    }


    private boolean isConnected() {
        NetworkInfo networkInfo = mConnectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }
}
