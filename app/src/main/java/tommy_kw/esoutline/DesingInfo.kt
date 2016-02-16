package tommy_kw.esoutline

import android.app.Activity
import android.content.Intent

import tommy_kw.esoutline.activity.CoordinatorActivity
import tommy_kw.esoutline.activity.FloatingActionActivity
import tommy_kw.esoutline.activity.TextInputLayoutActivity

/**
 * Created by tomita on 15/06/25.
 */
enum class DesingInfo private constructor(val label: String,
                                          val mActivity: Class<*>) {
    CoordinatorLayout("CoordinatorLayout", CoordinatorActivity::class.java),
    FloatingActionLayout("FloatingActionLayout", FloatingActionActivity::class.java),
    TextInputLayout("TextInputLayout", TextInputLayoutActivity::class.java);

    private fun createdIntent(activity: Activity): Intent {
        return Intent(activity, mActivity)
    }

    fun startActivity(activity: Activity) {
        activity.startActivity(createdIntent(activity))
    }
}
