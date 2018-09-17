package itc.ink.unit_android.unit_glide.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
import itc.ink.unit_android.R;
import itc.ink.unit_android.frame_util.StatusBarStyle;
import itc.ink.unit_android.unit_dynamicpermission.core.DynamicPermission;
import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.GrayscaleTransformation;

/**
 * Created by yangwenjiang on 2018/9/10.
 */

public class MainActivity extends Activity {

    private DynamicPermission dynamicPermission;
    private String[] permissionsNeeded = null;
    private final int PERMISSION_REQUEST_CODE = 0X001;
    private boolean obtainAllPermissionSuccess = false;
    private ArrayList<String> deniedPermissionList = new ArrayList<>();

    private ImageView glideImageView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //StatusBar Style
        StatusBarStyle.setStatusBarFullTransparent(this);
        //StatusBar Text And Icon Style
        StatusBarStyle.setAndroidNativeLightStatusBar(this, true);

        permissionsNeeded = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE};
        dynamicPermission = new DynamicPermission();
        obtainAllPermissionSuccess = dynamicPermission.outService.requestPermissions(MainActivity.this, PERMISSION_REQUEST_CODE, permissionsNeeded);
        if (obtainAllPermissionSuccess) {
            Toast.makeText(MainActivity.this,"本页面已无权限需求限制！",Toast.LENGTH_LONG).show();
        }

        setContentView(R.layout.unit_glide_activity);

        glideImageView = findViewById(R.id.glideImageView);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (dynamicPermission.outService.hasPermission(MainActivity.this,Manifest.permission.READ_EXTERNAL_STORAGE)) {
            deniedPermissionList.remove(Manifest.permission.READ_EXTERNAL_STORAGE);
        }
    }

    public void loadLocalResImage(View view) {
        int imageResourceId = R.drawable.local_res_bg;
        Glide.with(this).load(imageResourceId).into(glideImageView);
    }

    public void loadSDCardImage(View view) {
        if (obtainAllPermissionSuccess == false && deniedPermissionList.contains(Manifest.permission.READ_EXTERNAL_STORAGE)) {
            String dialogMsg="获取本地图片需要授予App访问SD卡的权限，请前往设置授予相应权限";
            dynamicPermission.outService.showMissingPermissionDialog(MainActivity.this,dialogMsg);
        } else {
            File imageFile = new File(Environment.getExternalStorageDirectory() + "/local_sdcard_bg.png");
            Glide.with(MainActivity.this).load(imageFile).into(glideImageView);
        }
    }

    public void loadNetworkImage(View view) {
        String imageUrl = "http://www.itc.ink/data/image/one.jpg";

        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.place_image);

        Glide.with(MainActivity.this)
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

        Glide.with(MainActivity.this)
                .load(imageUrl)
                .apply(options)
                .into(glideImageView);
    }

    public void loadErrorImage(View view) {
        String imageUrl = "http://www.itc.ink/data/image/none.jpg";

        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.place_image)
                .error(R.drawable.error_image);

        Glide.with(MainActivity.this)
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

        Glide.with(MainActivity.this)
                .load(imageUrl)
                .apply(options)
                .into(glideImageView);
    }

    public void loadGifImage(View view) {
        int imageResourceId = R.drawable.loading_image;

        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.place_image)
                .error(R.drawable.error_image);

        Glide.with(MainActivity.this)
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

        Glide.with(MainActivity.this)
                .load(imageUrl)
                .apply(options)
                .into(simpleTarget);
    }

    public void preLoadImage(View view) {
        String imageOneUrl = "http://www.itc.ink/data/image/one.jpg";
        String imageTwoUrl = "http://www.itc.ink/data/image/two.jpg";
        String imageThreeUrl = "http://www.itc.ink/data/image/three.jpg";
        String imageFourUrl = "http://www.itc.ink/data/image/four.jpg";


        Glide.with(MainActivity.this)
                .load(imageOneUrl)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        Toast.makeText(MainActivity.this,"图片预加载失败",Toast.LENGTH_LONG).show();
                        System.out.println("加载失败原因："+e.toString());
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        Toast.makeText(MainActivity.this,"图片预加载成功",Toast.LENGTH_LONG).show();
                        return false;
                    }
                })
                .preload();
        Glide.with(MainActivity.this)
                .load(imageTwoUrl)
                .preload();
        Glide.with(MainActivity.this)
                .load(imageThreeUrl)
                .preload();
        Glide.with(MainActivity.this)
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

        Glide.with(MainActivity.this)
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

        Glide.with(MainActivity.this)
                .load(imageUrl)
                .apply(options)
                .into(glideImageView);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == PERMISSION_REQUEST_CODE){
            deniedPermissionList.clear();
            obtainAllPermissionSuccess = true;
            for(int i=0;i<grantResults.length;i++){
                if (grantResults[i]== PackageManager.PERMISSION_DENIED){
                    deniedPermissionList.add(permissions[i]);
                    obtainAllPermissionSuccess = false;
                }
            }

            if(obtainAllPermissionSuccess){
                Toast.makeText(MainActivity.this,"已动态获取所有权限",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(MainActivity.this, "以下权限获取失败：\n" + deniedPermissionList.toString(), Toast.LENGTH_LONG).show();
            }
        }
    }


}
