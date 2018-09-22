package itc.ink.unit_android.frame_application;

import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.tencent.bugly.Bugly;

import itc.ink.unit_android.frame_util.SPUtil;

/**
 * Created by yangwenjiang on 2018/9/10.
 */

public class UnitAppApplication extends Application {

    public static Context mApplicationContext;
    public static int screenWidth = 0;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);



        mApplicationContext = UnitAppApplication.this;

        SPUtil.putLong("application_attach_time", System.currentTimeMillis());

        WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        screenWidth = displayMetrics.widthPixels;
        SPUtil.putInt("screen_width", screenWidth);
    }
}
