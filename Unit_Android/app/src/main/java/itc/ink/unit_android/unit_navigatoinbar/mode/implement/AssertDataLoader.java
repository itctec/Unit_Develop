package itc.ink.unit_android.unit_navigatoinbar.mode.implement;

import android.content.Context;

import java.util.ArrayList;

import itc.ink.unit_android.R;
import itc.ink.unit_android.unit_navigatoinbar.mode.DataLoad;

/**
 * Created by yangwenjiang on 2018/9/16.
 */

public class AssertDataLoader implements DataLoad.OutService{

    @Override
    public Object loadProfessionSortData(Context mContext) {
        ArrayList<String> professionSortDataArray = new ArrayList<>();

        String[] professionSortTitles = mContext.getResources().getStringArray(R.array.array_topbar_professionsort_magicindicator_title);

        for (int i = 0; i < professionSortTitles.length; i++) {
            professionSortDataArray.add(professionSortTitles[i]);
        }
        return professionSortDataArray;
    }


}
