package service;


import dao.OrderDAO;
import model.Order;
import model.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.OrderRepository;

import java.awt.*;


@Service
public class OrderService extends AbstractOrderService {

    @Autowired
    private OrderRepository orderRepository;

    public OrderService(OrderDAO orderDAO) {
        super(orderDAO);
    }

    @Override
    protected void postProcessOrder(Order order) {
        System.out.println("OK");
    }


    /**
     * Метод создания нового заказа
     *
     * @param customer
     * @param shirt
     * @param quantity
     * @return сохраненный заказ
     */
    public Order createOrder(String customer, String shirt, int quantity) {
        if (customer == null || shirt == null || quantity <= 0) {
            throw new IllegalArgumentException("Invalid input parameters for creating order");
        }

        Order order = new Order();
        order.setCustomerName(customer);
        order.setShirtName(shirt);
        order.setQuantity(quantity);
        order.setTotalPrice(order.getAmount() * quantity);

        return orderRepository.save(order);
    }

    /**
     * Отменяет заказ, устанавливает статус отмены и
     * сохраняет обновленную информацию о заказе.
     * @param order
     */
    public void cancelOrder(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }

        order.setOrderStatus(OrderStatus.CANCELLED);

        orderRepository.save(order);
    }


}

