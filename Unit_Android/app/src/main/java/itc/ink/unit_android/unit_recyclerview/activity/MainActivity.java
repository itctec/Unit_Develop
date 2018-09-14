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
import itc.ink.unit_android.unit_recyclerview.adapter.adapter_action.ActionDataAdapter;
import itc.ink.unit_android.unit_recyclerview.adapter.adapter_interest.InterestDataAdapter;
import itc.ink.unit_android.unit_recyclerview.mode.mode_action.ActionDataModel;
import itc.ink.unit_android.unit_recyclerview.mode.mode_interest.InterestDataModel;

/**
 * Created by yangwenjiang on 2018/9/12.
 */

public class MainActivity extends Activity {

    private RecyclerView contentRecyclerView;
    private RecyclerView.LayoutManager contentRvLayoutManager;
    private ActionDataAdapter contentRvActionListDataAdapter;
    private InterestDataAdapter contentRvInterestListDataAdapter;
    private MainWrapperAdapter contentRvWrapperAdapter;

    private ArrayList<ActionDataModel> mActionData;
    private ArrayList<InterestDataModel> mInterestData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //StatusBar Style
        StatusBarStyle.setStatusBarFullTransparent(this);
        //StatusBar Text And Icon Style
        StatusBarStyle.setAndroidNativeLightStatusBar(this, true);

        setContentView(R.layout.unit_recyclerview_activity);

        contentRecyclerView = findViewById(R.id.recommend_Choiceness_RecyclerView);

        mActionData = initActionData();
        contentRvActionListDataAdapter=new ActionDataAdapter(MainActivity.this,mActionData);
        mInterestData = initInterestData();
        contentRvInterestListDataAdapter = new InterestDataAdapter(MainActivity.this,mInterestData);
        contentRvWrapperAdapter = new MainWrapperAdapter(MainActivity.this, contentRvActionListDataAdapter, contentRvInterestListDataAdapter);
        contentRecyclerView.setAdapter(contentRvWrapperAdapter);

        contentRvLayoutManager = new LinearLayoutManager(this);
        contentRecyclerView.setLayoutManager(contentRvLayoutManager);

    }

    public ArrayList<ActionDataModel> initActionData() {
        ArrayList<ActionDataModel> actionDataArray = new ArrayList<>();

        String[] actionTitles = getResources().getStringArray(R.array.array_recyclerview_action_title);
        String[] actionPublicityTexts = getResources().getStringArray(R.array.array_recyclerview_action_publicitytext);
        String[] actionDatetimes = getResources().getStringArray(R.array.array_recyclerview_action_datetime);
        String[] actionSites = getResources().getStringArray(R.array.array_recyclerview_action_site);
        String[] actionSummarys = getResources().getStringArray(R.array.array_recyclerview_action_summary);

        for (int i = 0; i < actionTitles.length; i++) {
            ActionDataModel actionDataItem = new ActionDataModel();
            actionDataItem.actionTitle = actionTitles[i];
            actionDataItem.actionPublicityText = actionPublicityTexts[i];
            actionDataItem.actionDatetime = actionDatetimes[i];
            actionDataItem.actionSite = actionSites[i];
            actionDataItem.actionSummary = actionSummarys[i];
            actionDataArray.add(actionDataItem);
        }
        return actionDataArray;
    }

    public ArrayList<InterestDataModel> initInterestData() {
        ArrayList<InterestDataModel> interestDataArray = new ArrayList<>();

        String[] interestTitles = getResources().getStringArray(R.array.array_recyclerview_interest_title);
        String[] interestSummarys = getResources().getStringArray(R.array.array_recyclerview_interest_summary);
        String[] interestSupportNums = getResources().getStringArray(R.array.array_recyclerview_interest_supportnum);

        for (int i = 0; i < interestTitles.length; i++) {
            InterestDataModel interestDataItem = new InterestDataModel();
            interestDataItem.interestTitle = interestTitles[i];
            interestDataItem.interestSummary = interestSummarys[i];
            interestDataItem.interestSupportNum = " "+interestSupportNums[i];
            interestDataArray.add(interestDataItem);
        }
        return interestDataArray;
    }

}
