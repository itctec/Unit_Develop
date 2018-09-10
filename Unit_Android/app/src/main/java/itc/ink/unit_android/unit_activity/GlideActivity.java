package itc.ink.unit_android.unit_activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import itc.ink.unit_android.R;
import itc.ink.unit_android.tools.StatusBarStyle;

/**
 * Created by yangwenjiang on 2018/9/10.
 */

public class GlideActivity extends Activity {

    private ImageView glideImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //StatusBar Style
        StatusBarStyle.setStatusBarFullTransparent(this);
        //StatusBar Text And Icon Style
        StatusBarStyle.setAndroidNativeLightStatusBar(this, true);

        setContentView(R.layout.activity_unit_glide);

        glideImageView = findViewById(R.id.glideImageView);

    }

}
