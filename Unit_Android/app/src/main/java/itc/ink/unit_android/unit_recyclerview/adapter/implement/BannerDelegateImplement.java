package itc.ink.unit_android.unit_recyclerview.adapter.implement;

import android.content.Context;
import android.widget.ImageView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;
import java.util.ArrayList;
import itc.ink.unit_android.unit_recyclerview.adapter.MainWrapperAdapter;

/**
 * Created by yangwenjiang on 2018/9/14.
 */

public class BannerDelegateImplement implements MainWrapperAdapter.DelegateInterface {
    private Context mContext;

    @Override
    public void handleTransaction(Context mContext, MainWrapperAdapter.WrapperVH mHolder, Object mData) {
        this.mContext = mContext;

        mHolder.choicenessBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        mHolder.choicenessBanner.setImageLoader(new MyLoader());
        mHolder.choicenessBanner.setImages((ArrayList<String>) mData);
        mHolder.choicenessBanner.setBannerAnimation(Transformer.Default);
        mHolder.choicenessBanner.isAutoPlay(true);
        mHolder.choicenessBanner.setIndicatorGravity(BannerConfig.RIGHT).start();
        mHolder.choicenessBanner.setOnBannerListener(new ChoicenessBannerClickListener());
    }

    class ChoicenessBannerClickListener implements OnBannerListener {

        @Override
        public void OnBannerClick(int position) {
            Toast.makeText(mContext, "ChoicenessBanner" + position + "被点击", Toast.LENGTH_SHORT).show();
        }
    }

    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load((String) path).into(imageView);
        }
    }
}
