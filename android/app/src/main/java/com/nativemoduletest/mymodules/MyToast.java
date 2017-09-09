package com.nativemoduletest.mymodules;

import android.widget.Toast;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;



public class MyToast extends ReactContextBaseJavaModule{


    public MyToast(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "myToast1";
    }

    @ReactMethod
    public void show(String msg, int duration, Callback cb){
        Toast.makeText(getReactApplicationContext(),msg,duration).show();
        cb.invoke("native");

    }
}

/**
 * Created by zhexu on 2017-09-08.
 */

/*
public class MyToast extends ReactContextBaseJavaModule {
    private static final String MODULE_NAME = "myToast";

    public MyToast(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return MODULE_NAME;
    }

    @ReactMethod
    public void show(String msg, int duration, Callback callback){
        //Toast.makeText(getReactApplicationContext(),msg,duration).show();
        //callback.invoke(msg+" callback");
    }
}
*/