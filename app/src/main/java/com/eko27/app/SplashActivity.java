package com.eko27.app;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        VideoView videoView = (VideoView) findViewById(R.id.introVideo);

        // Videoni res/raw/video.mp4 dan olish
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.video;
        videoView.setVideoURI(Uri.parse(videoPath));

        // Video tugagach nima bo'lishi kerak?
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                // MainActivity (Sayt) ga o'tish
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                // Bu oynani yopish (orqaga bosganda video qayta chiqmasligi uchun)
                finish();
            }
        });

        // Videoni boshlash
        videoView.start();
    }
}
