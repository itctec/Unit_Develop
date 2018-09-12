package itc.ink.unit_android.unit_activity;

import android.Manifest;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import itc.ink.unit_android.R;
import itc.ink.unit_android.tools.PermissionHelper;
import itc.ink.unit_android.tools.PermissionInterface;
import itc.ink.unit_android.tools.StatusBarStyle;
import itc.ink.unit_android.unit_adapter.PermissionRecyclerViewAdapter;

/**
 * Created by yangwenjiang on 2018/9/10.
 */

public class PermissionActivity extends Activity {

    private RecyclerView permissionRecyclerView;
    private RecyclerView.LayoutManager permissionLayoutManager;
    private PermissionRecyclerViewAdapter permissionRecyclerViewAdapter;
    private ArrayList<String> permissionTitlesData;

    private PermissionHelper mPermissionHelper;
    private String[] permissionsNeeded=null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //StatusBar Style
        StatusBarStyle.setStatusBarFullTransparent(this);
        //StatusBar Text And Icon Style
        StatusBarStyle.setAndroidNativeLightStatusBar(this, true);

        setContentView(R.layout.activity_main);

        permissionRecyclerView = findViewById(R.id.unitRecyclerView);


        permissionTitlesData = initPermissionTitlesData();
        permissionRecyclerViewAdapter = new PermissionRecyclerViewAdapter(permissionTitlesData,this);
        permissionRecyclerViewAdapter.setOnItemClickListener(new PermissionRecyclerViewAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, String data) {

                switch (data){
                    case "读SD卡":
                        permissionsNeeded = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE};
                        break;
                    case "写SD卡":
                        permissionsNeeded = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};
                        break;
                    case "读短信":
                        permissionsNeeded = new String[]{Manifest.permission.READ_SMS};
                        break;
                    case "收短信":
                        permissionsNeeded = new String[]{Manifest.permission.RECEIVE_SMS};
                        break;
                    case "发短信":
                        permissionsNeeded = new String[]{Manifest.permission.SEND_SMS};
                        break;
                    case "收彩信":
                        permissionsNeeded = new String[]{Manifest.permission.RECEIVE_MMS};
                        break;
                    case "收WAP推送":
                        permissionsNeeded = new String[]{Manifest.permission.RECEIVE_WAP_PUSH};
                        break;
                    case "获取详细定位":
                        permissionsNeeded = new String[]{Manifest.permission.ACCESS_FINE_LOCATION};
                        break;
                    case "获取粗略定位":
                        permissionsNeeded = new String[]{Manifest.permission.ACCESS_COARSE_LOCATION};
                        break;
                    case "访问麦克风":
                        permissionsNeeded = new String[]{Manifest.permission.RECORD_AUDIO};
                        break;
                    case "访问相机":
                        permissionsNeeded = new String[]{Manifest.permission.CAMERA};
                        break;
                    case "访问身体传感器":
                        permissionsNeeded = new String[]{Manifest.permission.BODY_SENSORS};
                        break;
                    case "读日历数据":
                        permissionsNeeded = new String[]{Manifest.permission.READ_CALENDAR};
                        break;
                    case "写日历数据":
                        permissionsNeeded = new String[]{Manifest.permission.WRITE_CALENDAR};
                        break;
                    case "读通话记录":
                        permissionsNeeded = new String[]{Manifest.permission.READ_CALL_LOG};
                        break;
                    case "写通话记录":
                        permissionsNeeded = new String[]{Manifest.permission.WRITE_CALL_LOG};
                        break;
                    case "拨号":
                        permissionsNeeded = new String[]{Manifest.permission.CALL_PHONE};
                        break;
                    case "获取电话状态":
                        permissionsNeeded = new String[]{Manifest.permission.READ_PHONE_STATE};
                        break;
                    case "使用SIP":
                        permissionsNeeded = new String[]{Manifest.permission.USE_SIP};
                        break;
                    case "去电监听":
                        permissionsNeeded = new String[]{Manifest.permission.PROCESS_OUTGOING_CALLS};
                        break;
                    case "添加语音信箱":
                        permissionsNeeded = new String[]{Manifest.permission.ADD_VOICEMAIL};
                        break;
                    case "写通讯录":
                        permissionsNeeded = new String[]{Manifest.permission.WRITE_CONTACTS};
                        break;
                    case "读通讯录":
                        permissionsNeeded = new String[]{Manifest.permission.READ_CONTACTS};
                        break;
                    case "获取账号":
                        permissionsNeeded = new String[]{Manifest.permission.GET_ACCOUNTS};
                        break;
                }

                mPermissionHelper = new PermissionHelper(PermissionActivity.this, permissionInterface);
                mPermissionHelper.requestPermissions();


            }
        });

        permissionRecyclerView.setAdapter(permissionRecyclerViewAdapter);
        permissionLayoutManager = new GridLayoutManager(this,2);
        permissionRecyclerView.setLayoutManager(permissionLayoutManager);

    }

    public ArrayList<String> initPermissionTitlesData() {
        ArrayList<String> permissionTitlesArray = new ArrayList<>();
        String[] permissionTitles = getResources().getStringArray(R.array.permission_title_array);
        for (int i = 0; i < permissionTitles.length; i++) {
            permissionTitlesArray.add(permissionTitles[i]);
        }
        return permissionTitlesArray;
    }

    PermissionInterface permissionInterface = new PermissionInterface(){
        private final int PERMISSION_REQUEST_CODE=0X001;

        @Override
        public int getPermissionsRequestCode() {
            return PERMISSION_REQUEST_CODE ;
        }

        @Override
        public String[] getPermissions() {
            return permissionsNeeded;
        }

        @Override
        public void requestPermissionsSuccess() {
            Toast.makeText(PermissionActivity.this,"成功获取所有权限",Toast.LENGTH_LONG).show();
        }

        @Override
        public void requestPermissionsFail(String[] deniedPermissions) {
            Toast.makeText(PermissionActivity.this,"以下权限获取失败：\n"+ Arrays.toString(deniedPermissions),Toast.LENGTH_LONG).show();
        }
    };

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(mPermissionHelper.requestPermissionsResult(requestCode, permissions, grantResults)) {
            //权限请求结果，并已经处理了该回调
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
