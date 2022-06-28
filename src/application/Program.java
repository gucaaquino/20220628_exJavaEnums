package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		String name;
		String email;
				
		Scanner tec = new Scanner(System.in);
		
		System.out.print("\n----- Client data -----");
		
		System.out.print("\nName: ");
		name = tec.nextLine();
		
		System.out.print("\nEmail: ");
		email = tec.nextLine();
		
		System.out.print("\nBirth date (dd/MM/yyyy): ");

		Date birthDate = new Date();;
		try {
			birthDate = sdf.parse(tec.next());
		} catch (ParseException e) {
		}
		
		Client client = new entities.Client(name, email, birthDate);
		
		double product_price;
		int order_quantity;
		String product_name;
		OrderStatus order_status;
		
		System.out.print("\n----- Order data -----");
		
		System.out.print("\nStatus: ");
		order_status = OrderStatus.valueOf(tec.next());
		
		Order order = new Order(new Date(), order_status, client); 
		
		System.out.print("\nHow many items to this order? ");
		int quantity = tec.nextInt();
		
		for(int i = 1; i <= quantity; i++) {
			System.out.print("\n----- Enter #" + i + " item data -----");
			
			System.out.print("\nProduct name: ");
			product_name = tec.next();
			
			System.out.print("\nProduct price: ");
			product_price = tec.nextDouble();
			
			System.out.print("\nQuantity: ");
			order_quantity = tec.nextInt();
			
			Product product = new Product(product_name, product_price);
			
			OrderItem order_item = new OrderItem(order_quantity, product);
			
			order.addItem(order_item);
		}
		
		System.out.print("\n----- ORDER SUMMARY -----");
		System.out.println(order);
		
		tec.close();
		
	}

}