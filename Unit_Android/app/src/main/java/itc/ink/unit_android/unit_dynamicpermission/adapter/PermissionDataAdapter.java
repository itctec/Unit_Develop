package itc.ink.unit_android.unit_dynamicpermission.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

import itc.ink.unit_android.R;

/**
 * Created by yangwenjiang on 2018/9/7.
 */

public class PermissionDataAdapter extends RecyclerView.Adapter<PermissionDataAdapter.PermissionViewHolder> implements View.OnClickListener{

    private List<String> mData;
    private Activity mActivity;
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    public PermissionDataAdapter(List<String> mData, Activity mActivity) {

        this.mData = mData;
        this.mActivity=mActivity;

    }


    @Override
    public PermissionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.unit_permission_list_item, parent, false);
        return new PermissionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PermissionViewHolder holder, final int position) {
        holder.permissionBtn.setText(mData.get(position));
        holder.permissionBtn.setTag(mData.get(position));
        holder.permissionBtn.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onClick(View view) {
        mOnItemClickListener.onItemClick(view,(String)view.getTag());
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public static class PermissionViewHolder extends RecyclerView.ViewHolder{

        public final Button permissionBtn;

        public PermissionViewHolder(View v) {
            super(v);
            permissionBtn=v.findViewById(R.id.permissionBtn);
        }
    }

    //define interface
    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, String data);
    }

}
