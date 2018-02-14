package com.swedne.hibrid;

import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/1/12.
 */

public class JavaScriptLocalObj {
    @JavascriptInterface
    public void toastTitle(String title) {
        Toast.makeText(MyApplication.getInstace(), title, Toast.LENGTH_LONG).show();
    }

}
