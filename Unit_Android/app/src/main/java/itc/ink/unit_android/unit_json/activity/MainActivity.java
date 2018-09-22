package itc.ink.unit_android.unit_json.activity;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import itc.ink.unit_android.R;
import itc.ink.unit_android.frame_util.StatusBarStyle;
import itc.ink.unit_android.unit_recyclerview.mode.mode_action.ActionListDataModel;
import itc.ink.unit_android.unit_recyclerview.mode.mode_action.ActionSubjectDataMode;
import itc.ink.unit_android.unit_recyclerview.mode.mode_interest.InterestDataModel;
import itc.ink.unit_android.unit_recyclerview.mode.mode_product.ProductDataMode;
import itc.ink.unit_android.unit_recyclerview.mode.mode_solution.SolutionDataMode;

/**
 * Created by yangwenjiang on 2018/9/21.
 */

public class MainActivity extends Activity {
    private TextView jesonShowText;

    private String recommendChoicenessJsonDataStr="";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //StatusBar Style
        StatusBarStyle.setStatusBarFullTransparent(this);
        //StatusBar Text And Icon Style
        StatusBarStyle.setAndroidNativeLightStatusBar(this, true);

        setContentView(R.layout.unit_json_activity);

        jesonShowText=findViewById(R.id.jesonShowText);
        recommendChoicenessJsonDataStr=getJsonStr("recommend_choiceness_data.json");

    }

    private String getJsonStr(String fileName){
        StringBuilder stringBuilder = new StringBuilder();
        try {
            AssetManager assetManager = getAssets();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    assetManager.open(fileName)));
            String lineStr;
            while ((lineStr = bufferedReader.readLine()) != null) {
                stringBuilder.append(lineStr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }

    public void loadBannerImageUrl(View view){
        ArrayList<String> bannerDataArray = new ArrayList<>();

        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(recommendChoicenessJsonDataStr);
        JsonObject rootObj = element.getAsJsonObject();
        JsonArray bannerDataJsonArray = rootObj.getAsJsonArray("array_banner_imageurl");
        Gson gson = new Gson();
        bannerDataArray=gson.fromJson(bannerDataJsonArray,new TypeToken<List<String>>(){}.getType());
        showData(bannerDataArray);
    }

    public void loadSolutionData(View view){
        ArrayList<SolutionDataMode> solutionDataArray = new ArrayList<>();

        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(recommendChoicenessJsonDataStr);
        JsonObject rootObj = element.getAsJsonObject();
        JsonArray solutionDataJsonArray = rootObj.getAsJsonArray("array_solution");
        Gson gson = new Gson();
        solutionDataArray=gson.fromJson(solutionDataJsonArray,new TypeToken<List<SolutionDataMode>>(){}.getType());
        showData(solutionDataArray);
    }

    public void loadActionSubjectData(View view){
        ArrayList<ActionSubjectDataMode> actionSubjectDataArray = new ArrayList<>();

        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(recommendChoicenessJsonDataStr);
        JsonObject rootObj = element.getAsJsonObject();
        JsonArray actionSubjectDataJsonArray = rootObj.getAsJsonArray("array_action_subject");
        Gson gson = new Gson();
        actionSubjectDataArray=gson.fromJson(actionSubjectDataJsonArray,new TypeToken<List<ActionSubjectDataMode>>(){}.getType());
        showData(actionSubjectDataArray);
    }

    public void loadActionListData(View view){
        ArrayList<ActionListDataModel> actionListDataArray = new ArrayList<>();

        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(recommendChoicenessJsonDataStr);
        JsonObject rootObj = element.getAsJsonObject();
        JsonArray actionListDataJsonArray = rootObj.getAsJsonArray("array_action_list");
        Gson gson = new Gson();
        actionListDataArray=gson.fromJson(actionListDataJsonArray,new TypeToken<List<ActionListDataModel>>(){}.getType());
        showData(actionListDataArray);
    }

    public void loadProductData(View view){
        ArrayList<ProductDataMode> productDataArray = new ArrayList<>();

        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(recommendChoicenessJsonDataStr);
        JsonObject rootObj = element.getAsJsonObject();
        JsonArray productDataJsonArray = rootObj.getAsJsonArray("array_product");
        Gson gson = new Gson();
        productDataArray=gson.fromJson(productDataJsonArray,new TypeToken<List<ProductDataMode>>(){}.getType());
        showData(productDataArray);
    }

    public void loadInterestListData(View view){
        ArrayList<InterestDataModel> interestDataArray = new ArrayList<>();

        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(recommendChoicenessJsonDataStr);
        JsonObject rootObj = element.getAsJsonObject();
        JsonArray interestListDataJsonArray = rootObj.getAsJsonArray("array_interest_list");
        Gson gson = new Gson();
        interestDataArray=gson.fromJson(interestListDataJsonArray,new TypeToken<List<InterestDataModel>>(){}.getType());
        showData(interestDataArray);
    }

    private <DataMode> void showData(List<DataMode> list){
        String showStr="";
        for(DataMode item:list){
            showStr+=item.toString()+"\n";
        }
        jesonShowText.setText(showStr);
    }
}
