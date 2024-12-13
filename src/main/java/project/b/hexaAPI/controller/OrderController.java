package project.b.hexaAPI.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.b.hexaAPI.dao.OrderDAO;
import project.b.hexaAPI.dao.ProductDAO;
import project.b.hexaAPI.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {
	/*
	 * 전체 주문리스트 조회
	 * id로 주문 조회
	 * order id로 주문 조회
	 */
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/")
	public List<OrderDAO> getAllOrders() {
		return orderService.getAllOrderInfo();
	}
	
    @GetMapping("/{id}")
    public OrderDAO getOrderById(@PathVariable Long id) {
        Optional<OrderDAO> orderInfo = orderService.getOrderById(id);
        return orderInfo.orElse(null);
    }
    
    @GetMapping("/list/{orderId}")
    public OrderDAO getOrderByOrderId(@PathVariable String orderId) {
        Optional<OrderDAO> orderInfo = orderService.getOrderByOrderId(orderId);
        return orderInfo.orElse(null);
    }
	

}
