package dev.com.mapper;

import dev.com.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrderMapper {
    public Order getOrderById(Long id);
    public void addOrder(Order order);
    public void deleteOrder(Long id);
}
