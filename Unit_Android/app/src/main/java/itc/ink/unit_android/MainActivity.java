package itc.ink.unit_android;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import itc.ink.unit_android.tools.StatusBarStyle;

public class MainActivity extends Activity {

    private RecyclerView unitRecyclerView;
    private RecyclerView.LayoutManager unitLayoutManager;
    private UnitRecyclerViewAdapter unitRecyclerViewAdapter;
    private ArrayList<String> unitTitlesData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //StatusBar Style
        StatusBarStyle.setStatusBarFullTransparent(this);
        //StatusBar Text And Icon Style
        StatusBarStyle.setAndroidNativeLightStatusBar(this, true);

        setContentView(R.layout.activity_main);

        unitRecyclerView = findViewById(R.id.unitRecyclerView);


        unitTitlesData = initUnitTitlesData();
        unitRecyclerViewAdapter = new UnitRecyclerViewAdapter(unitTitlesData, MainActivity.this);
        unitRecyclerView.setAdapter(unitRecyclerViewAdapter);

        unitLayoutManager = new LinearLayoutManager(this);
        unitRecyclerView.setLayoutManager(unitLayoutManager);

    }

    public ArrayList<String> initUnitTitlesData() {
        ArrayList<String> unitTitlesArray = new ArrayList<>();
        String[] unitTitles = getResources().getStringArray(R.array.unit_title_array);
        for (int i = 0; i < unitTitles.length; i++) {
            unitTitlesArray.add(unitTitles[i]);
        }
        return unitTitlesArray;
    }


}
