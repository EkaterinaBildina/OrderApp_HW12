package dao;

import model.Order;

import java.util.List;

/**
 *  интерфейс OrderDAO, который  выполняет операции CRUD для объектов Order.
 */
public interface OrderDAO {
    Order save(Order order);
    void deleteById(Long id);
    List<Order> findAll();
}

