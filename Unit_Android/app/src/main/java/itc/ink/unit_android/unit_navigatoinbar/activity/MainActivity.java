package itc.ink.unit_android.unit_navigatoinbar.activity;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import itc.ink.unit_android.R;
import itc.ink.unit_android.frame_util.StatusBarStyle;
import itc.ink.unit_android.unit_navigatoinbar.core.ScrollableNavigationBar;
import itc.ink.unit_android.unit_navigatoinbar.mode.DataLoad;

/**
 * Created by yangwenjiang on 2018/9/18.
 */

public class MainActivity extends Activity {
    private ScrollableNavigationBar sortTopBarNavigation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //StatusBar Style
        StatusBarStyle.setStatusBarFullTransparent(this);
        //StatusBar Text And Icon Style
        StatusBarStyle.setAndroidNativeLightStatusBar(this, true);

        setContentView(R.layout.unit_navigationbar_activity);

        sortTopBarNavigation=findViewById(R.id.sort_TopBar_Navigation);
        sortTopBarNavigation.setCallBack(new NavigationBarItemClickCallBack());
    }

    class NavigationBarItemClickCallBack implements ScrollableNavigationBar.OutCallBack{
        @Override
        public void onTitleClick(String titleStr) {
            Toast.makeText(MainActivity.this,titleStr+"被点击",Toast.LENGTH_SHORT).show();
        }
    }

}
