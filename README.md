# 原生封装之Android篇
Example for calling native modules and UI components in React Native
###### by Wooko Inc.

## 封装原生模块

分为以下必要几个步骤：

1. 在android端声明原生模块

 一个原生模块是一个继承了ReactContextBaseJavaModule的Java类

2. 实现getName（） 方法
这个函数用于返回一个字符串名字，这个名字在JavaScript端标记这个模块

3. 注解react nave方法以便JS使用， 例如

``` java
    @ReactMethod
    public void show(String msg, int duration, Callback callback){
        Toast.makeText(getReactApplicationContext(),msg,duration).show();
        callback.invoke(msg+" callback");
    }
``` 
#### 需要注意：
* 方法的返回类型必须为void， 因为React Native的跨语言访问是异步进行的，
* 想要给JavaScript返回一个值的办法是使用回调函数或者发送事件
  

4. 创建模块Package 需要实现接口 ReactPackage
主要有两个方法 1. createViewManagers  2 createNativeModules

5. 在 MAinApplication的getPackages（）中注册
``` java
@Override 
protected List<ReactPackage> getPackages() { 
   return Arrays.<ReactPackage>asList( 
      new MainReactPackage(), 
          new MyPackage() //加入这一行，进行注册
      ); 
} 
```

6. 在JS中声明， 可以使用NativeModules

## 封装原生UI控件

分为以下几个步骤：

1. 通过继承simpleViewManager<component name>来声明原生UI控件； i.e. 创建一个ViewManager的子类

2. 实现必须方法
* getName() 这个方法返回JS端获取该控件的名称
* createViewInstance 这个方法返回需要使用的原生组件的实例

3. 设置属性， 使用@ReactProp （or @ReactPropGroup）注解原生代码中设置属性的方法，例如:
``` java
    @ReactProp(name = "src")
    public void setUrl(WebView view,@Nullable String url) {
        view.loadUrl(url);
    }
```
#### 需要注意：
* 方法的第一个参数是要修改属性的视图实例，第二个参数是要设置的属性值。
* 方法的返回值类型必须为void，而且访问控制必须被声明为public。
* JavaScript所得知的属性类型会由该方法第二个参数的类型来自动决定。
* 支持的类型有：boolean, int, float, double, String, Boolean, Integer, ReadableArray, ReadableMap

4. 在ReactPackage中声明
5. 在getpackage中注册， 与封装原生模块非常类似
6. 在js中声明， 使用 requireNativeComponent
