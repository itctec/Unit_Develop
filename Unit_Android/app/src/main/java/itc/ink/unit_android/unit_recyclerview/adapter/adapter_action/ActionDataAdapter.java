package itc.ink.unit_android.unit_recyclerview.adapter.adapter_action;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;
import itc.ink.unit_android.R;
import itc.ink.unit_android.unit_recyclerview.adapter.MainWrapperAdapter;
import itc.ink.unit_android.unit_recyclerview.mode.mode_action.ActionListDataModel;

/**
 * Created by yangwenjiang on 2018/9/14.
 */

public class ActionDataAdapter extends RecyclerView.Adapter<ActionDataAdapter.VH>{
    private Context mContext;
    private List<ActionListDataModel> mData;

    public ActionDataAdapter(Context mContext, List<ActionListDataModel> mData) {
        this.mContext=mContext;
        this.mData = mData;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.unit_recyclerview_action_list_item, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(VH holder, final int position) {
        final ActionListDataModel actionDataItem = mData.get(position);
        holder.actionTitleTextView.setText(actionDataItem.actionTitle);
        holder.actionPublicityTextTextView.setText(actionDataItem.actionPublicityText);
        holder.actionDatetimeTextView.setText(actionDataItem.actionDatetime);
        holder.actionSiteTextView.setText(actionDataItem.actionSite);
        holder.actionSummaryTextView.setText(actionDataItem.actionSummary);
        RequestOptions options = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.NONE);
        Glide.with(mContext).load(actionDataItem.actionImageUrl).apply(options).into(holder.actionImageImageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,actionDataItem.actionTitle+"被点击",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class VH extends MainWrapperAdapter.WrapperVH{
        public TextView actionTitleTextView;
        public TextView actionPublicityTextTextView;
        public TextView actionDatetimeTextView;
        public TextView actionSiteTextView;
        public TextView actionSummaryTextView;
        public ImageView actionImageImageView;
        public VH(View view) {
            super(view);
            actionTitleTextView = view.findViewById(R.id.recommend_Choiceness_Action_ListItem_Title);
            actionPublicityTextTextView = view.findViewById(R.id.recommend_Choiceness_Action_ListItem_PublicityText);
            actionDatetimeTextView = view.findViewById(R.id.recommend_Choiceness_Action_ListItem_Datetime);
            actionSiteTextView = view.findViewById(R.id.recommend_Choiceness_Action_ListItem_Site);
            actionSummaryTextView = view.findViewById(R.id.recommend_Choiceness_Action_ListItem_Summary);
            actionImageImageView = view.findViewById(R.id.recommend_Choiceness_Action_ListItem_Image);
        }
    }
}
