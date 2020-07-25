package com.crystal.SpringBootPractise.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
public class BalanceVo {
    private String username;
    private BigDecimal UserBalance;
}
