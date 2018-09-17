package itc.ink.unit_android.unit_recyclerview.mode.implement;

import android.content.Context;

import java.util.ArrayList;

import itc.ink.unit_android.R;
import itc.ink.unit_android.unit_recyclerview.mode.DataLoad;
import itc.ink.unit_android.unit_recyclerview.mode.mode_action.ActionListDataModel;
import itc.ink.unit_android.unit_recyclerview.mode.mode_action.ActionSubjectDataMode;
import itc.ink.unit_android.unit_recyclerview.mode.mode_interest.InterestDataModel;
import itc.ink.unit_android.unit_recyclerview.mode.mode_product.ProductDataMode;
import itc.ink.unit_android.unit_recyclerview.mode.mode_solution.SolutionDataMode;

/**
 * Created by yangwenjiang on 2018/9/16.
 */

public class AssertDataLoader implements DataLoad.OutService{

    @Override
    public Object loadBannerData(Context mContext) {
        ArrayList<String> bannerDataArray = new ArrayList<>();

        String[] bannerImageUrls = mContext.getResources().getStringArray(R.array.array_recyclerview_banner_imageurl);

        for (int i = 0; i < bannerImageUrls.length; i++) {
            bannerDataArray.add(bannerImageUrls[i]);
        }
        return bannerDataArray;
    }

    @Override
    public Object loadSolutionData(Context mContext) {
        final int solutionItemNum=12;
        final int solutionImageUrlNum=4;
        final int solutionSortImageUrlNum=4;
        final int solutionVideoUrlNum=1;
        ArrayList<SolutionDataMode> solutionDataArray = new ArrayList<>();

        String[] solutionTitles = mContext.getResources().getStringArray(R.array.array_recyclerview_solution_title);
        String[] solutionSummarys = mContext.getResources().getStringArray(R.array.array_recyclerview_solution_summary);
        String[] solutionImageUrls = mContext.getResources().getStringArray(R.array.array_recyclerview_solution_imageurl);
        String[] solutionImageLeftUrls = mContext.getResources().getStringArray(R.array.array_recyclerview_solution_imageurl_left);
        String[] solutionImageRightUrls = mContext.getResources().getStringArray(R.array.array_recyclerview_solution_imageurl_right);
        String[] solutionVideoUrls = mContext.getResources().getStringArray(R.array.array_recyclerview_solution_videourl);

        for (int i = 0; i < solutionItemNum; i++) {
            SolutionDataMode solutionDataItem = new SolutionDataMode();

            if(solutionTitles.length==solutionItemNum
                    &&solutionSummarys.length==solutionItemNum
                    &&solutionImageUrls.length==solutionImageUrlNum
                    &&solutionImageLeftUrls.length==solutionSortImageUrlNum
                    &&solutionImageRightUrls.length==solutionSortImageUrlNum
                    &&solutionVideoUrls.length==solutionVideoUrlNum){

                solutionDataItem.solutionTitle = solutionTitles[i];
                solutionDataItem.solutionSummary = solutionSummarys[i];

                if(i<4){
                    solutionDataItem.solutionImageLeftUrl = solutionImageLeftUrls[i];
                    solutionDataItem.solutionImageRightUrl = solutionImageRightUrls[i];
                }

                if(i==4){
                    solutionDataItem.solutionVideoUrl = solutionVideoUrls[0];
                }

                if(i>4&&i<9){
                    solutionDataItem.solutionImageUrl = solutionImageUrls[i-5];
                }
            }

            solutionDataArray.add(solutionDataItem);
        }
        return solutionDataArray;
    }

    @Override
    public Object loadActionSubjectData(Context mContext) {
        ArrayList<ActionSubjectDataMode> actionSubjectDataArray = new ArrayList<>();

        String[] actionSubjectTitles = mContext.getResources().getStringArray(R.array.array_recyclerview_action_subject_title);
        String[] actionSubjectSummarys = mContext.getResources().getStringArray(R.array.array_recyclerview_action_subject_summary);
        String[] actionSubjectVideoUrls = mContext.getResources().getStringArray(R.array.array_recyclerview_action_subject_videourl);

        for (int i = 0; i < actionSubjectTitles.length; i++) {
            ActionSubjectDataMode actionSubjectDataItem = new ActionSubjectDataMode();
            actionSubjectDataItem.actionSbujectTitle = actionSubjectTitles[i];
            actionSubjectDataItem.actionSubjectSummary = actionSubjectSummarys[i];
            actionSubjectDataItem.actionSubjectVideoUrl = actionSubjectVideoUrls[i];
            actionSubjectDataArray.add(actionSubjectDataItem);
        }
        return actionSubjectDataArray;
    }

