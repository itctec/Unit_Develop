package itc.ink.unit_android.unit_fragment.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;
import itc.ink.unit_android.R;
import itc.ink.unit_android.frame_util.StatusBarStyle;
import itc.ink.unit_android.unit_fragment.fragment.find_fragment.FindFragment;
import itc.ink.unit_android.unit_fragment.fragment.mind_fragment.MindFragment;
import itc.ink.unit_android.unit_fragment.fragment.min_fragment.MineFragment;
import itc.ink.unit_android.unit_fragment.fragment.recommend_fragment.RecommendFragment;
import itc.ink.unit_android.unit_fragment.fragment.sort_frament.SortFragment;

/**
 * Created by yangwenjiang on 2018/9/18.
 */

public class MainActivity extends FragmentActivity {
    private TextView navigationBarRecommendBtn;
    private TextView navigationBarSortBtn;
    private TextView navigationBarMindBtn;
    private TextView navigationBarFindBtn;
    private TextView navigationBarMineBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //StatusBar Style
        StatusBarStyle.setStatusBarFullTransparent(this);
        //StatusBar Text And Icon Style
        StatusBarStyle.setAndroidNativeLightStatusBar(this, true);

        setContentView(R.layout.unit_fragment_activity);

        navigationBarRecommendBtn=findViewById(R.id.app_Bottom_NavigationBar_Recommend_Btn);
        navigationBarRecommendBtn.setOnClickListener(new NavigationBarRecommendBtnClickListener());
        navigationBarSortBtn=findViewById(R.id.app_Bottom_NavigationBar_Sort_Btn);
        navigationBarSortBtn.setOnClickListener(new NavigationBarSortBtnClickListener());
        navigationBarMindBtn=findViewById(R.id.app_Bottom_NavigationBar_Mind_Btn);
        navigationBarMindBtn.setOnClickListener(new NavigationBarMindBtnClickListener());
        navigationBarFindBtn=findViewById(R.id.app_Bottom_NavigationBar_Find_Btn);
        navigationBarFindBtn.setOnClickListener(new NavigationBarFindBtnClickListener());
        navigationBarMineBtn=findViewById(R.id.app_Bottom_NavigationBar_Mine_Btn);
        navigationBarMineBtn.setOnClickListener(new NavigationBarMineBtnClickListener());


        RecommendFragment recommendFragment=new RecommendFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.app_Fragment_Container,recommendFragment).commit();

    }

    private void updateBtnState(View currentActiveBtn){
        navigationBarRecommendBtn.setAlpha(0.5F);
        navigationBarSortBtn.setAlpha(0.5F);
        navigationBarMindBtn.setAlpha(0.5F);
        navigationBarFindBtn.setAlpha(0.5F);
        navigationBarMineBtn.setAlpha(0.5F);

        currentActiveBtn.setAlpha(1F);
    }

    class NavigationBarRecommendBtnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            RecommendFragment recommendFragment=new RecommendFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.app_Fragment_Container,recommendFragment).commit();
            updateBtnState(view);
        }
    }

    class NavigationBarSortBtnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            SortFragment sortFragment=new SortFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.app_Fragment_Container,sortFragment).commit();
            updateBtnState(view);
        }
    }

    class NavigationBarMindBtnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            MindFragment mindFragment=new MindFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.app_Fragment_Container,mindFragment).commit();
            updateBtnState(view);
        }
    }

    class NavigationBarFindBtnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            FindFragment findFragment=new FindFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.app_Fragment_Container,findFragment).commit();
            updateBtnState(view);
        }
    }

    class NavigationBarMineBtnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            MineFragment mineFragment=new MineFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.app_Fragment_Container,mineFragment).commit();
            updateBtnState(view);
        }
    }
}
