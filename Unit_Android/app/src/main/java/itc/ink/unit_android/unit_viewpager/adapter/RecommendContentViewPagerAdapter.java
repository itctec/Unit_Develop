package itc.ink.unit_android.unit_viewpager.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import itc.ink.unit_android.R;

/**
 * Created by yangwenjiang on 2018/9/18.
 */

public class RecommendContentViewPagerAdapter extends PagerAdapter {
    private Context mContext;
    private ArrayList<String> mContentData;

    public RecommendContentViewPagerAdapter(Context mContext, Object mContentData) {
        this.mContext = mContext;
        this.mContentData = (ArrayList<String>) mContentData;
    }

    @Override
    public int getCount() {
        return mContentData.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = View.inflate(mContext, R.layout.unit_viewpager_content_item, null);
        TextView contentText = (TextView) view.findViewById(R.id.recommend_ViewPager_Content_Text);
        contentText.setText(mContentData.get(position));
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        //super.destroyItem(container, position, object);
        container.removeView((View)object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }
}
