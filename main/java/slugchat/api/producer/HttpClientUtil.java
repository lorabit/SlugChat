package main.java.slugchat.api.producer;

import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class HttpClientUtil {

    public static String post(String url, String postData) throws IOException{
        URLConnection connection = new URL(url).openConnection();
        connection.setDoInput (true);
        connection.setDoOutput (true);
        connection.setUseCaches (false);
        connection.setRequestProperty("Content-Type","application/json");
        byte[] postDataBytes = postData.toString().getBytes("UTF-8");
        connection.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
        connection.connect();
        connection.getOutputStream ().write(postDataBytes);
        InputStream response = connection.getInputStream();
        String jsonString = CharStreams.toString(new InputStreamReader(response, Charsets.UTF_8));
        return jsonString;
    }


    private HttpClientUtil(){}
}
