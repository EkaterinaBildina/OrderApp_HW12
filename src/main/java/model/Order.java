package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int id;
    private String customerName;
    private String shirtName;
    private int quantity;
    private int amount;
    private int totalPrice;
    private OrderStatus orderStatus;

    public Order(String customerName, String shirtName, int quantity) {
        this.customerName = customerName;
        this.shirtName = shirtName;
        this.quantity = quantity;
    }

    public void setCreation(LocalDateTime now) {
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getShirtName() {
        return shirtName;
    }

    public void setShirtName(String shirtName) {
        this.shirtName = shirtName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getTitle() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", shirtName='" + shirtName + '\'' +
                ", quantity=" + quantity +
                ", amount=" + amount +
                ", totalPrice=" + totalPrice +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
