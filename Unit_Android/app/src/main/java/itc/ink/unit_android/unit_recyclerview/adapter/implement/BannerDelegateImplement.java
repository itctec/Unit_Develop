package itc.ink.unit_android.unit_recyclerview.adapter.implement;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import itc.ink.unit_android.unit_recyclerview.adapter.MainWrapperAdapter;

/**
 * Created by yangwenjiang on 2018/9/14.
 */

public class BannerDelegateImplement implements MainWrapperAdapter.DelegateInterface {
    private Context mContext;
    @Override
    public void handleClickTransaction(Context mContext, MainWrapperAdapter.WrapperVH holder) {
        this.mContext=mContext;
        holder.choicenessBannerImageView.setOnClickListener(new ChoicenessBannerImageViewClickListener());
    }

    class ChoicenessBannerImageViewClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(mContext,"ChoicenessBanner被点击",Toast.LENGTH_SHORT).show();
        }
    }
}
