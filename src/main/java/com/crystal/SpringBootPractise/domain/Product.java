package com.crystal.SpringBootPractise.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
public class Product {

    private int id;

    private String productName;

    private int count;

    private BigDecimal price;


    private String size;

    private LocalDateTime modifyTime;
}
