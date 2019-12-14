package com.pearl.utils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;

import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

/**
 * @author YaBing 508705569@qq.com
 * @version 1.0
 * @description: TODO
 * @date 2019/12/9 0009 10:53
 */
public class QiNiuUploadUtils {

    //设置好账号的ACCESS_KEY和SECRET_KEY
    private static String ACCESS_KEY = QiNiuImageVariable.accessKey; //这两个登录七牛 账号里面可以找到
    private static String SECRET_KEY = QiNiuImageVariable.secretKey;

    //要上传的空间
    private static String bucket = QiNiuImageVariable.bucket; //对应要上传到七牛上 你的那个路径（自己建文件夹 注意设置公开）

    public static void main(String[] args) {
        String localFilePath = "G:\\PearlBusiness\\pearl-utils\\src\\main\\java\\com\\pearl\\utils\\APP首页.png";
        String key = null;
        //密钥配置
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.region2());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        String upToken = auth.uploadToken(bucket);

        try {
            Response response = uploadManager.put(localFilePath, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println("key:"+putRet.key);
            System.out.println("hash:"+putRet.hash);
        } catch (
                QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }

    }








}
