package itc.ink.unit_android.unit_fragment.fragment.recommend_fragment.child_fragment.choiceness_fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import itc.ink.unit_android.R;
import itc.ink.unit_android.unit_recyclerview.adapter.MainWrapperAdapter;
import itc.ink.unit_android.unit_recyclerview.mode.DataLoad;
import itc.ink.unit_android.unit_recyclerview.mode.mode_action.ActionListDataModel;
import itc.ink.unit_android.unit_recyclerview.mode.mode_action.ActionSubjectDataMode;
import itc.ink.unit_android.unit_recyclerview.mode.mode_interest.InterestDataModel;
import itc.ink.unit_android.unit_recyclerview.mode.mode_product.ProductDataMode;
import itc.ink.unit_android.unit_recyclerview.mode.mode_solution.SolutionDataMode;

/**
 * Created by yangwenjiang on 2018/9/20.
 */

public class ChoicenessFragment extends Fragment {

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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDataLoad = new DataLoad(getActivity());
        mBannerData = (ArrayList<String>) mDataLoad.outService.loadBannerData(getActivity());
        mSolutionData = (ArrayList<SolutionDataMode>) mDataLoad.outService.loadSolutionData(getActivity());
        mActionSubjectData = (ArrayList<ActionSubjectDataMode>) mDataLoad.outService.loadActionSubjectData(getActivity());
        mActionListData = (ArrayList<ActionListDataModel>) mDataLoad.outService.loadActionListData(getActivity());
        mProductData = (ArrayList<ProductDataMode>) mDataLoad.outService.loadProductData(getActivity());
        mInterestListData = (ArrayList<InterestDataModel>) mDataLoad.outService.loadInterestData(getActivity());
        if((mBannerData!=null&&mBannerData.size()>0)&&
                (mSolutionData!=null&&mSolutionData.size()>0)&&
                (mActionSubjectData!=null&&mActionSubjectData.size()>0)&&
                (mActionListData!=null&&mActionListData.size()>0)&&
                (mProductData!=null&&mProductData.size()>0)&&
                (mInterestListData!=null&&mInterestListData.size()>0)){
            contentRvWrapperAdapter = new MainWrapperAdapter(getActivity(), mBannerData, mSolutionData, mActionSubjectData, mActionListData, mProductData, mInterestListData);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.unit_recyclerview_activity,container,false);
        contentRecyclerView = rootView.findViewById(R.id.recommend_Choiceness_RecyclerView);
        if(contentRvWrapperAdapter!=null){
            contentRecyclerView.setAdapter(contentRvWrapperAdapter);
        }


        contentRvLayoutManager = new LinearLayoutManager(getActivity());
        contentRecyclerView.setLayoutManager(contentRvLayoutManager);
        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
