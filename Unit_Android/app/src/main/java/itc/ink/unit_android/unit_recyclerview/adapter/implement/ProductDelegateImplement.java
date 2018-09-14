package itc.ink.unit_android.unit_recyclerview.adapter.implement;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import itc.ink.unit_android.unit_recyclerview.adapter.MainWrapperAdapter;

/**
 * Created by yangwenjiang on 2018/9/14.
 */

public class ProductDelegateImplement implements MainWrapperAdapter.DelegateInterface {
    private Context mContext;
    @Override
    public void handleClickTransaction(Context mContext, MainWrapperAdapter.WrapperVH holder) {
        this.mContext=mContext;
        holder.productRecommendTopTextView.setOnClickListener(new ProductRecommendTopTextViewClickListener());
        holder.productLevelALayout.setOnClickListener(new ProductLevelALayoutClickListener());
        holder.productSubjectSortOneLayout.setOnClickListener(new ProductSubjectSortOneLayoutClickListener());
        holder.productSubjectSortTwoLayout.setOnClickListener(new ProductSubjectSortTwoLayoutClickListener());
        holder.productSubjectBannerOneLayout.setOnClickListener(new ProductSubjectBannerOneLayoutClickListener());
        holder.productSubjectBannerTwoLayout.setOnClickListener(new ProductSubjectBannerTwoLayoutClickListener());
        holder.productLevelBOneLayout.setOnClickListener(new ProductLevelBOneLayoutClickListener());
        holder.productLevelBTwoLayout.setOnClickListener(new ProductLevelBTwoLayoutClickListener());
        holder.productLevelBThreeLayout.setOnClickListener(new ProductLevelBThreeLayoutClickListener());
        holder.productLevelBFourLayout.setOnClickListener(new ProductLevelBFourLayoutClickListener());
    }

    class ProductRecommendTopTextViewClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(mContext,"产品推荐榜单被点击",Toast.LENGTH_SHORT).show();
        }
    }

    class ProductLevelALayoutClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(mContext,"A级产品被点击",Toast.LENGTH_SHORT).show();
        }
    }

    class ProductSubjectSortOneLayoutClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(mContext,"产品专题1被点击",Toast.LENGTH_SHORT).show();
        }
    }

    class ProductSubjectSortTwoLayoutClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(mContext,"产品专题2被点击",Toast.LENGTH_SHORT).show();
        }
    }

    class ProductSubjectBannerOneLayoutClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(mContext,"产品专题Banner1被点击",Toast.LENGTH_SHORT).show();
        }
    }

    class ProductSubjectBannerTwoLayoutClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(mContext,"产品专题Banner2被点击",Toast.LENGTH_SHORT).show();
        }
    }

    class ProductLevelBOneLayoutClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(mContext,"B级产品1被点击",Toast.LENGTH_SHORT).show();
        }
    }

    class ProductLevelBTwoLayoutClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(mContext,"B级产品2被点击",Toast.LENGTH_SHORT).show();
        }
    }

    class ProductLevelBThreeLayoutClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(mContext,"B级产品3被点击",Toast.LENGTH_SHORT).show();
        }
    }

    class ProductLevelBFourLayoutClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(mContext,"B级产品4被点击",Toast.LENGTH_SHORT).show();
        }
    }
}
