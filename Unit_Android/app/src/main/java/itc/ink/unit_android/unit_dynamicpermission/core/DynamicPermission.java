package itc.ink.unit_android.unit_dynamicpermission.core;

import android.app.Activity;
import android.content.Context;

/**
 * Created by yangwenjiang on 2018/9/13.
 */

public class DynamicPermission {
    public static final int IMPLEMENT_DEF = 0X01;

    public ServiceInterface serviceInterface = null;

    public DynamicPermission() {
        setServiceInterfaceImplement(IMPLEMENT_DEF);
    }

    public DynamicPermission(int mImplementCode) {
        setServiceInterfaceImplement(mImplementCode);
    }

    public void setServiceInterfaceImplement(int mImplementCode) {
        switch (mImplementCode) {
            case IMPLEMENT_DEF:
                serviceInterface = new ImplementDef();
                break;
            default:
                serviceInterface = new ImplementDef();
        }
    }

    public interface ServiceInterface {
        /**
         * 检查是否有权限
         */
        public boolean hasPermission(Activity mActivity, String permission);

        /**
         * 单个权限需求中调用，弹出权限提示对话框
         */
        public void showMissingPermissionDialog(Activity mActivity, String msgText);

        /**
         * 动态申请权限
         */
        public boolean requestPermissions(Activity mActivity, int mRequestCode, String[] mPermissions);

    }


}
