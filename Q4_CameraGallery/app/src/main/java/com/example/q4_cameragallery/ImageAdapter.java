package com.example.q4_cameragallery;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.File;

public class ImageAdapter extends BaseAdapter {

    Context context;
    File[] files;

    public ImageAdapter(Context context, File[] files) {
        this.context = context;
        this.files = files;
    }

    @Override
    public int getCount() {
        return files.length;
    }

    @Override
    public Object getItem(int i) {
        return files[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        ImageView imageView = new ImageView(context);

        Bitmap bitmap = BitmapFactory.decodeFile(files[i].getAbsolutePath());
        imageView.setImageBitmap(bitmap);

        imageView.setLayoutParams(new GridView.LayoutParams(300, 300));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        return imageView;
    }
}