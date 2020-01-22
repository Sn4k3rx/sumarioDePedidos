package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Client;
import model.entities.Order;
import model.entities.OrderItem;
import model.entities.Product;
import model.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		SimpleDateFormat sdfClient = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter client Data: ");
		System.out.print("Name: ");
		String clientName = in.nextLine();
		System.out.print("Email: ");
		String clientEmail = in.nextLine();
		System.out.print("Birth Date: ");
		Date clientDate = sdfClient.parse(in.next());
		
		Client c1 = new Client(clientName, clientEmail, clientDate);
		
		System.out.println();
		System.out.println();
		
		System.out.println("Enter order Data: ");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(in.next());
		
		Order order = new Order(new Date(), status, c1);
		
		System.out.print("How manu items to this order: ");
		int numItems = in.nextInt();
		for (int i = 1; i <= numItems; i++) {
			System.out.println("Enter #" + i + " item Data:");
			System.out.print("Product Name: ");
			in.nextLine();
			String nameProduct = in.nextLine();
			System.out.print("Product Price: ");
			Double priceProduct = in.nextDouble();
			
			Product product = new Product(nameProduct, priceProduct);
			
			System.out.print("Quantity: ");
			int quantityProduct = in.nextInt();
			
			OrderItem orderItem = new OrderItem(quantityProduct, priceProduct, product);
			
			order.addOrderItem(orderItem);
		}
		
		System.out.println();
		System.out.println(order);
		
		in.close();
	}
}
