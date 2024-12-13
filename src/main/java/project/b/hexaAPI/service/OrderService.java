package project.b.hexaAPI.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import project.b.hexaAPI.dao.OrderDAO;
import project.b.hexaAPI.dao.ProductDAO;

@Service
public class OrderService {
	
	private List<OrderDAO> orderList = new ArrayList<>();
	
	public OrderService() {
		orderList.add(new OrderDAO(1L, "202412111107_N001", 1, "NIKE AIRFORCE1", "옥천 분류센터", "집하처리중"));
		orderList.add(new OrderDAO(2L, "202412111607_E001", 5, "non-slip 슬리퍼 by 이젠아카데미 3호관 ve", "이젠아카데미", "주문접수중"));
		orderList.add(new OrderDAO(3L, "202412111407_M001", 4, "ThreeLine by 모란시장에디션", "모란시장8번출구", "사장님출타중"));
		orderList.add(new OrderDAO(4L, "202412111407_N002", 1, "NIKE AIRFORCE1", "성남 집중국", "뒹굴거리는중"));
		orderList.add(new OrderDAO(5L, "202412111607_N003", 1, "NIKE AIRFORCE1", "도착", "배송완료"));
	}
	
	public List<OrderDAO> getAllOrderInfo() {
        return orderList;
    }
	
	public Optional<OrderDAO> getOrderById(Long id){
		return orderList.stream()
				.filter(order -> order.getId().equals(id))
				.findFirst();
	}
	
	public Optional<OrderDAO> getOrderByOrderId(String orderId){
		return orderList.stream()
				.filter(order -> order.getOrderId().equals(orderId))
				.findFirst();
	}

}
