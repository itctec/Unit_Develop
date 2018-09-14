package itc.ink.unit_android.unit_recyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import itc.ink.unit_android.R;
import itc.ink.unit_android.unit_recyclerview.adapter.adapter_action.ActionDataAdapter;
import itc.ink.unit_android.unit_recyclerview.adapter.adapter_interest.InterestDataAdapter;

/**
 * Created by yangwenjiang on 2018/9/14.
 */

public class MainWrapperAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ActionDataAdapter mActionDataAdapter;
    private InterestDataAdapter mAdapter;

    public MainWrapperAdapter(ActionDataAdapter mActionDataAdapter, InterestDataAdapter adapter) {
        this.mActionDataAdapter = mActionDataAdapter;
        mAdapter = adapter;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == ITEM_TYPE.BANNER.ordinal()){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.unit_recyclerview_banner_item, parent, false);
            return new RecyclerView.ViewHolder(view){
            };
        }else if(viewType == ITEM_TYPE.SOLUTION.ordinal()){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.unit_recyclerview_solution_item, parent, false);
            return new RecyclerView.ViewHolder(view){
            };
        }else if(viewType == ITEM_TYPE.ACTION_SUBJECT.ordinal()){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.unit_recyclerview_action_item, parent, false);
            return new RecyclerView.ViewHolder(view){
            };
        }else if(viewType == ITEM_TYPE.ACTION_LIST.ordinal()){
            return mActionDataAdapter.onCreateViewHolder(parent, viewType);
        }else if(viewType == ITEM_TYPE.PRODUCT.ordinal()){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.unit_recyclerview_product_item, parent, false);
            return new RecyclerView.ViewHolder(view){
            };
        }else if(viewType == ITEM_TYPE.INTEREST_HEADER.ordinal()) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.unit_recyclerview_interest_header_item, parent, false);
            return new RecyclerView.ViewHolder(view){
            };
        }else{
            return mAdapter.onCreateViewHolder(parent, viewType);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(position == 0){
            return;
        }else if(position == 1){
            return;
        }else if(position == 2){
            return;
        }else if(position > 2 && position < (mActionDataAdapter.getItemCount() + 3)){
            mActionDataAdapter.onBindViewHolder(((ActionDataAdapter.VH) holder), position - 3);
        }else if(position == (mActionDataAdapter.getItemCount() + 3)){
            return;
        }else if(position == (mActionDataAdapter.getItemCount() + 4)){
            return;
        }else{
            mAdapter.onBindViewHolder(((InterestDataAdapter.VH) holder), position - (mActionDataAdapter.getItemCount() + 5));
        }
    }

    @Override
    public int getItemCount() {
        return mActionDataAdapter.getItemCount() + mAdapter.getItemCount() + 5;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return ITEM_TYPE.BANNER.ordinal();
        }else if(position == 1){
            return ITEM_TYPE.SOLUTION.ordinal();
        }else if(position == 2){
            return ITEM_TYPE.ACTION_SUBJECT.ordinal();
        }else if(position > 2 && position < (mActionDataAdapter.getItemCount() + 3)){
            return ITEM_TYPE.ACTION_LIST.ordinal();
        }else if(position == (mActionDataAdapter.getItemCount() + 3)){
            return ITEM_TYPE.PRODUCT.ordinal();
        }else if(position == (mActionDataAdapter.getItemCount() + 4)){
            return ITEM_TYPE.INTEREST_HEADER.ordinal();
        }else{
            return ITEM_TYPE.INTEREST.ordinal();
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
}
