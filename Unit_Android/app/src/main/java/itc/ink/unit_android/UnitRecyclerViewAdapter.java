package itc.ink.unit_android;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

import itc.ink.unit_android.unit_activity.GlideActivity;
import itc.ink.unit_android.unit_activity.PermissionActivity;

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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_list_item, parent, false);
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
                    case "Glide":
                        intent.setClass(mContext, GlideActivity.class);
                        break;
                    case "动态权限获取":
                        intent.setClass(mContext, PermissionActivity.class);
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
