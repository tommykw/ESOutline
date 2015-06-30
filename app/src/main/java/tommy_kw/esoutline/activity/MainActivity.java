package tommy_kw.esoutline.activity;

import android.support.design.widget.TabLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.orhanobut.logger.Logger;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import rx.Observable;
import rx.android.app.AppObservable;
import rx.functions.Action1;
import rx.functions.Func1;
import tommy_kw.esoutline.R;
import tommy_kw.esoutline.api.ThinkSpainApi;
import tommy_kw.esoutline.model.ThinkSpainEntry;


public class MainActivity extends AppCompatActivity {
    @InjectView(R.id.tool_bar)
    Toolbar mToolbar;
    @InjectView(R.id.tab_layout)
    TabLayout mTabLayout;
    @Inject
    ThinkSpainApi mThinkSpainApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        //This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.
        //setSupportActionBar(mToolbar);

        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }

        initTabLayout();

        Observable<List<ThinkSpainEntry>> observable;
        observable = mThinkSpainApi.getEntries();
        AppObservable.bindFragment(this, observable)
                .doOnNext(new Action1<List<ThinkSpainEntry>>() {
                    @Override
                    public void call(List<ThinkSpainEntry> items) {
                        Logger.w("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! rx");
                    }
                }).onErrorReturn(new Func1<Throwable, List<ThinkSpainEntry>>() {
                    @Override
                    public List<ThinkSpainEntry> call(Throwable throwable) {
                        return Collections.emptyList();
                    }
                });

    }

    private void initTabLayout() {
        mTabLayout.setBackgroundColor(getResources().getColor(R.color.bg_brand));
        mTabLayout.addTab(mTabLayout.newTab().setText("xxxx01"));
        mTabLayout.addTab(mTabLayout.newTab().setText("xxxx02"));
        mTabLayout.addTab(mTabLayout.newTab().setText("xxxx03"));
        mTabLayout.addTab(mTabLayout.newTab().setText("xxxx04"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
