package com.company;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
//import java.util.Properties;

public class Images {
    public static void Download(String url) {
        downloadPicture(url);
    }
    //链接url下载图片
    private static void downloadPicture(String urlList) {
       // Properties prop = System.getProperties();
//        prop.setProperty("http.proxyHost", "192.168.137.1");
//        prop.setProperty("http.proxyPort", "1080");
//        prop.setProperty("https.proxyHost", "192.168.137.1");
//        prop.setProperty("https.proxyPort", "1080");
        URL url =null;
        int imageNumber = 1;

        try {
            url = new URL(urlList);
            DataInputStream dataInputStream = new DataInputStream(url.openStream());

            String imageName =  "/root/1.jpg";
            //System.out.println(urlList);

            FileOutputStream fileOutputStream = new FileOutputStream(new File(imageName));
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int length;

            while ((length = dataInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            byte[] context=output.toByteArray();
            fileOutputStream.write(output.toByteArray());
            dataInputStream.close();
            fileOutputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
