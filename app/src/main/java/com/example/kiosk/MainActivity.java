package com.example.kiosk;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;

import app.num.numandroidpagecurleffect.PageCurlView;


public class MainActivity extends AppCompatActivity {


    private WebView webView1;
    private WebView webView2;
    private WebView webView3;


    private ImageButton webBtn1;
    private ImageButton webBtn2;
    private ImageButton webBtn3;

    private Button closeWeb;

    private ViewPager pdfsliding;



    private VideoView vv;
    private MediaController mediacontroller;
    private Uri uri;
    private boolean isContinuously = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PageCurlView pageCurlView = (PageCurlView) findViewById(R.id.pagecurl_view);


        List<Integer> pages_id = new ArrayList<>();
        pages_id.add(R.drawable.bglogo);
        pages_id.add(R.drawable.bglogo);

        pageCurlView.setCurlView(pages_id);
        pageCurlView.setCurlSpeed(65);

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
        webView2 = findViewById(R.id.web2);
        webView3 = findViewById(R.id.web3);


        webView1 = findViewById(R.id.web1);
        webView1.loadUrl("https://www.fundamentum.co.za/");
        webView1.getSettings().setJavaScriptEnabled(true);
        webView1.setWebViewClient(new WebViewClient());


        webView2 = findViewById(R.id.web2);
        webView2.loadUrl("https://boogertmanandpartners.com/");
        webView2.getSettings().setJavaScriptEnabled(true);
        webView2.setWebViewClient(new WebViewClient());


        webView3 = findViewById(R.id.web3);
        webView3.loadUrl("https://www.mdsarch.co.za/");
        webView3.getSettings().setJavaScriptEnabled(true);
        webView3.setWebViewClient(new WebViewClient());

        webBtn1 = findViewById(R.id.web1Btn);
        webBtn2 = findViewById(R.id.web2Btn);
        webBtn3 = findViewById(R.id.web3Btn);
        closeWeb = findViewById(R.id.closeWeb);


        webBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView1.setVisibility(View.VISIBLE);
                closeWeb.setVisibility(View.VISIBLE);
            }
        });

        webBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView2.setVisibility(View.VISIBLE);
                closeWeb.setVisibility(View.VISIBLE);
            }
        });


        webBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView3.setVisibility(View.VISIBLE);
                closeWeb.setVisibility(View.VISIBLE);
            }
        });


        closeWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView1.setVisibility(View.GONE);
                webView2.setVisibility(View.GONE);
                webView3.setVisibility(View.GONE);
                closeWeb.setVisibility(View.GONE);
            }
        });


    }
}
