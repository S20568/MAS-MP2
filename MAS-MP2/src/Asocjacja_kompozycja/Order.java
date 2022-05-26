package Asocjacja_kompozycja;
/*
    @author Jakub Slusarski, s20568, 20c
*/

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {

    final int minOrderNumber = 1;
    final int maxOrderNumber = 10000;
    int orderNumber;
    int orderAmount;
    LocalDate orderTime;
    Map<Integer, Product> orderedProducts = new HashMap<>();
    String paymentType, deliveryType;
    OrderStatus orderStatus;
    static int counter = 1;
    List<Order> listOfOrders = new ArrayList<>();

    public Order(String paymentType, String deliveryType) {
        this.orderNumber = (int) (Math.random() * (maxOrderNumber-minOrderNumber+1)+minOrderNumber);
        this.orderTime = LocalDate.now();
        this.orderStatus = OrderStatus.Accepted;
        this.paymentType = paymentType;
        this.deliveryType = deliveryType;
        listOfOrders.add(this);
    }

    public void addOrderedProduct(Product orderedProduct) {
        orderedProducts.put(counter, orderedProduct);
        counter++;
        orderAmount += orderedProduct.price;
    }

//    public void setOrderAmount() {
//        int tmpAmount = 0;
//        for (Map.Entry<Integer,Product> entry : orderedProducts.entrySet())
//            if(this.orderAmount == 0)
//                this.orderAmount += entry.getValue().getPrice();
//            else {
//                tmpAmount = this.orderAmount;
//                tmpAmount += entry.getValue().getPrice();
//                this.orderAmount = tmpAmount;
//            }
//    }

    public void setOrderStatus(int orderNumber, OrderStatus newOrderStatus) {
        for(Order o : listOfOrders)
            if(o.orderNumber == orderNumber)
                o.orderStatus = newOrderStatus;
    }

    public void getOrderedProducts() {
        List<Product> listOfOrderedProducts = new ArrayList<>();
        for(Map.Entry<Integer, Product> entry : orderedProducts.entrySet())
            listOfOrderedProducts.add(entry.getValue());
        System.out.println("Ordered products:");
        for (Product p : listOfOrderedProducts){
            System.out.println(p);
        }
        System.out.println(this);
    }



    //Przesłonięcie metod - metoda toString()
    @Override
    public String toString() {
        return "Order: " +
                "orderNumber=" + orderNumber +
                ", orderTime=" + orderTime +
                ", orderAmount=" + orderAmount +
                ", orderStatus='" + orderStatus + '\'' +
                ", paymentType='" + paymentType + '\'' +
                ", deliveryType='" + deliveryType + '\'' +
                '}';
    }
}
