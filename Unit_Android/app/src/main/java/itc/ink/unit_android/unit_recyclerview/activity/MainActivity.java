package itc.ink.unit_android.unit_recyclerview.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import itc.ink.unit_android.R;
import itc.ink.unit_android.frame_util.StatusBarStyle;
import itc.ink.unit_android.unit_recyclerview.adapter.MainWrapperAdapter;
import itc.ink.unit_android.unit_recyclerview.mode.DataLoad;
import itc.ink.unit_android.unit_recyclerview.mode.mode_action.ActionListDataModel;
import itc.ink.unit_android.unit_recyclerview.mode.mode_action.ActionSubjectDataMode;
import itc.ink.unit_android.unit_recyclerview.mode.mode_interest.InterestDataModel;
import itc.ink.unit_android.unit_recyclerview.mode.mode_product.ProductDataMode;
import itc.ink.unit_android.unit_recyclerview.mode.mode_solution.SolutionDataMode;

/**
 * Created by yangwenjiang on 2018/9/12.
 */

public class MainActivity extends Activity {

    private RecyclerView contentRecyclerView;
    private RecyclerView.LayoutManager contentRvLayoutManager;
    private MainWrapperAdapter contentRvWrapperAdapter;

    private DataLoad mDataLoad;
    private ArrayList<String> mBannerData;
    private ArrayList<SolutionDataMode> mSolutionData;
    private ArrayList<ActionSubjectDataMode> mActionSubjectData;
    private ArrayList<ActionListDataModel> mActionListData;
    private ArrayList<ProductDataMode> mProductData;
    private ArrayList<InterestDataModel> mInterestListData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //StatusBar Style
        StatusBarStyle.setStatusBarFullTransparent(this);
        //StatusBar Text And Icon Style
        StatusBarStyle.setAndroidNativeLightStatusBar(this, true);

        setContentView(R.layout.unit_recyclerview_activity);

        contentRecyclerView = findViewById(R.id.recommend_Choiceness_RecyclerView);

        mDataLoad = new DataLoad(MainActivity.this);
        mBannerData = (ArrayList<String>) mDataLoad.outService.loadBannerData(MainActivity.this);
        mSolutionData = (ArrayList<SolutionDataMode>) mDataLoad.outService.loadSolutionData(MainActivity.this);
        mActionSubjectData = (ArrayList<ActionSubjectDataMode>) mDataLoad.outService.loadActionSubjectData(MainActivity.this);
        mActionListData = (ArrayList<ActionListDataModel>) mDataLoad.outService.loadActionListData(MainActivity.this);
        mProductData = (ArrayList<ProductDataMode>) mDataLoad.outService.loadProductData(MainActivity.this);
        mInterestListData = (ArrayList<InterestDataModel>) mDataLoad.outService.loadInterestData(MainActivity.this);
        if((mBannerData!=null&&mBannerData.size()>0)&&
                (mSolutionData!=null&&mSolutionData.size()>0)&&
                (mActionSubjectData!=null&&mActionSubjectData.size()>0)&&
                (mActionListData!=null&&mActionListData.size()>0)&&
                (mProductData!=null&&mProductData.size()>0)&&
                (mInterestListData!=null&&mInterestListData.size()>0)){
            contentRvWrapperAdapter = new MainWrapperAdapter(MainActivity.this, mBannerData, mSolutionData, mActionSubjectData, mActionListData, mProductData, mInterestListData);
            contentRecyclerView.setAdapter(contentRvWrapperAdapter);
        }

        contentRvLayoutManager = new LinearLayoutManager(this);
        contentRecyclerView.setLayoutManager(contentRvLayoutManager);

    }

}
