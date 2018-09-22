package itc.ink.unit_android.unit_viewpager.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;
import itc.ink.unit_android.R;
import itc.ink.unit_android.frame_application.UnitAppApplication;
import itc.ink.unit_android.frame_util.StatusBarStyle;
import itc.ink.unit_android.unit_viewpager.adapter.RecommendContentViewPagerAdapter;
import itc.ink.unit_android.unit_viewpager.mode.DataLoad;

/**
 * Created by yangwenjiang on 2018/9/18.
 */

public class MainActivity extends Activity {
    private TextView navigationBarChoicenessBtn;
    private TextView navigationBarAttentionBtn;
    private TextView navigationBarMindBtn;
    private TextView navigationBarIndicator;
    private ViewPager recommendContentViewPager;

    private DataLoad mDataLoad;
    private Object mActionBarTitleData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //StatusBar Style
        StatusBarStyle.setStatusBarFullTransparent(this);
        //StatusBar Text And Icon Style
        StatusBarStyle.setAndroidNativeLightStatusBar(this, true);

        setContentView(R.layout.unit_viewpager_activity);

        navigationBarIndicator = findViewById(R.id.app_Top_NavigationBar_Indicator);
        navigationBarChoicenessBtn = findViewById(R.id.app_Top_NavigationBar_Choiceness_Btn);
        navigationBarChoicenessBtn.setOnClickListener(new NavigationBarChoicenessBtnClickListener());
        navigationBarAttentionBtn = findViewById(R.id.app_Top_NavigationBar_Attention_Btn);
        navigationBarAttentionBtn.setOnClickListener(new NavigationBarAttentionBtnClickListener());
        navigationBarMindBtn = findViewById(R.id.app_Top_NavigationBar_Mind_Btn);
        navigationBarMindBtn.setOnClickListener(new NavigationBarMindBtnClickListener());

        mDataLoad = new DataLoad();
        mActionBarTitleData = mDataLoad.outService.loadActionBarTitleData(MainActivity.this);

        recommendContentViewPager = findViewById(R.id.recommend_Content_ViewPager);
        recommendContentViewPager.setAdapter(new RecommendContentViewPagerAdapter(MainActivity.this, mActionBarTitleData));
        recommendContentViewPager.addOnPageChangeListener(new RecommendContentViewPagerChangeListener());

    }

    private void updateNavigationTopBtnState(View currentActiveBtn) {
        navigationBarChoicenessBtn.setAlpha(0.5F);
        navigationBarAttentionBtn.setAlpha(0.5F);
        navigationBarMindBtn.setAlpha(0.5F);

        currentActiveBtn.setAlpha(1F);
    }

    class RecommendContentViewPagerChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int i, float v, int i1) {
            navigationBarIndicator.setTranslationX((UnitAppApplication.screenWidth / 3) * i + (UnitAppApplication.screenWidth / 3) * v);
        }

        @Override
        public void onPageSelected(int i) {
            switch (i) {
                case 0:
                    updateNavigationTopBtnState(navigationBarChoicenessBtn);
                    break;
                case 1:
                    updateNavigationTopBtnState(navigationBarAttentionBtn);
                    break;
                case 2:
                    updateNavigationTopBtnState(navigationBarMindBtn);
                    break;
            }

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    }

    class NavigationBarChoicenessBtnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            recommendContentViewPager.setCurrentItem(0);
        }
    }

    class NavigationBarAttentionBtnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            recommendContentViewPager.setCurrentItem(1);
        }
    }

    class NavigationBarMindBtnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            recommendContentViewPager.setCurrentItem(2);
        }
    }

}
