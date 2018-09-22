package itc.ink.unit_android.unit_viewpager.mode.implement;

import android.content.Context;

import java.util.ArrayList;

import itc.ink.unit_android.R;
import itc.ink.unit_android.unit_viewpager.mode.DataLoad;

/**
 * Created by yangwenjiang on 2018/9/16.
 */

public class AssertDataLoader implements DataLoad.OutService{

    @Override
    public Object loadActionBarTitleData(Context mContext) {
        ArrayList<String> actionBarTitleDataArray = new ArrayList<>();

        String[] actionBarTitleTitles = mContext.getResources().getStringArray(R.array.array_actionbar_title);

        for (int i = 0; i < actionBarTitleTitles.length; i++) {
            actionBarTitleDataArray.add(actionBarTitleTitles[i]);
        }
        return actionBarTitleDataArray;
    }


}
