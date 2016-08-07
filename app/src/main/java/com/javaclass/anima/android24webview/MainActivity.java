package com.javaclass.anima.android24webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button back,forward,reload,go;
    private EditText url;
    private WebView webview;
    private WebViewClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webview = (WebView) findViewById(R.id.webview);
        url = (EditText) findViewById(R.id.url);
        back = (Button) findViewById(R.id.back);
        forward = (Button) findViewById(R.id.forward);
        reload = (Button) findViewById(R.id.reload);
        go = (Button) findViewById(R.id.go);

        // 設定按下『向後』的按鈕功能
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bacWebPage();
            }
        });

        // 設定按下『向前』的按鈕功能
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                forwardWebPage();
            }
        });

        // 設定按下『重載』的按鈕功能
        reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reloadWebPage();
            }
        });

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goWebPage();
            }
        });
        // 進行 WebView 元件初始設定
        initWeb();
    }

    private void initWeb(){
        client = new WebViewClient();
        webview.setWebViewClient(client);
    }

    private void bacWebPage(){
        webview.goBack();
    }

    private void forwardWebPage(){
        webview.goForward();
    }

    private void reloadWebPage(){
        webview.reload();
    }

    private void goWebPage(){
        String goUrl = url.getText().toString();
        goUrl = "http://"+goUrl;
        webview.loadUrl(goUrl);
    }

}

