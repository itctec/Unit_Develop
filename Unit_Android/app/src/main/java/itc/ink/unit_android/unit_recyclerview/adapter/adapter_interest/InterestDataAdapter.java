package itc.ink.unit_android.unit_recyclerview.adapter.adapter_interest;

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
import itc.ink.unit_android.unit_recyclerview.mode.mode_interest.InterestDataModel;

/**
 * Created by yangwenjiang on 2018/9/14.
 */

public class InterestDataAdapter extends RecyclerView.Adapter<InterestDataAdapter.VH> {
    private Context mContext;
    private List<InterestDataModel> mData;

    public InterestDataAdapter(Context mContext, List<InterestDataModel> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.unit_recyclerview_interest_list_item, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(VH holder, final int position) {
        final InterestDataModel interestDataItem = mData.get(position);
        holder.interestTitleTextView.setText(interestDataItem.interestTitle);
        holder.interestSummaryTextTextView.setText(interestDataItem.interestSummary);
        holder.interestSupportNumTextView.setText(interestDataItem.interestSupportNum);
        RequestOptions options = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.NONE);
        Glide.with(mContext).load(interestDataItem.interestImageUrl).apply(options).into(holder.interestListItemImageImageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, interestDataItem.interestTitle + "被点击", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class VH extends MainWrapperAdapter.WrapperVH {
        public TextView interestTitleTextView;
        public TextView interestSummaryTextTextView;
        public TextView interestSupportNumTextView;
        public ImageView interestListItemImageImageView;

        public VH(View view) {
            super(view);
            interestTitleTextView = view.findViewById(R.id.recommend_Choiceness_Interest_ListItem_Title);
            interestSummaryTextTextView = view.findViewById(R.id.recommend_Choiceness_Interest_ListItem_Summary);
            interestSupportNumTextView = view.findViewById(R.id.recommend_Choiceness_Interest_ListItem_SupportNum);
            interestListItemImageImageView = view.findViewById(R.id.recommend_Choiceness_Interest_ListItem_Image);
        }
    }
}
