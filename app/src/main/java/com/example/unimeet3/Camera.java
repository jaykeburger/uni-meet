package com.example.unimeet3;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;

public class Camera extends AppCompatActivity {
    private static final int REQUEST_CODE = 22;
    Button btnpicture;
    ImageView imageView;
    ActivityResultLauncher<Intent> activityResultLauncher;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera);
        btnpicture = findViewById(R.id.btncamera_id);
        imageView = findViewById(R.id.image);
        btnpicture.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                // Create intent to launch the camera app
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                activityResultLauncher.launch(cameraIntent);
            }
        });
        // Register an activity result callback to handle the result of the camera app
        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override

            public void onActivityResult(ActivityResult result) {
                // Get the captured image bitmap from the result
                Bundle extras = result.getData().getExtras();
                Uri imageUri;
                Bitmap imageBitmap = (Bitmap) extras.get("data");

                // Create a scaled and copied bitmap
                WeakReference<Bitmap> result_1 = new WeakReference<>(Bitmap.createScaledBitmap(imageBitmap,
                                imageBitmap.getWidth(), imageBitmap.getHeight(), false).
                        copy(Bitmap.Config.RGB_565, true));
                Bitmap bm = result_1.get();
                // Save the image to a file and get the file's content URI
                imageUri = saveImage(bm, Camera.this);
                // Set the image URI to the image view to display the captured image
                imageView.setImageURI(imageUri);
            }
        });
    }

    // Method to save the image to a file and get the file's content URI
    private Uri saveImage(Bitmap image, Camera context) {
        File imagefolder = new File(context.getCacheDir(), "images");
        Uri uri = null;
        try{
            // Create a directory for the images
            imagefolder.mkdirs();
            // Create a file to save the captured image
            File file = new File(imagefolder, "captured_image.jpg");
            FileOutputStream stream = new FileOutputStream(file);
            // Compress and save the image to the file
            image.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            stream.flush();
            stream.close();
            // Get the content URI of the file
            uri = FileProvider.getUriForFile(context.getApplicationContext(), "com.unimeet3.camerafull1"+".provider", file);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return uri ;
    }
}