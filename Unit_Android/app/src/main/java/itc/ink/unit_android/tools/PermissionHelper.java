package itc.ink.unit_android.tools;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;

import java.util.ArrayList;

import itc.ink.unit_android.unit_activity.GlideActivity;

/**
 * Created by yangwenjiang on 2018/9/11.
 */

public class PermissionHelper {
    private Activity mActivity;
    private PermissionInterface mPermissionInterface;
    private static final String PACKAGE_URL_SCHEME = "package:";

    public PermissionHelper(@NonNull Activity activity, @NonNull PermissionInterface permissionInterface) {
        mActivity = activity;
        mPermissionInterface = permissionInterface;
    }

    /**
     * 开始请求权限。
     * 方法内部已经对Android M 或以上版本进行了判断，外部使用不再需要重复判断。
     * 如果设备还不是M或以上版本，则也会回调到requestPermissionsSuccess方法。
     */
    public void requestPermissions(){
        String[] deniedPermissions = PermissionUtil.getDeniedPermissions(mActivity, mPermissionInterface.getPermissions());
        if(deniedPermissions != null && deniedPermissions.length > 0){
            PermissionUtil.requestPermissions(mActivity, deniedPermissions, mPermissionInterface.getPermissionsRequestCode());
        }else{
            mPermissionInterface.requestPermissionsSuccess();
        }
    }

    /**
     * 单个权限需求中调用，弹出权限提示对话框
     * @param msgText
     */
    public void showMissingPermissionDialog(String msgText) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
        builder.setTitle("权限提示");
        builder.setMessage(msgText);

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override public void onClick(DialogInterface dialog, int which) {
                mActivity.setResult(PackageManager.PERMISSION_DENIED);
            }
        });

        builder.setPositiveButton("设置", new DialogInterface.OnClickListener() {
            @Override public void onClick(DialogInterface dialog, int which) {
                startAppSettings();
            }
        });

        builder.show();
    }

    /**
     * 跳转到设置权限页
     */
    private void startAppSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.parse(PACKAGE_URL_SCHEME + mActivity.getPackageName()));
        mActivity.startActivity(intent);
    }

    public boolean hasPermission( String permission){
        return PermissionUtil.hasPermission(mActivity,permission);
    }

    /**
     * 在Activity中的onRequestPermissionsResult中调用
     * @param requestCode
     * @param permissions
     * @param grantResults
     * @return true 代表对该requestCode感兴趣，并已经处理掉了。false 对该requestCode不感兴趣，不处理。
     */
    public boolean requestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){
        if(requestCode == mPermissionInterface.getPermissionsRequestCode()){
            boolean isAllGranted = true;//是否全部权限已授权
            /*for(int result : grantResults){
                if(result == PackageManager.PERMISSION_DENIED){
                    isAllGranted = false;
                    break;
                }
            }*/

            ArrayList<String> deniedPermissionList = new ArrayList<>();

            for(int i=0;i<grantResults.length;i++){
                if (grantResults[i]==PackageManager.PERMISSION_DENIED){
                    deniedPermissionList.add(permissions[i]);
                    isAllGranted = false;
                }
            }

            if(isAllGranted){
                //已全部授权
                mPermissionInterface.requestPermissionsSuccess();
            }else{
                //权限有缺失
                mPermissionInterface.requestPermissionsFail(deniedPermissionList.toArray(new String[deniedPermissionList.size()]));
            }
            return true;
        }
        return false;
    }

}
