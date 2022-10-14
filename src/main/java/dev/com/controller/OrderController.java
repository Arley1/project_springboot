package dev.com.controller;

import dev.com.pojo.Order;
import dev.com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/getOrder")
    public String getOrder(){
        return "order 1";
    }

    @GetMapping("/getOrderById/{id}")
    public Order getOrderById(@PathVariable("id") Long id){
        return orderService.getOrderById(id);
    }

    @RequestMapping("/addOrder")
    public String addOrder(Order order){
        orderService.addOrder(order);
        return "ok";
    }

    @GetMapping("/delete/{id}")
    public void deleteOrder(@PathVariable("id") Long id){
        orderService.deleteOrder(id);
    }
}
