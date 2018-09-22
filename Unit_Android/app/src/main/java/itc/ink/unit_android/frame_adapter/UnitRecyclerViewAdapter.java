package itc.ink.unit_android.frame_adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

import itc.ink.unit_android.R;
import itc.ink.unit_android.unit_glide.activity.MainActivity;

/**
 * Created by yangwenjiang on 2018/9/7.
 */

public class UnitRecyclerViewAdapter extends RecyclerView.Adapter<UnitRecyclerViewAdapter.UnitViewHolder>{

    private List<String> mData;
    private Context mContext;

    public UnitRecyclerViewAdapter(List<String> mData, Context mContext) {

        this.mData = mData;
        this.mContext=mContext;
    }

    @Override
    public UnitViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fram_main_list_item, parent, false);
        return new UnitViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UnitViewHolder holder, final int position) {
        holder.unitBtn.setText(mData.get(position));
        holder.unitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();

                switch(mData.get(position)){
                    case "Dynamic Permission Get":
                        intent.setClass(mContext, itc.ink.unit_android.unit_dynamicpermission.activity.MainActivity.class);
                        break;
                    case "NavigationBar":
                        intent.setClass(mContext, itc.ink.unit_android.unit_navigatoinbar.activity.MainActivity.class);
                        break;
                    case "Glide":
                        intent.setClass(mContext, MainActivity.class);
                        break;
                    case "RecyclerView":
                        intent.setClass(mContext, itc.ink.unit_android.unit_recyclerview.activity.MainActivity.class);
                        break;
                    case "ViewPager":
                        intent.setClass(mContext, itc.ink.unit_android.unit_viewpager.activity.MainActivity.class);
                        break;
                    case "Fragment":
                        intent.setClass(mContext, itc.ink.unit_android.unit_fragment.activity.MainActivity.class);
                        break;
                    case "AliPay":
                        intent.setClass(mContext, itc.ink.unit_android.unit_alipay.activity.MainActivity.class);
                        break;
                    case "App Version Update":
                        intent.setClass(mContext, itc.ink.unit_android.unit_selfupdate.activity.MainActivity.class);
                        break;
                    case "JSON":
                        intent.setClass(mContext, itc.ink.unit_android.unit_json.activity.MainActivity.class);
                        break;
                }

                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public static class UnitViewHolder extends RecyclerView.ViewHolder{

        public final Button unitBtn;

        public UnitViewHolder(View v) {
            super(v);
            unitBtn=v.findViewById(R.id.unitBtn);
        }
    }
}
