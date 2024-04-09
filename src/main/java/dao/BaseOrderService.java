package dao;

import model.Order;

import java.util.List;

/**
 *  интерфейс BaseOrderService, который содержит методы для работы с заказами.
 */
public interface BaseOrderService {
    void createOrder(Order order);
    void deleteOrder(Long id);
    List<Order> getAllOrders();
}
