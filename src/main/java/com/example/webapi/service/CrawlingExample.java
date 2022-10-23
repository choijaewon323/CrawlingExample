package com.example.webapi.service;

import com.example.webapi.domain.Crawl;
import com.example.webapi.domain.CrawlRepository;
import lombok.RequiredArgsConstructor;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CrawlingExample {
    private static String url = "https://finance.naver.com/sise/sise_market_sum.naver";
    private final CrawlRepository crawlRepository;

    @Transactional
    public void process() {
        Connection connection = Jsoup.connect(url);
        Document document = null;

        try {
            document = connection.get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements elements = getDataList(document);

        for (Element temp : elements) {
            Long id = Long.parseLong(temp.text());
            // name
            Element element1 = temp.nextElementSibling();
            String name = element1.text();
            // currentPrice
            element1 = element1.nextElementSibling();
            String currentPrice = element1.text();
            // yesterday
            element1 = element1.nextElementSibling();
            String yesterday = element1.text();
            // dropRatio
            element1 = element1.nextElementSibling();
            String dropRatio = element1.text();
            // parValue
            element1 = element1.nextElementSibling();
            String parValue = element1.text();
            // totalPrice
            element1 = element1.nextElementSibling();
            String totalPrice = element1.text();
            // numberOfListed
            element1 = element1.nextElementSibling();
            String numberOfListed = element1.text();
            // foreignRatio
            element1 = element1.nextElementSibling();
            String foreignRatio = element1.text();
            // quantity
            element1 = element1.nextElementSibling();
            String quantity = element1.text();
            // per
            element1 = element1.nextElementSibling();
            String per = element1.text();
            // roe
            element1 = element1.nextElementSibling();
            String roe = element1.text();

            Crawl newCrawl = new Crawl(id, name, currentPrice,yesterday,dropRatio,parValue,totalPrice,numberOfListed,foreignRatio,quantity, per, roe);
            crawlRepository.save(newCrawl);
        }
    }

    @Transactional
    public List<Crawl> getCrawls() {
        List<Crawl> results = crawlRepository.findAll();
        crawlRepository.deleteAll();
        return results;
    }

    private Elements getDataList(Document document) {
        List<String> list = new ArrayList<>();
        Elements elements = document.getElementsByClass("no");
        return elements;
    }
}
