package itc.ink.unit_android.unit_navigatoinbar.core;

import android.content.Context;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import itc.ink.unit_android.R;
import itc.ink.unit_android.unit_navigatoinbar.mode.DataLoad;

/**
 * Created by yangwenjiang on 2018/9/19.
 */

public class ScrollableNavigationBar extends ConstraintLayout {
    private LinearLayout professionNavigationBarLayout;

    private DataLoad mDataLoad;
    private ArrayList<String> mProfessionSortTitleData;

    private OutCallBack mOutCallBack;

    public ScrollableNavigationBar(Context context) {
        this(context, null);
    }

    public ScrollableNavigationBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScrollableNavigationBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.unit_navigationbar_top_scrollable, this);

        professionNavigationBarLayout = findViewById(R.id.profession_NavigationBar_Layout);

        mDataLoad = new DataLoad();
        mProfessionSortTitleData = (ArrayList<String>) mDataLoad.outService.loadProfessionSortData(context);

        for (int i = 0; i < mProfessionSortTitleData.size(); i++) {
            TextView titleItemTextView = new TextView(context);
            titleItemTextView.setText(mProfessionSortTitleData.get(i));
            titleItemTextView.setTextColor(Color.GRAY);
            titleItemTextView.setGravity(Gravity.CENTER);
            LinearLayout.LayoutParams titleItemLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);

            if (i == 0) {
                titleItemTextView.setBackgroundResource(R.drawable.top_second_navigation_bar_bottom_line);
                titleItemTextView.setTextColor(Color.BLACK);
            }
            titleItemTextView.setPadding(30, 0, 30, 0);

            titleItemTextView.setLayoutParams(titleItemLayoutParams);
            titleItemTextView.setOnClickListener(new titleItemTextViewClickListener());
            professionNavigationBarLayout.addView(titleItemTextView);
        }
    }

    public void setCallBack(OutCallBack mOutCallBack) {
        this.mOutCallBack = mOutCallBack;
    }

    class titleItemTextViewClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            for (int i = 0; i < professionNavigationBarLayout.getChildCount(); i++) {
                TextView titleItemTextView = (TextView) professionNavigationBarLayout.getChildAt(i);
                titleItemTextView.setTextColor(Color.GRAY);
                titleItemTextView.setBackgroundResource(R.drawable.top_second_navigation_bar_bottom_line_empty);
                titleItemTextView.setPadding(30, 0, 30, 0);
            }
            TextView titleItemTextView = (TextView) view;
            titleItemTextView.setTextColor(Color.BLACK);
            titleItemTextView.setBackgroundResource(R.drawable.top_second_navigation_bar_bottom_line);
            titleItemTextView.setPadding(30, 0, 30, 0);

            mOutCallBack.onTitleClick(titleItemTextView.getText().toString());
        }
    }

    public interface OutCallBack {
        void onTitleClick(String titleStr);
    }
}
