package com.aspsine.mobi.androidmvpdemos.demo0.http;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.BinaryHttpResponseHandler;
import com.loopj.android.http.FileAsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * Created by hzf on 2017/3/2 0002.
 * AsyncHttpClient 快速开发网络框架
 */

public class HttpUtil {
    private static AsyncHttpClient client = new AsyncHttpClient();
    private static final String BASE_URL = "http://112.124.120.134/subdomain/8/?url=";
    public static AsyncHttpClient getClient() {
        return client;
    }
    static {
        client.setTimeout(5000); // 设置链接超时，如果不设置，默认为10s
        client.addHeader("Charset", "UTF-8");
    }
    /**
     * ***************************** get *******************************************
     */
    // 用一个完整url获取一个string对象
    public static void  get(String url, AsyncHttpResponseHandler handler){
        client.get(getAbsoluteUrl(url),handler);
    }
    // url里面带参数
    public static void  get(String url, RequestParams params,AsyncHttpResponseHandler handler){
         client.get(getAbsoluteUrl(url),params,handler);
    }
    // 不带参数，获取json对象或者数组
    public  static  void  get(String url, JsonHttpResponseHandler httpResponseHandler){
        client.get(getAbsoluteUrl(url),httpResponseHandler);
    }
    // 带参数，获取json对象或者数组
    public static void get(String url,RequestParams params,JsonHttpResponseHandler httpResponseHandler){
        client.get(getAbsoluteUrl(url),params,httpResponseHandler);
        System.out.println(getAbsoluteUrl(url));
        String s = client.getUrlWithQueryString(false, getAbsoluteUrl(url), params);
        System.out.println("ss==" + s);
    }
    // 下载数据使用，会返回byte数据
    public static void get(String uString, BinaryHttpResponseHandler bHandler) {
        client.get(getAbsoluteUrl(uString), bHandler);
    }
    /**
     * *************************** post *************************************
     */
    // 用一个完整url获取一个string对象
    public static void  post(String url,AsyncHttpResponseHandler handler){
          client.post(getAbsoluteUrl(url),handler);
          System.out.println("urlString=" + url);
    }
    // url里面带参数
    public static void post(String urlString, RequestParams params, AsyncHttpResponseHandler res) {

        client.post(getAbsoluteUrl(urlString), params, res);

    }
    // 不带参数，获取json对象或者数组
    public static void post(String urlString, JsonHttpResponseHandler res) {

        client.post(getAbsoluteUrl(urlString), res);

    }
    @SuppressWarnings("static-access")
    public static void post(String urlString, RequestParams params, JsonHttpResponseHandler res) {
        System.out.println("地址" + client.getUrlWithQueryString(false, getAbsoluteUrl(urlString), params));
        client.post(getAbsoluteUrl(urlString), params, res);
        // client.post(urlString, params, res);

    }
    // 下载数据使用，会返回byte数据
    public static void post(String uString, BinaryHttpResponseHandler bHandler) {

        client.post(getAbsoluteUrl(uString), bHandler);

    }

    /**
     * 下载文件
     *
     * @param uString
     * @param file
     */
    public static void downFile(String uString, FileAsyncHttpResponseHandler file) {
        client.post(uString, file);
    }
    /**
     * 上传文件
     *
     * @param uString
     * @param params
     * @param handler
     */
    public static void uploadFile(String uString, RequestParams params, AsyncHttpResponseHandler handler) {
        client.removeAllHeaders();
        client.post(uString, params, handler);
    }
    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }
}
