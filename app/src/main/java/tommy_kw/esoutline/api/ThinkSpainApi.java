package tommy_kw.esoutline.api;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;
import tommy_kw.esoutline.model.ThinkSpainEntry;

/**
 * Created by tomita on 15/06/29.
 */
public interface ThinkSpainApi {
    public static final String ENDPOINT = "http://www.thinkspain.com/";

    @GET("/rss/{xml}")
    public Observable<ThinkSpainEntry> get(@Path("xml") String xml);
}
