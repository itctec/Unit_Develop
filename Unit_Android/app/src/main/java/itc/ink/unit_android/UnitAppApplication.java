package itc.ink.unit_android;

import android.app.Application;
import android.content.Context;

import itc.ink.unit_android.tools.SPUtil;

/**
 * Created by yangwenjiang on 2018/9/10.
 */

public class UnitAppApplication extends Application {

    public static Context mApplicationContext;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

        mApplicationContext=UnitAppApplication.this;

        SPUtil.putLong("application_attach_time",
                System.currentTimeMillis());
    }
}
