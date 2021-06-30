package org.zerock.test;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;

public class SimpleTest {

    @Test
    public void testSave2()throws Exception {

        String path ="https://image-comic.pstatic.net/webtoon/20853/50/20200221113351_d37ebf82b5f17380e3d763379f0b1a51_IMAG01_1.jpg";

        URL url = new URL(path);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        System.out.println(urlConnection);

        urlConnection.setDoOutput(true);
        urlConnection.setDoInput(true);
        urlConnection.setUseCaches(false);

        urlConnection.setRequestProperty("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.114 Safari/537.36");

        InputStream in = urlConnection.getInputStream();

        File fos = new File("D:\\zzz\\sample5.jpg");


        Files.copy(in, fos.toPath());

    }


    @Test
    public void test1()throws Exception {

        System.out.println("Test1................");
        Document doc = Jsoup.connect("https://comic.naver.com/bestChallenge/list.nhn?titleId=701701").get();

        //System.out.println(doc);

        Elements tds = doc.select(".viewList td img");

        tds.forEach(element -> {
            String imgURL = element.attr("src");
            System.out.println(imgURL);
            String title = element.attr("title");
            System.out.println(title);
        });
    }

    @Test
    //bad code
    public void testSave() throws Exception {
        //실제 이미지 경로
        //String path = "https://thumbnail9.coupangcdn.com/thumbnails/remote/230x230ex/image/retail/images/81447876542865-b2de1636-9d42-4236-be96-aad9ff331eb2.jpg";

        String path ="https://image-comic.pstatic.net/nas/user_contents_data/challenge_comic/2021/06/28/fa3030/upload_3473738102062789987.jpeg";

        URL url = new URL(path);

        //read
        InputStream in = url.openStream();

        File fos = new File("D:\\zzz\\sample3.jpg");


        Files.copy(in, fos.toPath());

    }
}