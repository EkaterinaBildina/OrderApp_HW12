package repository;

import dao.OrderDAO;
import model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * класс OrderDAOImpl,
 * реализует интерфейс OrderDAO и работать с базой данных через Spring Data.
 *
 */

@Repository
public class OrderDAOImpl implements OrderDAO {

    private final OrderRepository orderRepository;

    public OrderDAOImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<Order> findAll() {
        return (List<Order>) orderRepository.findAll();
    }
}
