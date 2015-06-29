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

import butterknife.ButterKnife;
import butterknife.InjectView;
import tommy_kw.esoutline.R;


public class MainActivity extends AppCompatActivity {
    @InjectView(R.id.tool_bar)
    Toolbar mToolbar;
    @InjectView(R.id.tab_layout)
    TabLayout mTabLayout;

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
