package com.nativemoduletest;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.nativemoduletest.mycomponents.MyWebView;
import com.nativemoduletest.mymodules.MyToast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by zhexu on 2017-09-08.
 */

public class MyPackage implements ReactPackage {
    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        List<ViewManager> components = new ArrayList<>();
        components.add(new MyWebView());
        return components;
    }

    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        List<NativeModule> modules = new ArrayList<>();
        modules.add(new MyToast(reactContext));
        return modules;
    }
}
