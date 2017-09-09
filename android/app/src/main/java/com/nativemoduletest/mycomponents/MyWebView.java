package com.nativemoduletest.mycomponents;

import android.support.annotation.Nullable;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

/**
 * Created by zhexu on 2017-09-08.
 */

public class MyWebView extends SimpleViewManager<WebView>{
    @Override
    public String getName() {
        return "myWebView";
    }

    @Override
    protected WebView createViewInstance(ThemedReactContext reactContext) {
        WebView webView = new WebView(reactContext);

        // webview settings

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAppCacheEnabled(true);
        webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

        return webView;
    }

    /**
     *  第一个参数是要修改属性的视图实例，
     *  第二个参数是要设置的属性值。
     *
     *  方法的返回值类型必须为void，而且访问控制必须被声明为public。
     *
     *  JavaScript所得知的属性类型会由该方法第二个参数的类型来自动决定。
     *
     *  支持的类型有：
     *  boolean,
     *  int,
     *  float,
     *  double,
     *  String,
     *  Boolean,
     *  Integer,
     *  ReadableArray,
     *  ReadableMap
     *
     * @param view
     * @param url
     */
    @ReactProp(name = "src111")
    public void setUrl(WebView view,@Nullable String url) {
        view.loadUrl(url);
    }

}
