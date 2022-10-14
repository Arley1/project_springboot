package dev.com.pojo;

public class Order {
    private String orderName;
    private Long orderId;
    private String address;
    private Double price;
    private Integer num;

    public Order(){

    }

//    public Order(String orderName, Long orderId, String address, Double price, Integer num) {
//        this.orderName = orderName;
//        this.orderId = orderId;
//        this.address = address;
//        this.price = price;
//        this.num = num;
//    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", num=" + num +
                '}';
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
