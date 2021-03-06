package model.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.enums.OrderStatus;

public class Order {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");	
	private Date moment;
	private OrderStatus status;
	
	private Client client;
	private List<OrderItem> orderItem = new ArrayList<>();
	
	public Order() {
		
	}
	
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getOrderItem() {
		return orderItem;
	}

	public void addOrderItem(OrderItem orderItem) {
		this.orderItem.add(orderItem);
	}
	
	public void removeOrderItem(OrderItem orderItem) {
		this.orderItem.remove(orderItem);
	}
	
	public Double total() {
		double sum = 0.0;
		for (OrderItem item : orderItem) {
			sum += item.getPrice();
		}
		return sum;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMARY: ");
		sb.append("\nOrder moment: " + sdf.format(moment));
		sb.append("\nOrder status: " + status);
		sb.append("\nClient:\n" + client);
		for (OrderItem item : orderItem) {
			sb.append("\n" + item.toString());
		}
		return sb.toString();
	}
}
