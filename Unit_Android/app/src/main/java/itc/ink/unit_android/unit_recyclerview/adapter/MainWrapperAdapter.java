package itc.ink.unit_android.unit_recyclerview.adapter;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.youth.banner.Banner;

import org.w3c.dom.Text;

import java.util.ArrayList;

import itc.ink.unit_android.R;
import itc.ink.unit_android.unit_recyclerview.adapter.adapter_action.ActionDataAdapter;
import itc.ink.unit_android.unit_recyclerview.adapter.adapter_interest.InterestDataAdapter;
import itc.ink.unit_android.unit_recyclerview.adapter.implement.ActionSubjectDelegateImplement;
import itc.ink.unit_android.unit_recyclerview.adapter.implement.BannerDelegateImplement;
import itc.ink.unit_android.unit_recyclerview.adapter.implement.ProductDelegateImplement;
import itc.ink.unit_android.unit_recyclerview.adapter.implement.SolutionDelegateImplement;
import itc.ink.unit_android.unit_recyclerview.mode.mode_action.ActionListDataModel;
import itc.ink.unit_android.unit_recyclerview.mode.mode_action.ActionSubjectDataMode;
import itc.ink.unit_android.unit_recyclerview.mode.mode_interest.InterestDataModel;
import itc.ink.unit_android.unit_recyclerview.mode.mode_product.ProductDataMode;
import itc.ink.unit_android.unit_recyclerview.mode.mode_solution.SolutionDataMode;

/**
 * Created by yangwenjiang on 2018/9/14.
 */

public class MainWrapperAdapter extends RecyclerView.Adapter<MainWrapperAdapter.WrapperVH> {

    private Context mContext;
    private ArrayList<String> mBannerData;
    private ArrayList<SolutionDataMode> mSolutionData;
    private ArrayList<ActionSubjectDataMode> mActionSubjectData;
    private ActionDataAdapter mActionDataAdapter;
    private ArrayList<ProductDataMode> mProductData;
    private InterestDataAdapter mInterestDataAdapter;
    private DelegateInterface mDelegateInterface;

    public MainWrapperAdapter(Context mContext, Object mBannerData, Object mSolutionData, Object mActionSubjectData, Object mActionListData, Object mProductData, Object mInterestListData) {
        this.mContext = mContext;
        this.mBannerData = (ArrayList<String>) mBannerData;
        this.mSolutionData = (ArrayList<SolutionDataMode>) mSolutionData;
        this.mActionSubjectData=(ArrayList<ActionSubjectDataMode>)mActionSubjectData;
        this.mActionDataAdapter = new ActionDataAdapter(mContext, (ArrayList<ActionListDataModel>) mActionListData);
        this.mProductData=(ArrayList<ProductDataMode>) mProductData;
        this.mInterestDataAdapter = new InterestDataAdapter(mContext, (ArrayList<InterestDataModel>) mInterestListData);
    }

