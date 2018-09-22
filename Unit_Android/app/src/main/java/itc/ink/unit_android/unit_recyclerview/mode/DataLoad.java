package itc.ink.unit_android.unit_recyclerview.mode;

import android.content.Context;

import itc.ink.unit_android.unit_recyclerview.mode.implement.NetResDataLoader;


/**
 * Created by yangwenjiang on 2018/9/16.
 */

public class DataLoad {
    public static final int IMPLEMENT_NET_RESOURCE = 0X01;

    public OutService outService = null;

    public DataLoad(Context mContext) {
        setServiceInterfaceImplement(mContext, IMPLEMENT_NET_RESOURCE);
    }

    public DataLoad(Context mContext, int mImplementCode) {
        setServiceInterfaceImplement(mContext, mImplementCode);
    }

    private void setServiceInterfaceImplement(Context mContext, int mImplementCode) {
        switch (mImplementCode) {
            case IMPLEMENT_NET_RESOURCE:
                outService = new NetResDataLoader(mContext);
                break;
            default:
                outService = new NetResDataLoader(mContext);
        }
    }

    public interface OutService {

        /**
         * 加载Banner数据
         */
        Object loadBannerData(Context mContext);

        /**
         * 加载Solution数据
         */
        Object loadSolutionData(Context mContext);

        /**
         * 加载Action数据
         */
        Object loadActionSubjectData(Context mContext);

        /**
         * 加载Action数据
         */
        Object loadActionListData(Context mContext);

        /**
         * 加载Product数据
         */
        Object loadProductData(Context mContext);

        /**
         * 加载Interest数据
         */
        Object loadInterestData(Context mContext);

    }
}
