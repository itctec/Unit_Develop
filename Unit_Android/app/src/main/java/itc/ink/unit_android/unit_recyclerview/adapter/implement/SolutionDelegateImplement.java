package itc.ink.unit_android.unit_recyclerview.adapter.implement;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import itc.ink.unit_android.unit_recyclerview.adapter.MainWrapperAdapter;

/**
 * Created by yangwenjiang on 2018/9/14.
 */

public class SolutionDelegateImplement implements MainWrapperAdapter.DelegateInterface {
    private Context mContext;
    @Override
    public void handleClickTransaction(Context mContext, MainWrapperAdapter.WrapperVH holder) {
        this.mContext=mContext;
        holder.solutionRecommendTopTextView.setOnClickListener(new SolutionRecommendTopTextViewClickListener());
        holder.solutionSortOneLayout.setOnClickListener(new SolutionSortOneLayoutClickListener());
        holder.solutionSortTwoLayout.setOnClickListener(new SolutionSortTwoLayoutClickListener());
        holder.solutionSortThreeLayout.setOnClickListener(new SolutionSortThreeLayoutClickListener());
        holder.solutionSortFourLayout.setOnClickListener(new SolutionSortFourLayoutClickListener());
        holder.solutionSubjectOneLayout.setOnClickListener(new SolutionSubjectOneLayoutClickListener());
        holder.solutionOneLayout.setOnClickListener(new SolutionOneLayoutClickListener());
        holder.solutionTwoLayout.setOnClickListener(new SolutionTwoLayoutClickListener());
        holder.solutionThreeLayout.setOnClickListener(new SolutionThreeLayoutClickListener());
        holder.solutionFourLayout.setOnClickListener(new SolutionFourLayoutClickListener());
        holder.solutionSimpleOneLayout.setOnClickListener(new SolutionSimpleOneLayoutClickListener());
        holder.solutionSimpleTwoLayout.setOnClickListener(new SolutionSimpleTwoLayoutClickListener());
        holder.solutionSimpleThreeLayout.setOnClickListener(new SolutionSimpleThreeLayoutClickListener());
    }

    class SolutionRecommendTopTextViewClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(mContext,"方案推荐榜单被点击",Toast.LENGTH_SHORT).show();
        }
    }

    class SolutionSortOneLayoutClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(mContext,"方案类别1被点击",Toast.LENGTH_SHORT).show();
        }
    }

    class SolutionSortTwoLayoutClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(mContext,"方案类别2被点击",Toast.LENGTH_SHORT).show();
        }
    }

    class SolutionSortThreeLayoutClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(mContext,"方案类别3被点击",Toast.LENGTH_SHORT).show();
        }
    }

    class SolutionSortFourLayoutClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(mContext,"方案类别4被点击",Toast.LENGTH_SHORT).show();
        }
    }

    class SolutionSubjectOneLayoutClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(mContext,"专题方案被点击",Toast.LENGTH_SHORT).show();
        }
    }

    class SolutionOneLayoutClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(mContext,"方案1被点击",Toast.LENGTH_SHORT).show();
        }
    }

    class SolutionTwoLayoutClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(mContext,"方案2被点击",Toast.LENGTH_SHORT).show();
        }
    }

    class SolutionThreeLayoutClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(mContext,"方案3被点击",Toast.LENGTH_SHORT).show();
        }
    }

    class SolutionFourLayoutClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(mContext,"方案4被点击",Toast.LENGTH_SHORT).show();
        }
    }

    class SolutionSimpleOneLayoutClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(mContext,"方案5被点击",Toast.LENGTH_SHORT).show();
        }
    }

    class SolutionSimpleTwoLayoutClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(mContext,"方案6被点击",Toast.LENGTH_SHORT).show();
        }
    }

    class SolutionSimpleThreeLayoutClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(mContext,"方案7被点击",Toast.LENGTH_SHORT).show();
        }
    }
}
