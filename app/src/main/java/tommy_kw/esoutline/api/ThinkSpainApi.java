package tommy_kw.esoutline.api;

import java.util.List;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.Client;
import retrofit.converter.SimpleXMLConverter;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;
import rx.functions.Func1;
import tommy_kw.esoutline.BuildConfig;
import tommy_kw.esoutline.model.ThinkSpainEntry;
import tommy_kw.esoutline.model.ThinkSpainFeed;

/**
 * Created by tomita on 15/06/29.
 */
public class ThinkSpainApi {
    private static final String TAG = ThinkSpainApi.class.getSimpleName();
    private RestAdapter mFeedAdapter;
    private FeedService mFeedService;

    private static final String ENDPOINT = "http://www.thinkspain.com/";

    public ThinkSpainApi(Client client, RequestInterceptor requestInterceptor) {
        mFeedAdapter = new RestAdapter.Builder()
                .setClient(client)
                .setConverter(new SimpleXMLConverter())
                .setRequestInterceptor(requestInterceptor)
                .setLogLevel(BuildConfig.DEBUG ? RestAdapter.LogLevel.BASIC : RestAdapter.LogLevel.NONE)
                .setEndpoint(ENDPOINT)
                .build();
        mFeedService = mFeedAdapter.create(FeedService.class);
    }

    public Observable<List<ThinkSpainEntry>> getEntries() {
        return mFeedService.getFeeds().map(new Func1<ThinkSpainFeed, List<ThinkSpainEntry>>() {
            @Override
            public List<ThinkSpainEntry> call(ThinkSpainFeed feed) {
                return feed.items;
            }
        });
    }

    private interface FeedService {
        @GET("/rss/spainnews.xml")
        public Observable<ThinkSpainFeed> getFeeds();
    }
}
