package com.example.q4_cameragallery;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {

    // Buttons
    Button btnCamera, btnGallery;

    // Request code for camera
    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link UI
        btnCamera = findViewById(R.id.btnCamera);
        btnGallery = findViewById(R.id.btnGallery);

        // Request permissions (Camera + Storage)
        ActivityCompat.requestPermissions(this,
                new String[]{
                        Manifest.permission.CAMERA,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                },
                1);

        // 📸 OPEN CAMERA
        btnCamera.setOnClickListener(v -> {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        });

        // 🖼️ OPEN GALLERY SCREEN
        btnGallery.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, GalleryActivity.class));
        });
    }

    // 📥 HANDLE CAMERA RESULT
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {

            if (data != null && data.getExtras() != null) {

                // Get captured image (thumbnail)
                Bitmap imageBitmap = (Bitmap) data.getExtras().get("data");

                // Save image
                saveImage(imageBitmap);
            }
        }
    }

    // 💾 SAVE IMAGE TO GALLERY
    private void saveImage(Bitmap bitmap) {

        MediaStore.Images.Media.insertImage(
                getContentResolver(),
                bitmap,
                "IMG_" + System.currentTimeMillis(),
                "Image from Camera"
        );

        Toast.makeText(this, "Image Saved!", Toast.LENGTH_SHORT).show();
    }
}