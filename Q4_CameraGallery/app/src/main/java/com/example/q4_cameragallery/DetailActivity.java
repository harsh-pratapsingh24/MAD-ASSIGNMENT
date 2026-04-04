package com.example.q4_cameragallery;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView = findViewById(R.id.imageView);
        TextView details = findViewById(R.id.details);
        Button deleteBtn = findViewById(R.id.deleteBtn);

        String path = getIntent().getStringExtra("path");

        File file = new File(path);

        imageView.setImageBitmap(BitmapFactory.decodeFile(path));

        details.setText(
                "Name: " + file.getName() +
                        "\nPath: " + path +
                        "\nSize: " + file.length() +
                        "\nDate: " + file.lastModified()
        );

        deleteBtn.setOnClickListener(v -> {
            new AlertDialog.Builder(this)
                    .setTitle("Delete")
                    .setMessage("Are you sure?")
                    .setPositiveButton("Yes", (d, w) -> {
                        file.delete();
                        finish();
                    })
                    .setNegativeButton("No", null)
                    .show();
        });
    }
}