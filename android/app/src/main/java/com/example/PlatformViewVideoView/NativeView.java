package com.example.PlatformViewVideoView;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Map;

import io.flutter.plugin.platform.PlatformView;

class NativeView implements PlatformView {
    View view;

    NativeView(@NonNull Context context, int id, @Nullable Map<String, Object> creationParams) {
        view = LayoutInflater.from(context).inflate(R.layout.layout_native_view, null);

        VideoView videoView = view.findViewById(R.id.video);
        String uri = "android.resource://" + context.getPackageName() + "/" + R.raw.big_buck_bunny;
        videoView.setVideoURI(Uri.parse(uri));
        MediaController mediaController = new MediaController(context);
        videoView.setMediaController(mediaController);

        videoView.requestFocus();
        videoView.start();

    }

    @NonNull
    @Override
    public View getView() {
        return view;
    }

    @Override
    public void dispose() {
    }
}