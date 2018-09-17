package itc.ink.unit_android.unit_recyclerview.mode;

import android.app.Activity;
import android.content.Context;

import itc.ink.unit_android.unit_dynamicpermission.core.ImplementDef;
import itc.ink.unit_android.unit_recyclerview.mode.implement.AssertDataLoader;

/**
 * Created by yangwenjiang on 2018/9/16.
 */

public class DataLoad {

    public static final int IMPLEMENT_DEF = 0X01;

    public OutService outService = null;

    public DataLoad() {
        setServiceInterfaceImplement(IMPLEMENT_DEF);
    }

    public DataLoad(int mImplementCode) {
        setServiceInterfaceImplement(mImplementCode);
    }

    public void setServiceInterfaceImplement(int mImplementCode) {
        switch (mImplementCode) {
            case IMPLEMENT_DEF:
                outService = new AssertDataLoader();
                break;
            default:
                outService = new AssertDataLoader();
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
