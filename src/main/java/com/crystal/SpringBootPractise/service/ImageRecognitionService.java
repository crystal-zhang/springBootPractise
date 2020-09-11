package com.crystal.SpringBootPractise.service;

import ch.qos.logback.core.util.FileUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.util.Base64Util;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 图片识别服务
 * (使用线程处理)
 */
public class ImageRecognitionService {

    private static String client_id = "DMrsM1gkVcdPZDjavTtrqd2n";
    private static String client_secret = "annamcVQTj1GKQ7oNaKLM23QGPtiipMt";
    private static String access_token_url = "https://aip.baidubce.com/oauth/2.0/token?grant_type=client_credentials&client_id=CLIENT_ID&client_secret=CLIENT_SECRET";
    private static String animal_recog_url="https://aip.baidubce.com/rest/2.0/image-classify/v1/animal";
    /**
     * 获取百度图片识别服务的Access Token
     *
     * @return access_token
     */
    private static HttpEntity getAuth() {
        CloseableHttpClient client = HttpClients.createDefault();
        String url = access_token_url.replace("CLIENT_ID", client_id).replace("CLIENT_SECRET", client_secret);
        HttpPost postRequest = new HttpPost(url);
        CloseableHttpResponse httpResponse = null;
        HttpEntity entity = null;
        String result = null;
        try {
            httpResponse = client.execute(postRequest);
            entity = httpResponse.getEntity();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entity;
    }

    public static String getAccessToken() throws IOException {
        String entityStr = EntityUtils.toString(getAuth(),"UTF-8");
        JSONObject jsonObject = JSONObject.parseObject(entityStr);
        return jsonObject.getString("access_token");
    }

    /**
     * 动物图片识别
     * @return
     */
    public static String AnimalRecog(String filePath) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        String accesstoken = getAccessToken();
        HttpPost postRequest = new HttpPost(animal_recog_url+"?access_token="+accesstoken);
        Header header = new BasicHeader("Content-Type","application/x-www-form-urlencoded");
        postRequest.setHeader(header);
        byte[] imgData = FileUtils.readFileToByteArray(new File(filePath));
        System.err.println(imgData);
        String imgStr = Base64.encodeBase64String(imgData);
        System.err.println(imgStr);
        String imgParam = URLEncoder.encode(imgStr, "UTF-8");
        HttpEntity paramEntity = new StringEntity("image="+imgParam, Charset.forName("UTF-8"));
        postRequest.setEntity(paramEntity);
        CloseableHttpResponse httpResponse = null;
        HttpEntity entity = null;
        String result = null;
        httpResponse = client.execute(postRequest);
        entity = httpResponse.getEntity();
        result = EntityUtils.toString(entity);
        return result;
    }




    public static void main(String[] args) throws IOException, InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        long start =  new Date().getTime();
       /* new Thread(()->{
            try {
                System.out.println(AnimalRecog("F:\\360Downloads\\cat.jpg"));
                countDownLatch.countDown();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                System.out.println(AnimalRecog("F:\\360Downloads\\fox.jpg"));
                countDownLatch.countDown();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();*/

        //使用线程池处理
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(()->{
            try {
                System.out.println(AnimalRecog("F:\\360Downloads\\cat.jpg"));
                countDownLatch.countDown();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        executorService.submit(()->{
            try {
                System.out.println(AnimalRecog("F:\\360Downloads\\fox.jpg"));
                countDownLatch.countDown();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        countDownLatch.await();
        long end =  new Date().getTime();
        System.out.println("工消耗时间:"+(end-start));




    }
}
