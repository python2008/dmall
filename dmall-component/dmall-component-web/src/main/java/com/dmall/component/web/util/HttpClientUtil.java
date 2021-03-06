package com.dmall.component.web.util;

import com.google.common.collect.Lists;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.InputStreamBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: created by hang.yu on 2019/12/17 15:21
 */
public class HttpClientUtil {

    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final String FILE_PART = "files";
    private CloseableHttpClient httpClient;

    public HttpClientUtil(CloseableHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public static void main(String[] args) {
        sendBrowser();
    }

    /**
     * 模拟浏览器发送请求
     */
    public static String sendBrowser() {
        //创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        RequestConfig config = RequestConfig.custom().build();
        HttpGet httpget = new HttpGet("D:\\jd.html");
        //使用配置
        httpget.setConfig(config);
        //设置请求头
        httpget.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        httpget.setHeader("Accept-Encoding", "gzip, deflate");
        httpget.setHeader("Accept-Language", "zh-CN,zh;q=0.8");
        httpget.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.91 Safari/537.36");
        String responseContent = null;
        try {
            CloseableHttpResponse response = httpClient.execute(httpget);
            HttpEntity entity = response.getEntity();
            responseContent = EntityUtils.toString(entity, "utf-8");
            System.out.println(responseContent);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return responseContent;
    }

    /**
     * 执行post请求
     */
    public String post(String httpUrl) {
        HttpPost httpPost = new HttpPost(httpUrl);
        return sendHttpPost(httpPost);
    }

    /**
     * 执行带参数的post请求
     */
    public String post(String httpUrl, String params) {
        HttpPost httpPost = new HttpPost(httpUrl);
        try {
            StringEntity stringEntity = new StringEntity(params, DEFAULT_CHARSET);
            stringEntity.setContentType(ContentType.APPLICATION_FORM_URLENCODED.getMimeType());
            httpPost.setEntity(stringEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sendHttpPost(httpPost);
    }

    /**
     * 发送带参数的 post请求
     */
    public String post(String httpUrl, Map<String, String> maps) {
        HttpPost httpPost = new HttpPost(httpUrl);
        List<NameValuePair> nameValuePairs = Lists.newArrayList();
        for (String key : maps.keySet()) {
            nameValuePairs.add(new BasicNameValuePair(key, maps.get(key)));
        }
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, DEFAULT_CHARSET));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sendHttpPost(httpPost);
    }

    /**
     * 发送 post请求（带文件）
     *
     * @param httpUrl   地址
     * @param maps      参数
     * @param fileLists 附件
     */
    public String post(String httpUrl, Map<String, String> maps, List<File> fileLists) {
        HttpPost httpPost = new HttpPost(httpUrl);
        MultipartEntityBuilder meBuilder = MultipartEntityBuilder.create();
        for (String key : maps.keySet()) {
            meBuilder.addPart(key, new StringBody(maps.get(key), ContentType.TEXT_PLAIN));
        }
        for (File file : fileLists) {
            FileBody fileBody = new FileBody(file);
            meBuilder.addPart(FILE_PART, fileBody);
        }
        HttpEntity reqEntity = meBuilder.build();
        httpPost.setEntity(reqEntity);
        return sendHttpPost(httpPost);
    }

    /**
     * 一次传多张图片加普通参数
     */
    public String post(String httpUrl, Map<String, String> maps, Map<String, byte[]> data) {
        HttpPost httpPost = new HttpPost(httpUrl);
        MultipartEntityBuilder meBuilder = MultipartEntityBuilder.create();
        meBuilder.setCharset(Charset.forName(DEFAULT_CHARSET));
        meBuilder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        if (maps != null) {
            for (String key : maps.keySet()) {
                meBuilder.addPart(key, new StringBody(maps.get(key), ContentType.DEFAULT_TEXT));
            }
        }
        if (data != null) {
            for (String key : data.keySet()) {
                ByteArrayBody byteArrayBody = new ByteArrayBody(data.get(key), ContentType.DEFAULT_BINARY, key);
                meBuilder.addPart("files", byteArrayBody);
            }
        }
        HttpEntity reqEntity = meBuilder.build();
        httpPost.setEntity(reqEntity);
        return sendHttpPost(httpPost);
    }

    public String postFile(String httpUrl, Map<String, Object> data) {
        HttpPost httpPost = new HttpPost(httpUrl);
        MultipartEntityBuilder meBuilder = MultipartEntityBuilder.create();
        meBuilder.setCharset(Charset.forName("utf-8"));
        meBuilder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        if (data != null) {
            for (String key : data.keySet()) {
                if (data.get(key) instanceof String) {
                    try {
                        meBuilder.addPart(key, new StringBody((String) data.get(key), Charset.forName(DEFAULT_CHARSET)));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                } else if (data.get(key) instanceof byte[]) {
                    ByteArrayBody byteArrayBody = new ByteArrayBody((byte[]) data.get(key), ContentType.DEFAULT_BINARY, key);
                    meBuilder.addPart(FILE_PART, byteArrayBody);
                } else if (data.get(key) instanceof File) {
                    FileBody fileBody = new FileBody((File) data.get(key));
                    meBuilder.addPart(FILE_PART, fileBody);
                } else if (data.get(key) instanceof InputStream) {
                    InputStreamBody inputStreamBody = new InputStreamBody((InputStream) data.get(key), key);
                    meBuilder.addPart(FILE_PART, inputStreamBody);
                }
            }
        }
        HttpEntity reqEntity = meBuilder.build();
        httpPost.setEntity(reqEntity);
        return sendHttpPost(httpPost);
    }

    /**
     * 执行get请求
     */
    public String get(String url) {
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        httpGet.setHeader("Accept-Encoding", "gzip, deflate");
        httpGet.setHeader("Accept-Language", "zh-CN,zh;q=0.8");
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.91 Safari/537.36");

        return sendHttpGet(httpGet);
    }

    /**
     * 发送http的get请求
     */
    private String sendHttpGet(HttpGet httpGet) {
        CloseableHttpResponse response = null;
        HttpEntity httpEntity = null;
        String responseContent = null;
        try {
            response = httpClient.execute(httpGet);
            httpEntity = response.getEntity();
            responseContent = EntityUtils.toString(httpEntity, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("");
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e1) {
            }
        }
        return responseContent;
    }

    /**
     * 发送http的post请求
     */
    private String sendHttpPost(HttpPost httpPost) {
        CloseableHttpResponse response = null;
        HttpEntity entity = null;
        String responseContent = null;
        try {
            // 默认的方式创建client
            response = httpClient.execute(httpPost);
            entity = response.getEntity();
            InputStream inputStream = entity.getContent();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            StringBuffer sb = new StringBuffer();
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            responseContent = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e1) {
                // ignore
            }
        }
        return responseContent;
    }

}
