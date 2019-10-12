package com.example.kiosk;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {


    private WebView webView1;
    private WebView webView2;
    private WebView webView3;


    private ImageButton webBtn1;
    private ImageButton webBtn2;
    private ImageButton webBtn3;



    private ViewPager pdfsliding;



    private VideoView vv;
    private MediaController mediacontroller;
    private Uri uri;
    private boolean isContinuously = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        vv = (VideoView) findViewById(R.id.videoView);

        mediacontroller = new MediaController(this);
        mediacontroller.setAnchorView(vv);
        String uriPath = "android.resource://com.example.kiosk/"+R.raw.hope;  //update package name
        uri = Uri.parse(uriPath);

        vv.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if(isContinuously){
                    vv.start();
                }
            }
        });


        vv.setMediaController(mediacontroller);
        vv.setVideoURI(uri);
        vv.requestFocus();
        vv.start();



        webView1 = findViewById(R.id.web1);
        webView1.loadUrl("https://www.fundamentum.co.za/");
        webView1.getSettings().setJavaScriptEnabled(true);
        webView1.setWebViewClient(new WebViewClient());


        webBtn1 = findViewById(R.id.web1Btn);


        webBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView1.setVisibility(View.VISIBLE);
            }
        });

    }
}
