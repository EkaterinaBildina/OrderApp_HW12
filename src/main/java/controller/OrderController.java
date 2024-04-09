package controller;

import lombok.RequiredArgsConstructor;
import model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.FileGateway;
import service.OrderService;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private final FileGateway fileGateway;

    /**
     * Метод добавляет новый заказ,
     * устанавливает текущее время создания заказа,
     * записывает информацию о заказе в файл с названием "{order.getTitle()}.txt"
     * @param order
     * @return ResponseEntity с кодом статуса HttpStatus.OK.
     * (ResponseEntity - это класс из библиотеки Spring Framework, в данном случае
     * используется для обертывания объекта типа Order в ответ HTTP)
     *
     */
    @PostMapping
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {
        order.setCreation(LocalDateTime.now());
        fileGateway.writeToFile(order.getTitle() + ".txt", order.toString());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