    @Override
    public MainWrapperAdapter.WrapperVH onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE.BANNER.ordinal()) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.unit_recyclerview_banner_item, parent, false);
            return new MainWrapperAdapter.WrapperVH(view, ITEM_TYPE.BANNER) {
            };
        } else if (viewType == ITEM_TYPE.SOLUTION.ordinal()) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.unit_recyclerview_solution_item, parent, false);
            return new MainWrapperAdapter.WrapperVH(view, ITEM_TYPE.SOLUTION) {
            };
        } else if (viewType == ITEM_TYPE.ACTION_SUBJECT.ordinal()) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.unit_recyclerview_action_subject_item, parent, false);
            return new MainWrapperAdapter.WrapperVH(view, ITEM_TYPE.ACTION_SUBJECT) {
            };
        } else if (viewType == ITEM_TYPE.ACTION_LIST.ordinal()) {
            return mActionDataAdapter.onCreateViewHolder(parent, viewType);
        } else if (viewType == ITEM_TYPE.PRODUCT.ordinal()) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.unit_recyclerview_product_item, parent, false);
            return new MainWrapperAdapter.WrapperVH(view, ITEM_TYPE.PRODUCT) {
            };
        } else if (viewType == ITEM_TYPE.INTEREST_HEADER.ordinal()) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.unit_recyclerview_interest_header_item, parent, false);
            return new MainWrapperAdapter.WrapperVH(view, ITEM_TYPE.INTEREST_HEADER) {
            };
        } else {
            return mInterestDataAdapter.onCreateViewHolder(parent, viewType);
        }
    }

    @Override
    public void onBindViewHolder(MainWrapperAdapter.WrapperVH holder, int position) {
        if (position == 0) {
            mDelegateInterface = new BannerDelegateImplement();
            mDelegateInterface.handleTransaction(mContext, holder, mBannerData);
            return;
        } else if (position == 1) {
            mDelegateInterface = new SolutionDelegateImplement();
            mDelegateInterface.handleTransaction(mContext, holder, mSolutionData);
            return;
        } else if (position == 2) {
            mDelegateInterface = new ActionSubjectDelegateImplement();
            mDelegateInterface.handleTransaction(mContext, holder, mActionSubjectData);
            return;
        } else if (position > 2 && position < (mActionDataAdapter.getItemCount() + 3)) {
            mActionDataAdapter.onBindViewHolder(((ActionDataAdapter.VH) holder), position - 3);
        } else if (position == (mActionDataAdapter.getItemCount() + 3)) {
            mDelegateInterface = new ProductDelegateImplement();
            mDelegateInterface.handleTransaction(mContext, holder, mProductData);
            return;
        } else if (position == (mActionDataAdapter.getItemCount() + 4)) {
            return;
        } else {
            mInterestDataAdapter.onBindViewHolder(((InterestDataAdapter.VH) holder), position - (mActionDataAdapter.getItemCount() + 5));
        }
    }

    @Override
    public int getItemCount() {
        return mActionDataAdapter.getItemCount() + mInterestDataAdapter.getItemCount() + 5;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return ITEM_TYPE.BANNER.ordinal();
        } else if (position == 1) {
            return ITEM_TYPE.SOLUTION.ordinal();
        } else if (position == 2) {
            return ITEM_TYPE.ACTION_SUBJECT.ordinal();
        } else if (position > 2 && position < (mActionDataAdapter.getItemCount() + 3)) {
            return ITEM_TYPE.ACTION_LIST.ordinal();
        } else if (position == (mActionDataAdapter.getItemCount() + 3)) {
            return ITEM_TYPE.PRODUCT.ordinal();
        } else if (position == (mActionDataAdapter.getItemCount() + 4)) {
            return ITEM_TYPE.INTEREST_HEADER.ordinal();
        } else {
            return ITEM_TYPE.INTEREST.ordinal();
        }
    }

    public static class WrapperVH extends RecyclerView.ViewHolder {
        //Banner Widget
        public Banner choicenessBanner;

        //Solution Widget
        public TextView solutionRecommendTopTextView;

        public ConstraintLayout solutionSortOneLayout;
        public TextView solutionSortOneTitleTextView;
        public TextView solutionSortOneSummaryTextView;
        public ImageView solutionSortOneLeftImageImageView;
        public ImageView solutionSortOneRightImageImageView;

        public ConstraintLayout solutionSortTwoLayout;
        public TextView solutionSortTwoTitleTextView;
        public TextView solutionSortTwoSummaryTextView;
        public ImageView solutionSortTwoLeftImageImageView;
        public ImageView solutionSortTwoRightImageImageView;

        public ConstraintLayout solutionSortThreeLayout;
        public TextView solutionSortThreeTitleTextView;
        public TextView solutionSortThreeSummaryTextView;
        public ImageView solutionSortThreeLeftImageImageView;
        public ImageView solutionSortThreeRightImageImageView;

        public ConstraintLayout solutionSortFourLayout;
        public TextView solutionSortFourTitleTextView;
        public TextView solutionSortFourSummaryTextView;
        public ImageView solutionSortFourLeftImageImageView;
        public ImageView solutionSortFourRightImageImageView;

        public ConstraintLayout solutionSubjectOneLayout;
        public VideoView solutionSubjectOneVideoVideoView;
        public TextView solutionSubjectOneTitleTextView;
        public TextView solutionSubjectOneSummaryTextView;

        public ConstraintLayout solutionOneLayout;
        public ImageView solutionOneImageImageView;
        public TextView solutionOneTitleTextView;
        public TextView solutionOneSummaryTextView;

        public ConstraintLayout solutionTwoLayout;
        public ImageView solutionTwoImageImageView;
        public TextView solutionTwoTitleTextView;
        public TextView solutionTwoSummaryTextView;

        public ConstraintLayout solutionThreeLayout;
        public ImageView solutionThreeImageImageView;
        public TextView solutionThreeTitleTextView;
        public TextView solutionThreeSummaryTextView;

        public ConstraintLayout solutionFourLayout;
        public ImageView solutionFourImageImageView;
        public TextView solutionFourTitleTextView;
        public TextView solutionFourSummaryTextView;

        public ConstraintLayout solutionSimpleOneLayout;
        public TextView solutionSimpleOneTitleTextView;
        public TextView solutionSimpleOneSummaryTextView;

        public ConstraintLayout solutionSimpleTwoLayout;
        public TextView solutionSimpleTwoTitleTextView;
        public TextView solutionSimpleTwoSummaryTextView;

        public ConstraintLayout solutionSimpleThreeLayout;
        public TextView solutionSimpleThreeTitleTextView;
        public TextView solutionSimpleThreeSummaryTextView;

        //Action Widget
        public TextView actionRecommendTopTextView;
        public ConstraintLayout actionSubjectOneLayout;
        public VideoView actionSubjectOneVideoVideoView;
        public TextView actionSubjectOneTitleTextView;
        public TextView actionSubjectOneSummaryTextView;

        //Product Widget
        public TextView productRecommendTopTextView;
        public ConstraintLayout productLevelALayout;
        public TextView productLevelATitleTextView;
        public TextView productLevelASummaryTextView;
        public ImageView productLevelAImageImageView;

        public ConstraintLayout productSubjectSortOneLayout;
        public TextView productSubjectSortOneTitleTextView;
        public TextView productSubjectSortOneSummaryTextView;
        public ImageView productSubjectSortOneLeftImageImageView;
        public ImageView productSubjectSortOneRightImageImageView;

        public ConstraintLayout productSubjectSortTwoLayout;
        public TextView productSubjectSortTwoTitleTextView;
        public TextView productSubjectSortTwoSummaryTextView;
        public ImageView productSubjectSortTwoLeftImageImageView;
        public ImageView productSubjectSortTwoRightImageImageView;

        public ConstraintLayout productSubjectBannerOneLayout;
        public TextView productSubjectBannerOneTitleTextView;
        public Banner productSubjectBannerOneBanner;

        public ConstraintLayout productSubjectBannerTwoLayout;
        public TextView productSubjectBannerTwoTitleTextView;
        public Banner productSubjectBannerTwoBanner;

        public ConstraintLayout productLevelBOneLayout;
        public TextView productLevelBOneTitleTextView;
        public ImageView productLevelBOneImageImageView;

        public ConstraintLayout productLevelBTwoLayout;
        public TextView productLevelBTwoTitleTextView;
        public ImageView productLevelBTwoImageImageView;

        public ConstraintLayout productLevelBThreeLayout;
        public TextView productLevelBThreeTitleTextView;
        public ImageView productLevelBThreeImageImageView;

        public ConstraintLayout productLevelBFourLayout;
        public TextView productLevelBFourTitleTextView;
        public ImageView productLevelBFourImageImageView;

        public WrapperVH(View view) {
            super(view);
        }

        public WrapperVH(View view, ITEM_TYPE item_type) {
            this(view);
            if (item_type == ITEM_TYPE.BANNER) {
                choicenessBanner = view.findViewById(R.id.recommend_Choiceness_Banner_Banner);
            } else if (item_type == ITEM_TYPE.SOLUTION) {
                solutionRecommendTopTextView = view.findViewById(R.id.recommend_Choiceness_Solution_Header_Divider_RecommendTop);

                solutionSortOneLayout = view.findViewById(R.id.recommend_Choiceness_Solution_Sort_One_Layout);
                solutionSortOneTitleTextView = view.findViewById(R.id.recommend_Choiceness_Solution_Sort_One_Title);
                solutionSortOneSummaryTextView = view.findViewById(R.id.recommend_Choiceness_Solution_Sort_One_Summary);
                solutionSortOneLeftImageImageView = view.findViewById(R.id.recommend_Choiceness_Solution_Sort_One_Left_Image);
                solutionSortOneRightImageImageView = view.findViewById(R.id.recommend_Choiceness_Solution_Sort_One_Right_Image);

                solutionSortTwoLayout = view.findViewById(R.id.recommend_Choiceness_Solution_Sort_Two_Layout);
                solutionSortTwoTitleTextView = view.findViewById(R.id.recommend_Choiceness_Solution_Sort_Two_Title);
                solutionSortTwoSummaryTextView = view.findViewById(R.id.recommend_Choiceness_Solution_Sort_Two_Summary);
                solutionSortTwoLeftImageImageView = view.findViewById(R.id.recommend_Choiceness_Solution_Sort_Two_Left_Image);
                solutionSortTwoRightImageImageView = view.findViewById(R.id.recommend_Choiceness_Solution_Sort_Two_Right_Image);

                solutionSortThreeLayout = view.findViewById(R.id.recommend_Choiceness_Solution_Sort_Three_Layout);
                solutionSortThreeTitleTextView = view.findViewById(R.id.recommend_Choiceness_Solution_Sort_Three_Title);
                solutionSortThreeSummaryTextView = view.findViewById(R.id.recommend_Choiceness_Solution_Sort_Three_Summary);
                solutionSortThreeLeftImageImageView = view.findViewById(R.id.recommend_Choiceness_Solution_Sort_Three_Left_Image);
                solutionSortThreeRightImageImageView = view.findViewById(R.id.recommend_Choiceness_Solution_Sort_Three_Right_Image);

                solutionSortFourLayout = view.findViewById(R.id.recommend_Choiceness_Solution_Sort_Four_Layout);
                solutionSortFourTitleTextView = view.findViewById(R.id.recommend_Choiceness_Solution_Sort_Four_Title);
                solutionSortFourSummaryTextView = view.findViewById(R.id.recommend_Choiceness_Solution_Sort_Four_Summary);
                solutionSortFourLeftImageImageView = view.findViewById(R.id.recommend_Choiceness_Solution_Sort_Four_Left_Image);
                solutionSortFourRightImageImageView = view.findViewById(R.id.recommend_Choiceness_Solution_Sort_Four_Right_Image);

                solutionSubjectOneLayout = view.findViewById(R.id.recommend_Choiceness_Solution_Subject_One_Layout);
                solutionSubjectOneVideoVideoView = view.findViewById(R.id.recommend_Choiceness_Solution_Subject_One_Video);
                solutionSubjectOneTitleTextView = view.findViewById(R.id.recommend_Choiceness_Solution_Subject_One_Title);
                solutionSubjectOneSummaryTextView = view.findViewById(R.id.recommend_Choiceness_Solution_Subject_One_Summary);

                solutionOneLayout = view.findViewById(R.id.recommend_Choiceness_Solution_One_Layout);
                solutionOneImageImageView = view.findViewById(R.id.recommend_Choiceness_Solution_One_Image);
                solutionOneTitleTextView = view.findViewById(R.id.recommend_Choiceness_Solution_One_Title);
                solutionOneSummaryTextView = view.findViewById(R.id.recommend_Choiceness_Solution_One_Summary);

                solutionTwoLayout = view.findViewById(R.id.recommend_Choiceness_Solution_Two_Layout);
                solutionTwoImageImageView = view.findViewById(R.id.recommend_Choiceness_Solution_Two_Image);
                solutionTwoTitleTextView = view.findViewById(R.id.recommend_Choiceness_Solution_Two_Title);
                solutionTwoSummaryTextView = view.findViewById(R.id.recommend_Choiceness_Solution_Two_Summary);

                solutionThreeLayout = view.findViewById(R.id.recommend_Choiceness_Solution_Three_Layout);
                solutionThreeImageImageView = view.findViewById(R.id.recommend_Choiceness_Solution_Three_Image);
                solutionThreeTitleTextView = view.findViewById(R.id.recommend_Choiceness_Solution_Three_Title);
                solutionThreeSummaryTextView = view.findViewById(R.id.recommend_Choiceness_Solution_Three_Summary);

                solutionFourLayout = view.findViewById(R.id.recommend_Choiceness_Solution_Four_Layout);
                solutionFourImageImageView = view.findViewById(R.id.recommend_Choiceness_Solution_Four_Image);
                solutionFourTitleTextView = view.findViewById(R.id.recommend_Choiceness_Solution_Four_Title);
                solutionFourSummaryTextView = view.findViewById(R.id.recommend_Choiceness_Solution_Four_Summary);

                solutionSimpleOneLayout = view.findViewById(R.id.recommend_Choiceness_Solution_Simple_One_Layout);
                solutionSimpleOneTitleTextView = view.findViewById(R.id.recommend_Choiceness_Solution_Simple_One_Title);
                solutionSimpleOneSummaryTextView = view.findViewById(R.id.recommend_Choiceness_Solution_Simple_One_Summary);

                solutionSimpleTwoLayout = view.findViewById(R.id.recommend_Choiceness_Solution_Simple_Two_Layout);
                solutionSimpleTwoTitleTextView = view.findViewById(R.id.recommend_Choiceness_Solution_Simple_Two_Title);
                solutionSimpleTwoSummaryTextView = view.findViewById(R.id.recommend_Choiceness_Solution_Simple_Two_Summary);

                solutionSimpleThreeLayout = view.findViewById(R.id.recommend_Choiceness_Solution_Simple_Three_Layout);
                solutionSimpleThreeTitleTextView = view.findViewById(R.id.recommend_Choiceness_Solution_Simple_Three_Title);
                solutionSimpleThreeSummaryTextView = view.findViewById(R.id.recommend_Choiceness_Solution_Simple_Three_Summary);
            } else if (item_type == ITEM_TYPE.ACTION_SUBJECT) {
                actionRecommendTopTextView = view.findViewById(R.id.recommend_Choiceness_Action_Header_Divider_RecommendTop);
                actionSubjectOneLayout = view.findViewById(R.id.recommend_Choiceness_Action_Subject_One_Layout);
                actionSubjectOneVideoVideoView = view.findViewById(R.id.recommend_Choiceness_Action_Subject_One_Video);
                actionSubjectOneTitleTextView = view.findViewById(R.id.recommend_Choiceness_Action_Subject_One_Title);
                actionSubjectOneSummaryTextView = view.findViewById(R.id.recommend_Choiceness_Action_Subject_One_Summary);
            } else if (item_type == ITEM_TYPE.PRODUCT) {
                productRecommendTopTextView = view.findViewById(R.id.recommend_Choiceness_Product_Header_Divider_RecommendTop);
                productLevelALayout = view.findViewById(R.id.recommend_Choiceness_Product_Level_A_Layout);
                productLevelATitleTextView = view.findViewById(R.id.recommend_Choiceness_Product_Level_A_Title);
                productLevelASummaryTextView = view.findViewById(R.id.recommend_Choiceness_Product_Level_A_Summary);
                productLevelAImageImageView = view.findViewById(R.id.recommend_Choiceness_Product_Level_A_Image);

                productSubjectSortOneLayout = view.findViewById(R.id.recommend_Choiceness_Product_Subject_Sort_One_Layout);
                productSubjectSortOneTitleTextView = view.findViewById(R.id.recommend_Choiceness_Product_Subject_Sort_One_Title);
                productSubjectSortOneSummaryTextView = view.findViewById(R.id.recommend_Choiceness_Product_Subject_Sort_One_Summary);
                productSubjectSortOneLeftImageImageView = view.findViewById(R.id.recommend_Choiceness_Product_Subject_Sort_One_Left_Image);
                productSubjectSortOneRightImageImageView = view.findViewById(R.id.recommend_Choiceness_Product_Subject_Sort_One_Right_Image);

                productSubjectSortTwoLayout = view.findViewById(R.id.recommend_Choiceness_Product_Subject_Sort_Two_Layout);
                productSubjectSortTwoTitleTextView = view.findViewById(R.id.recommend_Choiceness_Product_Subject_Sort_Two_Title);
                productSubjectSortTwoSummaryTextView = view.findViewById(R.id.recommend_Choiceness_Product_Subject_Sort_Two_Summary);
                productSubjectSortTwoLeftImageImageView = view.findViewById(R.id.recommend_Choiceness_Product_Subject_Sort_Two_Left_Image);
                productSubjectSortTwoRightImageImageView = view.findViewById(R.id.recommend_Choiceness_Product_Subject_Sort_Two_Right_Image);

                productSubjectBannerOneLayout = view.findViewById(R.id.recommend_Choiceness_Product_Subject_Banner_One_Layout);
                productSubjectBannerOneTitleTextView = view.findViewById(R.id.recommend_Choiceness_Product_Subject_Banner_One_Title);
                productSubjectBannerOneBanner = view.findViewById(R.id.recommend_Choiceness_Product_Subject_Banner_One_Banner);

                productSubjectBannerTwoLayout = view.findViewById(R.id.recommend_Choiceness_Product_Subject_Banner_Two_Layout);
                productSubjectBannerTwoTitleTextView = view.findViewById(R.id.recommend_Choiceness_Product_Subject_Banner_Two_Title);
                productSubjectBannerTwoBanner = view.findViewById(R.id.recommend_Choiceness_Product_Subject_Banner_Two_Banner);

                productLevelBOneLayout = view.findViewById(R.id.recommend_Choiceness_Product_Level_B_One_Layout);
                productLevelBOneTitleTextView = view.findViewById(R.id.recommend_Choiceness_Product_Level_B_One_Title);
                productLevelBOneImageImageView = view.findViewById(R.id.recommend_Choiceness_Product_Level_B_One_Image);

                productLevelBTwoLayout = view.findViewById(R.id.recommend_Choiceness_Product_Level_B_Two_Layout);
                productLevelBTwoTitleTextView = view.findViewById(R.id.recommend_Choiceness_Product_Level_B_Two_Title);
                productLevelBTwoImageImageView = view.findViewById(R.id.recommend_Choiceness_Product_Level_B_Two_Image);

                productLevelBThreeLayout = view.findViewById(R.id.recommend_Choiceness_Product_Level_B_Three_Layout);
                productLevelBThreeTitleTextView = view.findViewById(R.id.recommend_Choiceness_Product_Level_B_Three_Title);
                productLevelBThreeImageImageView = view.findViewById(R.id.recommend_Choiceness_Product_Level_B_Three_Image);

                productLevelBFourLayout = view.findViewById(R.id.recommend_Choiceness_Product_Level_B_Four_Layout);
                productLevelBFourTitleTextView = view.findViewById(R.id.recommend_Choiceness_Product_Level_B_Four_Title);
                productLevelBFourImageImageView = view.findViewById(R.id.recommend_Choiceness_Product_Level_B_Four_Image);

            }
        }
    }

    private enum ITEM_TYPE {
        BANNER,
        SOLUTION,
        ACTION_SUBJECT,
        ACTION_LIST,
        PRODUCT,
        INTEREST_HEADER,
        INTEREST
    }


    //define interface
    public interface DelegateInterface {
        /**
         * 委派ViewHolder处理事物
         */
        void handleTransaction(Context mContext, MainWrapperAdapter.WrapperVH mHolder, Object mData);
    }
}
