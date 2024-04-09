package service;

import dao.BaseOrderService;
import dao.OrderDAO;
import model.Order;

import java.util.List;

/**
 * сервисный слой с использованием Template Method паттерна
 * (AbstractOrderService)
 */
public class AbstractOrderService implements BaseOrderService {
    protected OrderDAO orderDAO;

    public AbstractOrderService(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public void createOrder(Order order) {
        Order savedOrder = orderDAO.save(order);
        postProcessOrder(savedOrder);
    }

    @Override
    public void deleteOrder(Long id) {
        orderDAO.deleteById(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return (List<Order>) orderDAO.findAll();
    }

    protected void postProcessOrder(Order order) {

    }
}
