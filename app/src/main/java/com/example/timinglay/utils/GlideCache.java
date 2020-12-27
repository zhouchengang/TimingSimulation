package com.example.timinglay.utils;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.bumptech.glide.module.AppGlideModule;
import com.example.timinglay.activity.MainActivity;

import java.io.File;


/**
 * 描述:
 * demoone-
 *
 * @Author J_jiasheng@qq.com
 * @create 2020-12-16 10:00
 */
@GlideModule
public class GlideCache extends AppGlideModule {
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        int diskCacheSizeBytes = 1024 * 1024 * 1024;

        builder.setDiskCache(
                new DiskLruCacheFactory(getCacheDisk(), diskCacheSizeBytes)
        );
    }

    @Override
    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
        super.registerComponents(context, glide, registry);
    }



    public static boolean cleanCacheDisk() {
        return deleteFolderFile(getCacheDisk());
    }

    public static String getCacheDisk() {
        return MainActivity.localcachepath + "/GlideDisk";
    }

    // 按目录删除文件夹文件
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
}
