package com.ashwani.ashtv;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class StandaloneActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stanalone);

        Button btnPlayVideo = findViewById(R.id.btnPlayVideo);
        Button btnPlayList = findViewById(R.id.btnPlayList);

        btnPlayVideo.setOnClickListener(this);
        btnPlayList.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;

        switch (view.getId()) {
            case R.id.btnPlayVideo:
                intent = YouTubeStandalonePlayer.createVideoIntent(this,
                        YoutubeActivity.GOOGLE_API_KEY, YoutubeActivity.YOUTUBE_VIDEO_ID, 0, true, false);
                break;
            case R.id.btnPlayList:
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this, YoutubeActivity.GOOGLE_API_KEY,
                        YoutubeActivity.YOUTUBE_PLAYLIST, 0, 0, true, true);
                break;
            default:

        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}
