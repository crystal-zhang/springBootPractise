package com.crystal.SpringBootPractise;

import com.crystal.SpringBootPractise.domain.Balance;
import com.crystal.SpringBootPractise.mapper.BanlanceMapper;
import com.crystal.SpringBootPractise.vo.BalanceVo;

import java.math.BigDecimal;

public class MapStructTest {

    public static void main(String[] args) {
        BanlanceMapper mapper = BanlanceMapper.INSTANCE;
        BalanceVo vo = new BalanceVo("sdfsfd",new BigDecimal(1));
        Balance b= mapper.BalanceVOToBalance(vo);
        System.out.println(b);
    }
}
