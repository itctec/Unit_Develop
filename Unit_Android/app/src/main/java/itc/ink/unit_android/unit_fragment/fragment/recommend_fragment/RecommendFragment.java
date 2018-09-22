package itc.ink.unit_android.unit_fragment.fragment.recommend_fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import itc.ink.unit_android.R;
import itc.ink.unit_android.frame_application.UnitAppApplication;
import itc.ink.unit_android.unit_fragment.fragment.recommend_fragment.adapter.RecommendFragmentViewPagerAdapter;
import itc.ink.unit_android.unit_fragment.fragment.recommend_fragment.child_fragment.attention_fragment.AttentionFragment;
import itc.ink.unit_android.unit_fragment.fragment.recommend_fragment.child_fragment.choiceness_fragment.ChoicenessFragment;
import itc.ink.unit_android.unit_fragment.fragment.recommend_fragment.child_fragment.mind_fragment.MindFragment;

/**
 * Created by yangwenjiang on 2018/9/19.
 */

public class RecommendFragment extends Fragment {
    private TextView navigationBarChoicenessBtn;
    private TextView navigationBarAttentionBtn;
    private TextView navigationBarMindBtn;
    private TextView navigationBarIndicator;
    private ViewPager recommendContentViewPager;

    List<Fragment> mFragmentList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.unit_fragment_recommend, container, false);

        navigationBarIndicator = rootView.findViewById(R.id.app_Top_NavigationBar_Indicator);
        navigationBarChoicenessBtn = rootView.findViewById(R.id.app_Top_NavigationBar_Choiceness_Btn);
        navigationBarChoicenessBtn.setOnClickListener(new NavigationBarChoicenessBtnClickListener());
        navigationBarAttentionBtn = rootView.findViewById(R.id.app_Top_NavigationBar_Attention_Btn);
        navigationBarAttentionBtn.setOnClickListener(new NavigationBarAttentionBtnClickListener());
        navigationBarMindBtn = rootView.findViewById(R.id.app_Top_NavigationBar_Mind_Btn);
        navigationBarMindBtn.setOnClickListener(new NavigationBarMindBtnClickListener());

        recommendContentViewPager = rootView.findViewById(R.id.recommend_Content_ViewPager);
        mFragmentList=initFragmentList();
        recommendContentViewPager.setAdapter(new RecommendFragmentViewPagerAdapter(getChildFragmentManager(),mFragmentList));
        recommendContentViewPager.addOnPageChangeListener(new RecommendContentViewPagerChangeListener());

        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    private List<Fragment> initFragmentList(){
        List<Fragment> mFragmentList = new ArrayList<>();
        ChoicenessFragment choicenessFragment=new ChoicenessFragment();
        AttentionFragment attentionFragment=new AttentionFragment();
        MindFragment mindFragment=new MindFragment();

        mFragmentList.add(choicenessFragment);
        mFragmentList.add(attentionFragment);
        mFragmentList.add(mindFragment);

        return mFragmentList;
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

    class NavigationBarChoicenessBtnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            recommendContentViewPager.setCurrentItem(0);
        }
    }

    class NavigationBarAttentionBtnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            recommendContentViewPager.setCurrentItem(1);
        }
    }

    class NavigationBarMindBtnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            recommendContentViewPager.setCurrentItem(2);
        }
    }
}
