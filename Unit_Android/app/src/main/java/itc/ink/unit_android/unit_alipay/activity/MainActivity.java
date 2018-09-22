package itc.ink.unit_android.unit_alipay.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.tencent.bugly.Bugly;

import itc.ink.unit_android.R;
import itc.ink.unit_android.frame_util.StatusBarStyle;

/**
 * Created by yangwenjiang on 2018/9/21.
 */

public class MainActivity extends Activity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //StatusBar Style
        StatusBarStyle.setStatusBarFullTransparent(this);
        //StatusBar Text And Icon Style
        StatusBarStyle.setAndroidNativeLightStatusBar(this, true);

        setContentView(R.layout.unit_alipay_activity);

    }

}
