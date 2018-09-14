package itc.ink.unit_android.unit_recyclerview.adapter.implement;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import itc.ink.unit_android.unit_recyclerview.adapter.MainWrapperAdapter;

/**
 * Created by yangwenjiang on 2018/9/14.
 */

public class ActionDelegateImplement implements MainWrapperAdapter.DelegateInterface {
    private Context mContext;
    @Override
    public void handleClickTransaction(Context mContext, MainWrapperAdapter.WrapperVH holder) {
        this.mContext=mContext;
        holder.actionRecommendTopTextView.setOnClickListener(new ActionRecommendTopTextViewClickListener());
        holder.actionSubjectOneLayout.setOnClickListener(new ActionSubjectOneLayoutClickListener());
    }

    class ActionRecommendTopTextViewClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(mContext,"活动推荐榜单被点击",Toast.LENGTH_SHORT).show();
        }
    }

    class ActionSubjectOneLayoutClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(mContext,"活动专题被点击",Toast.LENGTH_SHORT).show();
        }
    }
}
