package com.semo.jsoup.jsoupproject;

import com.semo.oracle.OracleTest;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@Slf4j
public class JsoupProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(JsoupProjectApplication.class, args).getBean(JsoupProjectApplication.class).run();
    }

    void run() {
        String url = "https://www.ppomppu.co.kr/zboard/zboard.php?";
        String queryString = "id=ppomppu";
        List<Integer> pages = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        log.info("hi hello");
        Document doc = null;
        try {
            for (int page: pages) {
                doc = Jsoup.connect(url+queryString+"&"+page).get();
                log.info(String.valueOf(doc.select(".list_title").html()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void run2() {
        String url = "https://eomisae.co.kr";
        log.info("check");
        List<String> pages = Arrays.asList("fs","os","rt");
        Document doc = null;
        try {
            for (String page: pages) {
                doc = Jsoup.connect(url+"/"+page).get();
                log.info(String.valueOf(doc.select(".card_content").select("a.pjax").html()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void run3() {
        String url = "https://bbs.ruliweb.com/market/board/1020";

    }

}
