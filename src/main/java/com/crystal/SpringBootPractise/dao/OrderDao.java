package com.crystal.SpringBootPractise.dao;

import com.crystal.SpringBootPractise.domain.Order;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao {
    @Insert("insert into t_order values(#{orderId},#{userId})")
    void addOrder(Order order);
}
