package com.example.timinglay.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Environment;
import android.util.Log;

import androidx.core.app.ActivityCompat;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 描述:
 * TimingLay-
 *
 * @Author J_jiasheng@qq.com
 * @create 2020-12-17 12:17
 */
public  class Utils {
    public static final String BASE_URL = "http://192.168.8.247:4545/";
    public static final String IMG_URL = "http://192.168.8.247:8888/";
    public static final String UP_URL = "http://192.168.8.247:1231/";
    public static final String UP_URL2 = "http://192.168.8.247:7979/";
    /**
     * 在对sd卡进行读写操作之前调用这个方法
     * Checks if the app has permission to write to device storage
     * If the app does not has permission then the user will be prompted to grant permissions
     */
    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            String[] PERMISSIONS_STORAGE = {
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
            };
            final int REQUEST_EXTERNAL_STORAGE = 1;
            ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
        }
    }

    /**
     * 格式化long类型的时间戳
     */
    public static String getMonthDay(long dates) {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("MM月dd日");
       String date = sDateFormat.format(new Date(dates));
        return date;
    }



    // 删除文件夹
    private static boolean deleteFolderFile(String filePath) {
        try {
            File file = new File(filePath);
            if (file.isDirectory()) {
                File files[] = file.listFiles();
                for (File file1 : files) {
                    Log.e("delete",""+file1.getAbsolutePath());
                    deleteFolderFile(file1.getAbsolutePath());
                }
            }
            if (!file.isDirectory()) {
                file.delete();
            } else {
                if (file.listFiles().length == 0) {
                    file.delete();
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取cache路径
     */
    public static String getDiskCachePath(Context context) {
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
            return context.getExternalCacheDir().getPath();
        } else {
            return context.getCacheDir().getPath();
        }
    }
    /**
     * 获得JSON文件数据
     * @param context 上下文对象
     * @param file JSON文件名字“*.json”
     * @return json字符串
     */
    public static  String getJSONFile(Context context, String file) {
        //1.	创建字符串存储对象StringBuilder
        StringBuilder stringBuilder=new StringBuilder();
        //2.	获得AssetManager对象context.getAssets();方式来获取
        AssetManager assetManager=context.getAssets();
        try {
            //3.	通过AssetManager对象的open方法获得输入流对象，绑定字符集urf-8
            InputStreamReader inputStreamReader=new InputStreamReader(assetManager.open(file),"utf-8");
            //4.	创建BufferedReader对象绑定输入流对象
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            String line="";
            //5.	循环遍历读取出文件内的数据存储到StringBuilder内
            while ((line=bufferedReader.readLine())!=null){
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //6.	返回StringBuilder.toString();则能获取到文件内所有的JSON数据了；
        return stringBuilder.toString();
    }


}
