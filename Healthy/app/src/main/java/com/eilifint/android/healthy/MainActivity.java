package com.eilifint.android.healthy;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.felipecsl.gifimageview.library.GifImageView;

import java.io.IOException;
import java.io.InputStream;

/**
 * This app teaches five ways to stay healthy.
 * This is the splash screen
 */
public class MainActivity extends AppCompatActivity {

    private GifImageView gifView;

    @Override
    protected void onStop() {
        super.onStop();
        //Stopping the animation
        gifView.stopAnimation();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //Starting the animation
        gifView.startAnimation();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        //Full screen activity
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //invoking the method
        displayAnimation();

        //Delays 4 seconds to launch activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent homeMenu = new Intent(MainActivity.this, HomeMenu.class);
                startActivity(homeMenu);
                finish();
            }
        }, 4000);

    }

    /**
     * This method displays the loading gif animation.
     */
    public void displayAnimation() {

        gifView = (GifImageView) findViewById(R.id.loading);
        // Reads bytes from gif file
        InputStream inputStream;

        // handles the exception whenever an input or output operation is failed or interpreted
        try {
            inputStream = getAssets().open("healthy_loading.gif");
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            inputStream.close();

            gifView.setBytes(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
