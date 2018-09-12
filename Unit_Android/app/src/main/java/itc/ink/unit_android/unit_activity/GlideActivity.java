package itc.ink.unit_android.unit_activity;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import itc.ink.unit_android.R;
import itc.ink.unit_android.tools.PermissionHelper;
import itc.ink.unit_android.tools.PermissionInterface;
import itc.ink.unit_android.tools.StatusBarStyle;
import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.GrayscaleTransformation;

/**
 * Created by yangwenjiang on 2018/9/10.
 */

public class GlideActivity extends Activity {

    private PermissionHelper mPermissionHelper;
    private String[] permissionsNeeded = null;
    private boolean obtainAllPermissionSuccess = false;
    ArrayList<String> deniedPermissionList = new ArrayList<>();

    private ImageView glideImageView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //StatusBar Style
        StatusBarStyle.setStatusBarFullTransparent(this);
        //StatusBar Text And Icon Style
        StatusBarStyle.setAndroidNativeLightStatusBar(this, true);

        permissionsNeeded = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE};
        mPermissionHelper = new PermissionHelper(GlideActivity.this, permissionInterface);
        mPermissionHelper.requestPermissions();

        setContentView(R.layout.activity_unit_glide);

        glideImageView = findViewById(R.id.glideImageView);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (mPermissionHelper.hasPermission(Manifest.permission.READ_EXTERNAL_STORAGE)) {
            deniedPermissionList.remove(Manifest.permission.READ_EXTERNAL_STORAGE);
        }
    }

    public void loadLocalResImage(View view) {
        int imageResourceId = R.drawable.local_res_bg;
        Glide.with(this).load(imageResourceId).into(glideImageView);
    }

    public void loadSDCardImage(View view) {
        if (obtainAllPermissionSuccess == false && deniedPermissionList.contains(Manifest.permission.READ_EXTERNAL_STORAGE)) {
            mPermissionHelper.showMissingPermissionDialog("获取本地图片需要授予App访问SD卡的权限，请前往设置授予相应权限");
        } else {
            File imageFile = new File(Environment.getExternalStorageDirectory() + "/local_sdcard_bg.png");
            Glide.with(GlideActivity.this).load(imageFile).into(glideImageView);
        }
    }

    public void loadNetworkImage(View view) {
        String imageUrl = "http://www.itc.ink/data/image/one.jpg";

        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.place_image);

        Glide.with(GlideActivity.this)
                .load(imageUrl)
                .apply(options)
                .into(glideImageView);
    }

    public void loadNetworkImageNoneCache(View view) {
        String imageUrl = "http://www.itc.ink/data/image/two.jpg";

        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.place_image)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true);

        Glide.with(GlideActivity.this)
                .load(imageUrl)
                .apply(options)
                .into(glideImageView);
    }

    public void loadErrorImage(View view) {
        String imageUrl = "http://www.itc.ink/data/image/none.jpg";

        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.place_image)
                .error(R.drawable.error_image);

        Glide.with(GlideActivity.this)
                .load(imageUrl)
                .apply(options)
                .into(glideImageView);
    }

    public void loadSizeImage(View view) {
        String imageUrl = "http://www.itc.ink/data/image/three.jpg";

        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.place_image)
                .error(R.drawable.error_image)
                .override(200, 100);

        Glide.with(GlideActivity.this)
                .load(imageUrl)
                .apply(options)
                .into(glideImageView);
    }

    public void loadGifImage(View view) {
        int imageResourceId = R.drawable.loading_image;

        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.place_image)
                .error(R.drawable.error_image);

        Glide.with(GlideActivity.this)
                //.asBitmap()
                .load(imageResourceId)
                .apply(options)
                .into(glideImageView);
    }

    public void loadImageToTarget(View view) {
        String imageUrl = "http://www.itc.ink/data/image/four.jpg";

        SimpleTarget<Drawable> simpleTarget = new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                glideImageView.setImageDrawable(resource);
            }
        };

        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.place_image)
                .error(R.drawable.error_image);

        Glide.with(GlideActivity.this)
                .load(imageUrl)
                .apply(options)
                .into(simpleTarget);
    }

    public void preLoadImage(View view) {
        String imageOneUrl = "http://www.itc.ink/data/image/one.jpg";
        String imageTwoUrl = "http://www.itc.ink/data/image/two.jpg";
        String imageThreeUrl = "http://www.itc.ink/data/image/three.jpg";
        String imageFourUrl = "http://www.itc.ink/data/image/four.jpg";


        Glide.with(GlideActivity.this)
                .load(imageOneUrl)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        Toast.makeText(GlideActivity.this,"图片预加载失败",Toast.LENGTH_LONG).show();
                        System.out.println("加载失败原因："+e.toString());
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        Toast.makeText(GlideActivity.this,"图片预加载成功",Toast.LENGTH_LONG).show();
                        return false;
                    }
                })
                .preload();
        Glide.with(GlideActivity.this)
                .load(imageTwoUrl)
                .preload();
        Glide.with(GlideActivity.this)
                .load(imageThreeUrl)
                .preload();
        Glide.with(GlideActivity.this)
                .load(imageFourUrl)
                .preload();
    }

    public void getImagePath(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String imageUrl = "http://www.itc.ink/data/image/five.jpg";
                    final Context context = getApplicationContext();
                    FutureTarget<File> target = Glide.with(context)
                            .asFile()
                            .load(imageUrl)
                            .submit();
                    final File imageFile = target.get();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(context, imageFile.getPath(), Toast.LENGTH_LONG).show();
                            System.out.println(imageFile.getPath());
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void transformImage(View view) {
        String imageUrl = "http://www.itc.ink/data/image/six.jpg";

        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.place_image)
                .error(R.drawable.error_image)
                .circleCrop();
//                .fitCenter();
//                .centerCrop();

        Glide.with(GlideActivity.this)
                .load(imageUrl)
                .apply(options)
                .into(glideImageView);
    }

    public void transformsLib(View view) {
        String imageUrl = "http://www.itc.ink/data/image/seven.jpg";

        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.place_image)
                .error(R.drawable.error_image)
                .transforms(new BlurTransformation(), new GrayscaleTransformation());;

        Glide.with(GlideActivity.this)
                .load(imageUrl)
                .apply(options)
                .into(glideImageView);
    }


    PermissionInterface permissionInterface = new PermissionInterface() {
        private final int PERMISSION_REQUEST_CODE = 0X001;

        @Override
        public int getPermissionsRequestCode() {
            return PERMISSION_REQUEST_CODE;
        }

        @Override
        public String[] getPermissions() {
            return permissionsNeeded;
        }

        @Override
        public void requestPermissionsSuccess() {
            //Success Obtain All Needed Permissions
            obtainAllPermissionSuccess = true;

        }

        @Override
        public void requestPermissionsFail(String[] deniedPermissions) {
            Toast.makeText(GlideActivity.this, "以下权限获取失败：\n" + Arrays.toString(deniedPermissions), Toast.LENGTH_LONG).show();
            obtainAllPermissionSuccess = false;
            deniedPermissionList.clear();
            for (String deniedPermission : deniedPermissions) {
                deniedPermissionList.add(deniedPermission);
            }
        }
    };

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (mPermissionHelper.requestPermissionsResult(requestCode, permissions, grantResults)) {
            //权限请求结果，并已经处理了该回调
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


}
