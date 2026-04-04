package com.example.q4_cameragallery;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    Button captureBtn, openGalleryBtn;
    GridView gridView;
    File[] files;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        captureBtn = findViewById(R.id.captureBtn);
        openGalleryBtn = findViewById(R.id.openGalleryBtn);
        gridView = findViewById(R.id.gridView);

        // Capture Image
        captureBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 1);
        });

        // Load Gallery
        openGalleryBtn.setOnClickListener(v -> loadImages());

        // Click Image → Details
        gridView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("path", files[position].getAbsolutePath());
            startActivity(intent);
        });
    }

    // Handle camera result
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            saveImage(photo);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    // Save image
    private void saveImage(Bitmap bitmap) {
        try {
            File folder = new File(Environment.getExternalStorageDirectory() + "/MyImages");
            if (!folder.exists()) folder.mkdir();

            File file = new File(folder, System.currentTimeMillis() + ".jpg");

            FileOutputStream out = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.flush();
            out.close();

            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Load images into grid
    private void loadImages() {
        File folder = new File(Environment.getExternalStorageDirectory() + "/MyImages");
        files = folder.listFiles();

        if (files != null) {
            gridView.setAdapter(new ImageAdapter(this, files));
        }
    }
}