package com.example.webapi.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Crawl {
    @Id
    private Long id;

    private String name;
    private String currentPrice;
    private String yesterday;
    private String dropRatio;
    private String parValue;
    private String totalPrice;
    private String numberOfListed;
    private String foreignRatio;
    private String quantity;
    private String per;
    private String roe;

    public Crawl(Long id, String name, String currentPrice, String yesterday, String dropRatio, String parValue, String totalPrice, String numberOfListed, String foreignRatio, String quantity, String per, String roe) {
        this.id = id;
        this.name = name;
        this.currentPrice = currentPrice;
        this.yesterday = yesterday;
        this.dropRatio = dropRatio;
        this.parValue = parValue;
        this.totalPrice = totalPrice;
        this.numberOfListed = numberOfListed;
        this.foreignRatio = foreignRatio;
        this.quantity = quantity;
        this.per = per;
        this.roe = roe;
    }
}
