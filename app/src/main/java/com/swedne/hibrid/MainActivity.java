package com.swedne.hibrid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private WebView mWebView;
    private final String HTML_URL = "file:///android_asset/index.html";
    private TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mWebView = findViewById(R.id.wb_main);
        tvTitle = findViewById(R.id.tv_title);
        WebViewManager.initCommonAttributes(mWebView, this);
        mWebView.addJavascriptInterface(new JavaScriptLocalObj(), "local_obj");
        mWebView.loadUrl(HTML_URL);
        mWebView.setWebChromeClient(new MyWebChromeClient());
        mWebView.setWebViewClient(new MyWebViewClient());
    }

    private class MyWebChromeClient extends WebChromeClient {
        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            tvTitle.setText(title);
        }

    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            mWebView.loadUrl("javascript:showAlert()");
        }
    }
}
