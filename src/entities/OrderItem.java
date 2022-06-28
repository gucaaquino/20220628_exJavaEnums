package entities;

public class OrderItem {
	private int quantity;
	private Product product;

	public OrderItem(int quantity, Product product) {
		super();
		this.quantity = quantity;
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Double subTotal() {
		return quantity * product.getPrice();
	}

	@Override
	public String toString() {
		return product.getName() + ", " + product.getPrice() + ", Quantity: " + quantity + ", SubTotal: " + subTotal();
	}
}
