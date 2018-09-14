package itc.ink.unit_android.unit_recyclerview.adapter.adapter_action;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;
import itc.ink.unit_android.R;
import itc.ink.unit_android.unit_recyclerview.mode.mode_action.ActionDataModel;

/**
 * Created by yangwenjiang on 2018/9/14.
 */

public class ActionDataAdapter extends RecyclerView.Adapter<ActionDataAdapter.VH>{
    private Context mContext;
    private List<ActionDataModel> mData;

    public ActionDataAdapter(Context mContext, List<ActionDataModel> mData) {
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
        final ActionDataModel actionDataItem = mData.get(position);
        holder.actionTitleTextView.setText(actionDataItem.actionTitle);
        holder.actionPublicityTextTextView.setText(actionDataItem.actionPublicityText);
        holder.actionDatetimeTextView.setText(actionDataItem.actionDatetime);
        holder.actionSiteTextView.setText(actionDataItem.actionSite);
        holder.actionSummaryTextView.setText(actionDataItem.actionSummary);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,actionDataItem.actionTitle+"被点击",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class VH extends RecyclerView.ViewHolder{
        public TextView actionTitleTextView;
        public TextView actionPublicityTextTextView;
        public TextView actionDatetimeTextView;
        public TextView actionSiteTextView;
        public TextView actionSummaryTextView;
        public VH(View view) {
            super(view);
            actionTitleTextView = (TextView) view.findViewById(R.id.recommend_Choiceness_Action_ListItem_Title);
            actionPublicityTextTextView = (TextView) view.findViewById(R.id.recommend_Choiceness_Action_ListItem_PublicityText);
            actionDatetimeTextView = (TextView) view.findViewById(R.id.recommend_Choiceness_Action_ListItem_Datetime);
            actionSiteTextView = (TextView) view.findViewById(R.id.recommend_Choiceness_Action_ListItem_Site);
            actionSummaryTextView = (TextView) view.findViewById(R.id.recommend_Choiceness_Action_ListItem_Summary);
        }
    }
}
