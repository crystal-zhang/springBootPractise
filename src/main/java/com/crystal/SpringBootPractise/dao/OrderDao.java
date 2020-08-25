package com.crystal.SpringBootPractise.dao;

import com.crystal.SpringBootPractise.domain.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {
    @Insert("insert into t_order values(#{orderId},#{userId})")
    void addOrder(Order order);
    @Select("select * from t_order order by order_id asc limit 10")
    List<Order> getOrderList();
}
