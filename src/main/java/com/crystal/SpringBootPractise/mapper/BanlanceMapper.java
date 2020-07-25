package com.crystal.SpringBootPractise.mapper;

import com.crystal.SpringBootPractise.domain.Balance;
import com.crystal.SpringBootPractise.vo.BalanceVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BanlanceMapper {
    BanlanceMapper INSTANCE = Mappers.getMapper(BanlanceMapper.class);

    Balance BalanceVOToBalance(BalanceVo balanceVo);
}
