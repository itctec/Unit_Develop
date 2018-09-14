package itc.ink.unit_android.unit_recyclerview.adapter;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import itc.ink.unit_android.R;
import itc.ink.unit_android.unit_recyclerview.adapter.adapter_action.ActionDataAdapter;
import itc.ink.unit_android.unit_recyclerview.adapter.adapter_interest.InterestDataAdapter;
import itc.ink.unit_android.unit_recyclerview.adapter.implement.ActionDelegateImplement;
import itc.ink.unit_android.unit_recyclerview.adapter.implement.BannerDelegateImplement;
import itc.ink.unit_android.unit_recyclerview.adapter.implement.ProductDelegateImplement;
import itc.ink.unit_android.unit_recyclerview.adapter.implement.SolutionDelegateImplement;

/**
 * Created by yangwenjiang on 2018/9/14.
 */

public class MainWrapperAdapter extends RecyclerView.Adapter<MainWrapperAdapter.WrapperVH> {

    private Context mContext;
    private ActionDataAdapter mActionDataAdapter;
    private InterestDataAdapter mInterestDataAdapter;
    private DelegateInterface mDelegateInterface;

    public MainWrapperAdapter(Context mContext, ActionDataAdapter mActionDataAdapter, InterestDataAdapter mInterestDataAdapter) {
        this.mContext = mContext;
        this.mActionDataAdapter = mActionDataAdapter;
        this.mInterestDataAdapter = mInterestDataAdapter;
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
            mDelegateInterface.handleClickTransaction(mContext, holder);
            return;
        } else if (position == 1) {
            mDelegateInterface = new SolutionDelegateImplement();
            mDelegateInterface.handleClickTransaction(mContext, holder);
            return;
        } else if (position == 2) {
            mDelegateInterface = new ActionDelegateImplement();
            mDelegateInterface.handleClickTransaction(mContext, holder);
            return;
        } else if (position > 2 && position < (mActionDataAdapter.getItemCount() + 3)) {
            mActionDataAdapter.onBindViewHolder(((ActionDataAdapter.VH) holder), position - 3);
        } else if (position == (mActionDataAdapter.getItemCount() + 3)) {
            mDelegateInterface = new ProductDelegateImplement();
            mDelegateInterface.handleClickTransaction(mContext, holder);
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
        public ImageView choicenessBannerImageView;

        //Solution Widget
        public TextView solutionRecommendTopTextView;
        public ConstraintLayout solutionSortOneLayout;
        public ConstraintLayout solutionSortTwoLayout;
        public ConstraintLayout solutionSortThreeLayout;
        public ConstraintLayout solutionSortFourLayout;
        public ConstraintLayout solutionSubjectOneLayout;
        public ConstraintLayout solutionOneLayout;
        public ConstraintLayout solutionTwoLayout;
        public ConstraintLayout solutionThreeLayout;
        public ConstraintLayout solutionFourLayout;
        public ConstraintLayout solutionSimpleOneLayout;
        public ConstraintLayout solutionSimpleTwoLayout;
        public ConstraintLayout solutionSimpleThreeLayout;

        //Action Widget
        public TextView actionRecommendTopTextView;
        public ConstraintLayout actionSubjectOneLayout;

        //Product Widget
        public TextView productRecommendTopTextView;
        public ConstraintLayout productLevelALayout;
        public ConstraintLayout productSubjectSortOneLayout;
        public ConstraintLayout productSubjectSortTwoLayout;
        public ConstraintLayout productSubjectBannerOneLayout;
        public ConstraintLayout productSubjectBannerTwoLayout;
        public ConstraintLayout productLevelBOneLayout;
        public ConstraintLayout productLevelBTwoLayout;
        public ConstraintLayout productLevelBThreeLayout;
        public ConstraintLayout productLevelBFourLayout;

        public WrapperVH(View view) {
            super(view);
        }

        public WrapperVH(View view, ITEM_TYPE item_type) {
            this(view);
            if (item_type == ITEM_TYPE.BANNER) {
                choicenessBannerImageView = view.findViewById(R.id.recommend_Choiceness_Banner_Image);
            } else if (item_type == ITEM_TYPE.SOLUTION) {
                solutionRecommendTopTextView = view.findViewById(R.id.recommend_Choiceness_Solution_Header_Divider_RecommendTop);
                solutionSortOneLayout = view.findViewById(R.id.recommend_Choiceness_Solution_Sort_One_Layout);
                solutionSortTwoLayout = view.findViewById(R.id.recommend_Choiceness_Solution_Sort_Two_Layout);
                solutionSortThreeLayout = view.findViewById(R.id.recommend_Choiceness_Solution_Sort_Three_Layout);
                solutionSortFourLayout = view.findViewById(R.id.recommend_Choiceness_Solution_Sort_Four_Layout);
                solutionSubjectOneLayout = view.findViewById(R.id.recommend_Choiceness_Solution_Subject_One_Layout);
                solutionOneLayout = view.findViewById(R.id.recommend_Choiceness_Solution_One_Layout);
                solutionTwoLayout = view.findViewById(R.id.recommend_Choiceness_Solution_Two_Layout);
                solutionThreeLayout = view.findViewById(R.id.recommend_Choiceness_Solution_Three_Layout);
                solutionFourLayout = view.findViewById(R.id.recommend_Choiceness_Solution_Four_Layout);
                solutionSimpleOneLayout = view.findViewById(R.id.recommend_Choiceness_Solution_Simple_One_Layout);
                solutionSimpleTwoLayout = view.findViewById(R.id.recommend_Choiceness_Solution_Simple_Two_Layout);
                solutionSimpleThreeLayout = view.findViewById(R.id.recommend_Choiceness_Solution_Simple_Three_Layout);
            } else if (item_type == ITEM_TYPE.ACTION_SUBJECT) {
                actionRecommendTopTextView = view.findViewById(R.id.recommend_Choiceness_Action_Header_Divider_RecommendTop);
                actionSubjectOneLayout = view.findViewById(R.id.recommend_Choiceness_Action_Subject_One_Layout);
            } else if (item_type == ITEM_TYPE.PRODUCT) {
                productRecommendTopTextView = view.findViewById(R.id.recommend_Choiceness_Product_Header_Divider_RecommendTop);
                productLevelALayout = view.findViewById(R.id.recommend_Choiceness_Product_Level_A_Layout);
                productSubjectSortOneLayout = view.findViewById(R.id.recommend_Choiceness_Product_Subject_Sort_One_Layout);
                productSubjectSortTwoLayout = view.findViewById(R.id.recommend_Choiceness_Product_Subject_Sort_Two_Layout);
                productSubjectBannerOneLayout = view.findViewById(R.id.recommend_Choiceness_Product_Subject_Banner_One_Layout);
                productSubjectBannerTwoLayout = view.findViewById(R.id.recommend_Choiceness_Product_Subject_Banner_Two_Layout);
                productLevelBOneLayout = view.findViewById(R.id.recommend_Choiceness_Product_Level_B_One_Layout);
                productLevelBTwoLayout = view.findViewById(R.id.recommend_Choiceness_Product_Level_B_Two_Layout);
                productLevelBThreeLayout = view.findViewById(R.id.recommend_Choiceness_Product_Level_B_Three_Layout);
                productLevelBFourLayout = view.findViewById(R.id.recommend_Choiceness_Product_Level_B_Four_Layout);

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
        void handleClickTransaction(Context mContext, MainWrapperAdapter.WrapperVH holder);
    }
}
