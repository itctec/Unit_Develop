package itc.ink.unit_android.unit_recyclerview.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import itc.ink.unit_android.R;
import itc.ink.unit_android.frame_util.StatusBarStyle;
import itc.ink.unit_android.unit_recyclerview.adapter.MainWrapperAdapter;
import itc.ink.unit_android.unit_recyclerview.mode.DataLoad;

/**
 * Created by yangwenjiang on 2018/9/12.
 */

public class MainActivity extends Activity {

    private RecyclerView contentRecyclerView;
    private RecyclerView.LayoutManager contentRvLayoutManager;
    private MainWrapperAdapter contentRvWrapperAdapter;

    private DataLoad mDataLoad;
    private Object mBannerData;
    private Object mSolutionData;
    private Object mActionSubjectData;
    private Object mActionListData;
    private Object mProductData;
    private Object mInterestListData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //StatusBar Style
        StatusBarStyle.setStatusBarFullTransparent(this);
        //StatusBar Text And Icon Style
        StatusBarStyle.setAndroidNativeLightStatusBar(this, true);

        setContentView(R.layout.unit_recyclerview_activity);

        contentRecyclerView = findViewById(R.id.recommend_Choiceness_RecyclerView);

        mDataLoad = new DataLoad();
        mBannerData = mDataLoad.outService.loadBannerData(MainActivity.this);
        mSolutionData = mDataLoad.outService.loadSolutionData(MainActivity.this);
        mActionSubjectData=mDataLoad.outService.loadActionSubjectData(MainActivity.this);
        mActionListData = mDataLoad.outService.loadActionListData(MainActivity.this);
        mProductData=mDataLoad.outService.loadProductData(MainActivity.this);
        mInterestListData = mDataLoad.outService.loadInterestData(MainActivity.this);
        contentRvWrapperAdapter = new MainWrapperAdapter(MainActivity.this, mBannerData, mSolutionData, mActionSubjectData,  mActionListData,mProductData, mInterestListData);
        contentRecyclerView.setAdapter(contentRvWrapperAdapter);

        contentRvLayoutManager = new LinearLayoutManager(this);
        contentRecyclerView.setLayoutManager(contentRvLayoutManager);

    }

}
