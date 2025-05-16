public class ShoppingCartTest {

	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();
		
		Item item1 = new Item("SamsungS23",500);
		Item item2 = new Item("iPhone16",900);
		
		cart.addItem(item1);
		cart.addItem(item2);
		
		//pay by paypal
		cart.pay(new PaypalStrategy("myemail@example.com", "mypwd"));
		
		//pay by credit card
		cart.pay(new CreditCardStrategy("Michele Rossi", "1234567890123456", "786", "12/15"));
	}

}