    @Override
    public Object loadActionListData(Context mContext) {
        ArrayList<ActionListDataModel> actionListDataArray = new ArrayList<>();

        String[] actionTitles = mContext.getResources().getStringArray(R.array.array_recyclerview_action_list_title);
        String[] actionPublicityTexts = mContext.getResources().getStringArray(R.array.array_recyclerview_action_list_publicitytext);
        String[] actionDatetimes = mContext.getResources().getStringArray(R.array.array_recyclerview_action_list_datetime);
        String[] actionSites = mContext.getResources().getStringArray(R.array.array_recyclerview_action_list_site);
        String[] actionSummarys = mContext.getResources().getStringArray(R.array.array_recyclerview_action_list_summary);
        String[] actionImageUrls = mContext.getResources().getStringArray(R.array.array_recyclerview_action_list_imageurl);

        for (int i = 0; i < actionTitles.length; i++) {
            ActionListDataModel actionListDataItem = new ActionListDataModel();
            actionListDataItem.actionTitle = actionTitles[i];
            actionListDataItem.actionPublicityText = actionPublicityTexts[i];
            actionListDataItem.actionDatetime = actionDatetimes[i];
            actionListDataItem.actionSite = actionSites[i];
            actionListDataItem.actionSummary = actionSummarys[i];
            actionListDataItem.actionImageUrl = actionImageUrls[i];
            actionListDataArray.add(actionListDataItem);
        }
        return actionListDataArray;
    }

    @Override
    public Object loadProductData(Context mContext) {
        final int productItemNum=9;
        final int productItemSummaryNum=3;
        final int productImageUrlNum=5;
        final int productSortImageUrlNum=4;
        ArrayList<ProductDataMode> productDataArray = new ArrayList<>();

        String[] productTitles = mContext.getResources().getStringArray(R.array.array_recyclerview_product_title);
        String[] productSummarys = mContext.getResources().getStringArray(R.array.array_recyclerview_product_summary);
        String[] productImageUrls = mContext.getResources().getStringArray(R.array.array_recyclerview_product_imageurl);
        String[] productImageLeftUrls = mContext.getResources().getStringArray(R.array.array_recyclerview_product_imageurl_left);
        String[] productImageRightUrls = mContext.getResources().getStringArray(R.array.array_recyclerview_product_imageurl_right);

        for (int i = 0; i < productItemNum; i++) {
            ProductDataMode productDataItem = new ProductDataMode();

            if(productTitles.length==productItemNum
                    &&productSummarys.length==productItemSummaryNum
                    &&productImageUrls.length==productImageUrlNum
                    &&productImageLeftUrls.length==productSortImageUrlNum
                    &&productImageRightUrls.length==productSortImageUrlNum){

                productDataItem.productTitle = productTitles[i];

                if(i<3){
                    productDataItem.productSummary = productSummarys[i];
                }

                if(i==0){
                    productDataItem.productImageUrl=productImageUrls[0];
                }
                if(i>4){
                    productDataItem.productImageUrl=productImageUrls[i-4];
                }


                if(i>0&&i<5){
                    productDataItem.productImageLeftUrl = productImageLeftUrls[i-1];
                    productDataItem.productImageRightUrl = productImageRightUrls[i-1];
                }

            }

            productDataArray.add(productDataItem);
        }
        return productDataArray;
    }

    @Override
    public Object loadInterestData(Context mContext) {
        ArrayList<InterestDataModel> interestDataArray = new ArrayList<>();

        String[] interestTitles = mContext.getResources().getStringArray(R.array.array_recyclerview_interest_list_title);
        String[] interestSummarys = mContext.getResources().getStringArray(R.array.array_recyclerview_interest_list_summary);
        String[] interestSupportNums = mContext.getResources().getStringArray(R.array.array_recyclerview_interest_list_supportnum);
        String[] interestImageUrls = mContext.getResources().getStringArray(R.array.array_recyclerview_interest_list_imageurl);

        for (int i = 0; i < interestTitles.length*20; i++) {
            InterestDataModel interestDataItem = new InterestDataModel();
            interestDataItem.interestTitle = interestTitles[i%5];
            interestDataItem.interestSummary = interestSummarys[i%5];
            interestDataItem.interestSupportNum = interestSupportNums[i%5];
            interestDataItem.interestImageUrl = interestImageUrls[i%5];
            interestDataArray.add(interestDataItem);
        }
        return interestDataArray;
    }
}
