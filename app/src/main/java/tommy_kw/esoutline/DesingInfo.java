package tommy_kw.esoutline;

import android.app.Activity;
import android.content.Intent;

import tommy_kw.esoutline.activity.CoordinatorActivity;
import tommy_kw.esoutline.activity.FloatingActionActivity;
import tommy_kw.esoutline.activity.TextInputLayoutActivity;

/**
 * Created by tomita on 15/06/25.
 */
public enum DesingInfo {
    CoordinatorLayout("CoordinatorLayout", CoordinatorActivity.class),
    FloatingActionLayout("FloatingActionLayout", FloatingActionActivity.class),
    TextInputLayout("TextInputLayout", TextInputLayoutActivity.class);

    private String mLabel;
    private Class<?> mActivity;

    DesingInfo(String label, Class<?> activity) {
        mLabel = label;
        mActivity = activity;
    }

    private Intent createdIntent(Activity activity) {
        return new Intent(activity, mActivity);
    }

    public String getLabel() {
        return mLabel;
    }

    public void startActivity(Activity activity) {
        activity.startActivity(createdIntent(activity));
    }
}
