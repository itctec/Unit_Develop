package itc.ink.unit_android.unit_recyclerview.mode.implement;

import android.content.Context;
import android.content.res.AssetManager;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import itc.ink.unit_android.unit_recyclerview.mode.DataLoad;
import itc.ink.unit_android.unit_recyclerview.mode.mode_action.ActionListDataModel;
import itc.ink.unit_android.unit_recyclerview.mode.mode_action.ActionSubjectDataMode;
import itc.ink.unit_android.unit_recyclerview.mode.mode_interest.InterestDataModel;
import itc.ink.unit_android.unit_recyclerview.mode.mode_product.ProductDataMode;
import itc.ink.unit_android.unit_recyclerview.mode.mode_solution.SolutionDataMode;


/**
 * Created by yangwenjiang on 2018/9/16.
 */

public class NetResDataLoader implements DataLoad.OutService{
    private String mRecommendChoicenessDataJSONStr="";

    public NetResDataLoader(Context mContext) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            AssetManager assetManager = mContext.getAssets();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    assetManager.open("recommend_choiceness_data.json")));
            String lineStr;
            while ((lineStr = bufferedReader.readLine()) != null) {
                stringBuilder.append(lineStr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        mRecommendChoicenessDataJSONStr=stringBuilder.toString();
    }

    @Override
    public Object loadBannerData(Context mContext) {
        ArrayList<String> bannerDataArray = new ArrayList<>();
        JsonParser parser = new JsonParser();

        JsonElement element = parser.parse(mRecommendChoicenessDataJSONStr);
        JsonObject rootObj = element.getAsJsonObject();
        JsonArray bannerDataJsonArray = rootObj.getAsJsonArray("array_banner_imageurl");
        Gson gson = new Gson();
        bannerDataArray=gson.fromJson(bannerDataJsonArray,new TypeToken<List<String>>(){}.getType());

        return bannerDataArray;
    }

    @Override
    public Object loadSolutionData(Context mContext) {
        ArrayList<SolutionDataMode> solutionDataArray = new ArrayList<>();

        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(mRecommendChoicenessDataJSONStr);
        JsonObject rootObj = element.getAsJsonObject();
        JsonArray solutionDataJsonArray = rootObj.getAsJsonArray("array_solution");
        Gson gson = new Gson();
        solutionDataArray=gson.fromJson(solutionDataJsonArray,new TypeToken<List<SolutionDataMode>>(){}.getType());

        return solutionDataArray;
    }

    @Override
    public Object loadActionSubjectData(Context mContext) {
        ArrayList<ActionSubjectDataMode> actionSubjectDataArray = new ArrayList<>();

        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(mRecommendChoicenessDataJSONStr);
        JsonObject rootObj = element.getAsJsonObject();
        JsonArray actionSubjectDataJsonArray = rootObj.getAsJsonArray("array_action_subject");
        Gson gson = new Gson();
        actionSubjectDataArray=gson.fromJson(actionSubjectDataJsonArray,new TypeToken<List<ActionSubjectDataMode>>(){}.getType());

        return actionSubjectDataArray;
    }

    @Override
    public Object loadActionListData(Context mContext) {
        ArrayList<ActionListDataModel> actionListDataArray = new ArrayList<>();

        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(mRecommendChoicenessDataJSONStr);
        JsonObject rootObj = element.getAsJsonObject();
        JsonArray actionListDataJsonArray = rootObj.getAsJsonArray("array_action_list");
        Gson gson = new Gson();
        actionListDataArray=gson.fromJson(actionListDataJsonArray,new TypeToken<List<ActionListDataModel>>(){}.getType());

        return actionListDataArray;
    }

    @Override
    public Object loadProductData(Context mContext) {
        ArrayList<ProductDataMode> productDataArray = new ArrayList<>();

        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(mRecommendChoicenessDataJSONStr);
        JsonObject rootObj = element.getAsJsonObject();
        JsonArray productDataJsonArray = rootObj.getAsJsonArray("array_product");
        Gson gson = new Gson();
        productDataArray=gson.fromJson(productDataJsonArray,new TypeToken<List<ProductDataMode>>(){}.getType());
        return productDataArray;
    }

    @Override
    public Object loadInterestData(Context mContext) {
        ArrayList<InterestDataModel> interestDataArray = new ArrayList<>();
        ArrayList<InterestDataModel> interestDataArrays = new ArrayList<>();

        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(mRecommendChoicenessDataJSONStr);
        JsonObject rootObj = element.getAsJsonObject();
        JsonArray interestListDataJsonArray = rootObj.getAsJsonArray("array_interest_list");
        Gson gson = new Gson();
        interestDataArray=gson.fromJson(interestListDataJsonArray,new TypeToken<List<InterestDataModel>>(){}.getType());

        for (int i=0;i<20;i++){
            interestDataArrays.addAll(interestDataArray);
        }
        return interestDataArrays;
    }
}
