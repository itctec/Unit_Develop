package itc.ink.unit_android.unit_navigatoinbar.mode;

import android.content.Context;
import itc.ink.unit_android.unit_navigatoinbar.mode.implement.AssertDataLoader;

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
        Object loadProfessionSortData(Context mContext);

    }
}
