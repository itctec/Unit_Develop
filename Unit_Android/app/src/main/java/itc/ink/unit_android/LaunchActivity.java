package itc.ink.unit_android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.Toast;

import itc.ink.unit_android.tools.SPUtil;
import itc.ink.unit_android.tools.StatusBarStyle;

/**
 * Created by yangwenjiang on 2018/9/10.
 */

public class LaunchActivity extends Activity {

    private final int MSG_FINISH_LAUNCHACTIVITY = 0x01;
    private final int LAUNCHACTIVITY_STAY_TIME = 1000;

    private boolean firstExec=true;

    public Handler mHandler = new Handler(){
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_FINISH_LAUNCHACTIVITY:
                    Intent intent = new Intent(LaunchActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    break;
            }
        };
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StatusBarStyle.setStatusBarFullTransparent(this);
        StatusBarStyle.setAndroidNativeLightStatusBar(this,true);

        setContentView(R.layout.activity_launch);

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if(firstExec){
            long appAttachTime=SPUtil.getLong("application_attach_time");
            long diffTime=System.currentTimeMillis() - appAttachTime;
            mHandler.sendEmptyMessageDelayed(MSG_FINISH_LAUNCHACTIVITY, LAUNCHACTIVITY_STAY_TIME-diffTime);
            firstExec=false;
        }
    }
}
