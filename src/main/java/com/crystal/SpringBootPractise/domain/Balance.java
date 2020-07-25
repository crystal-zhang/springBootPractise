package com.crystal.SpringBootPractise.domain;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class Balance {
    private int id;
    private String username;
    private BigDecimal userBalance;
}
