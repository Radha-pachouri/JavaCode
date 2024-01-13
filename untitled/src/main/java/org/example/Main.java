package org.example;

import netscape.javascript.JSObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class Main {
    public static void main(String[] args) {
       URL url = null;
        HttpURLConnection connection = null;
        Integer responseCode = 0;
        String urlString = "http://13.232.100.149:8080/order";

        try {
            url = new URL(urlString);
        } catch (Exception e) {
           System.out.println("prblm in url");
        }

        //connection

        try {
            connection = (HttpURLConnection) url.openConnection();
            responseCode = connection.getResponseCode();
        } catch (Exception e) {
           System.out.print("problem in connection");
        }

        if(responseCode==200){
         InputStreamReader inputStreamReader= new  InputStreamReader(connection.getInputStream());
            BufferedReader reader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();
            String readData = null;

            while((readData=reader.readLine())!=null){
                stringBuilder.append(readData);
            }
            System.out.println(stringBuilder.toString());
            JSONObject jsonObject = new JSONObject(stringBuilder.toString());
            System.out.println(jsonObject.toString);

        }
        else{
            System.out.print("server problem");
        }

    }
}