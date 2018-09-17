package itc.ink.unit_android.unit_recyclerview.adapter.implement;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.Arrays;

import itc.ink.unit_android.unit_recyclerview.adapter.MainWrapperAdapter;
import itc.ink.unit_android.unit_recyclerview.mode.mode_product.ProductDataMode;
import itc.ink.unit_android.unit_recyclerview.mode.mode_solution.SolutionDataMode;

/**
 * Created by yangwenjiang on 2018/9/14.
 */

public class ProductDelegateImplement implements MainWrapperAdapter.DelegateInterface {
    private Context mContext;
    @Override
    public void handleTransaction(Context mContext, MainWrapperAdapter.WrapperVH mHolder, Object mData) {
        this.mContext=mContext;

        final ArrayList<ProductDataMode> productData=(ArrayList<ProductDataMode>)mData;

        mHolder.productRecommendTopTextView.setOnClickListener(new ProductRecommendTopTextViewClickListener());
        mHolder.productLevelALayout.setOnClickListener(new ProductLevelALayoutClickListener());
        mHolder.productLevelATitleTextView.setText(productData.get(0).productTitle);
        mHolder.productLevelASummaryTextView.setText(productData.get(0).productSummary);
        Glide.with(mContext).load(productData.get(0).productImageUrl).into(mHolder.productLevelAImageImageView);

        mHolder.productSubjectSortOneLayout.setOnClickListener(new ProductSubjectSortOneLayoutClickListener());
        mHolder.productSubjectSortOneTitleTextView.setText(productData.get(1).productTitle);
        mHolder.productSubjectSortOneSummaryTextView.setText(productData.get(1).productSummary);
        Glide.with(mContext).load(productData.get(1).productImageLeftUrl).into(mHolder.productSubjectSortOneLeftImageImageView);
        Glide.with(mContext).load(productData.get(1).productImageRightUrl).into(mHolder.productSubjectSortOneRightImageImageView);

        mHolder.productSubjectSortTwoLayout.setOnClickListener(new ProductSubjectSortTwoLayoutClickListener());
        mHolder.productSubjectSortTwoTitleTextView.setText(productData.get(2).productTitle);
        mHolder.productSubjectSortTwoSummaryTextView.setText(productData.get(2).productSummary);
        Glide.with(mContext).load(productData.get(2).productImageLeftUrl).into(mHolder.productSubjectSortTwoLeftImageImageView);
        Glide.with(mContext).load(productData.get(2).productImageRightUrl).into(mHolder.productSubjectSortTwoRightImageImageView);

        mHolder.productSubjectBannerOneLayout.setOnClickListener(new ProductSubjectBannerOneLayoutClickListener());
        mHolder.productSubjectBannerOneTitleTextView.setText(productData.get(3).productTitle);
        mHolder.productSubjectBannerOneBanner.setBannerStyle(BannerConfig.NOT_INDICATOR);
        mHolder.productSubjectBannerOneBanner.setImageLoader(new MyLoader());
        String[] productSubjectBannerOneImageArray=new String[2];
        productSubjectBannerOneImageArray[0]=productData.get(3).productImageLeftUrl;
        productSubjectBannerOneImageArray[1]=productData.get(3).productImageRightUrl;
        mHolder.productSubjectBannerOneBanner.setImages(Arrays.asList(productSubjectBannerOneImageArray));
        mHolder.productSubjectBannerOneBanner.setBannerAnimation(Transformer.Default);
        mHolder.productSubjectBannerOneBanner.isAutoPlay(true).start();
        mHolder.productSubjectBannerOneBanner.setOnBannerListener(new ProductSubjectBannerOneBannerBannerClickListener());

        mHolder.productSubjectBannerTwoLayout.setOnClickListener(new ProductSubjectBannerTwoLayoutClickListener());
        mHolder.productSubjectBannerTwoTitleTextView.setText(productData.get(4).productTitle);
        mHolder.productSubjectBannerTwoBanner.setBannerStyle(BannerConfig.NOT_INDICATOR);
        mHolder.productSubjectBannerTwoBanner.setImageLoader(new MyLoader());
        String[] productSubjectBannerTwoImageArray=new String[2];
        productSubjectBannerTwoImageArray[0]=productData.get(4).productImageLeftUrl;
        productSubjectBannerTwoImageArray[1]=productData.get(4).productImageRightUrl;
        mHolder.productSubjectBannerTwoBanner.setImages(Arrays.asList(productSubjectBannerTwoImageArray));
        mHolder.productSubjectBannerTwoBanner.setBannerAnimation(Transformer.Default);
        mHolder.productSubjectBannerTwoBanner.isAutoPlay(true).start();
        mHolder.productSubjectBannerTwoBanner.setOnBannerListener(new ProductSubjectBannerTwoBannerBannerClickListener());

        mHolder.productLevelBOneLayout.setOnClickListener(new ProductLevelBOneLayoutClickListener());
        mHolder.productLevelBOneTitleTextView.setText(productData.get(5).productTitle);
        Glide.with(mContext).load(productData.get(5).productImageUrl).into(mHolder.productLevelBOneImageImageView);

        mHolder.productLevelBTwoLayout.setOnClickListener(new ProductLevelBTwoLayoutClickListener());
        mHolder.productLevelBTwoTitleTextView.setText(productData.get(6).productTitle);
        Glide.with(mContext).load(productData.get(6).productImageUrl).into(mHolder.productLevelBTwoImageImageView);

        mHolder.productLevelBThreeLayout.setOnClickListener(new ProductLevelBThreeLayoutClickListener());
        mHolder.productLevelBThreeTitleTextView.setText(productData.get(7).productTitle);
        Glide.with(mContext).load(productData.get(7).productImageUrl).into(mHolder.productLevelBThreeImageImageView);

        mHolder.productLevelBFourLayout.setOnClickListener(new ProductLevelBFourLayoutClickListener());
        mHolder.productLevelBFourTitleTextView.setText(productData.get(8).productTitle);
        Glide.with(mContext).load(productData.get(8).productImageUrl).into(mHolder.productLevelBFourImageImageView);
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

    class ProductSubjectBannerOneBannerBannerClickListener implements OnBannerListener {

        @Override
        public void OnBannerClick(int position) {
            Toast.makeText(mContext, "ProductBannerOne" + position + "被点击", Toast.LENGTH_SHORT).show();
        }
    }

    class ProductSubjectBannerTwoBannerBannerClickListener implements OnBannerListener {

        @Override
        public void OnBannerClick(int position) {
            Toast.makeText(mContext, "ProductBannerTwo" + position + "被点击", Toast.LENGTH_SHORT).show();
        }
    }

    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load((String) path).into(imageView);
        }
    }
}
