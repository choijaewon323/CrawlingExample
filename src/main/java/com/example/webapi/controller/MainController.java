package com.example.webapi.controller;

import com.example.webapi.domain.Crawl;
import com.example.webapi.service.CrawlingExample;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MainController {
    private final CrawlingExample crawlingExample;

    @GetMapping("/api/crawl")
    public List<Crawl> getStocks() {
        crawlingExample.process();
        return crawlingExample.getCrawls();
    }
}
