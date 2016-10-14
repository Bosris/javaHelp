//main java program
import java.util.Scanner;

class shoppingCartPrinter {
	public static void main(String[] args) {
		// In main(), prompt the user for two items and create two objects of
		// the ItemToPurchase class.
		// Before prompting for the second item, call scnr.nextLine(); to allow
		// the user to input a new string.

		// create scanner object to read in user input
		Scanner user_input = new Scanner(System.in);

		// prompt for item 1 information
		System.out.println("Item 1");
		// create variable for item 1 name then accept and store user input
		String firstItemName;
		while (true) {
			System.out.print("Enter the item name: ");
			try {
				firstItemName = user_input.next( );
				if( !firstItemName.matches("\\d+") )
				{
	                break;
				}
				else
				{
					System.out.println("Input is not a name, try again");
				}
            } catch (NumberFormatException ne) {
                System.out.println("Input is not a string, try again");
            }
		}
		// create variable for item 1 price then accept and store user input
		int firstItemPrice;
		while (true) {
			System.out.print("Enter the item price: ");
			try {
				firstItemPrice = Integer.parseInt(user_input.next());
                break;
            } catch (NumberFormatException ne) {
                System.out.println("Input is not a number, try again");
            }
		}
		// create variable for item 1 quantity then accept and store user input
		int firstItemQuantity;
		while (true) {
			System.out.print("Enter the item quantity: ");
			try {
				firstItemQuantity = Integer.parseInt(user_input.next());
                break;
            } catch (NumberFormatException ne) {
                System.out.println("Input is not a number, try again");
            }
		}
		// create item 1 object then assign previously accepted variables to
		// object as attributes
		ItemToPurchase item1 = new ItemToPurchase();
		item1.setName(firstItemName);
		item1.setPrice(firstItemPrice);
		item1.setQuantity(firstItemQuantity);

		// print out a clean line
		System.out.println(user_input.nextLine());

		// prompt for item 1 information
		System.out.println("Item 2");
		// create variable for item 2 name then accept and store user input
		String firstItemName2;
		while (true) {
			System.out.print("Enter the item name: ");
			try {
				firstItemName2 = user_input.next( );
				if( !firstItemName2.matches("\\d+") )
				{
	                break;
				}
				else
				{
					System.out.println("Input is not a name, try again");
				}
            } catch (NumberFormatException ne) {
                System.out.println("Input is not a string, try again");
            }
		}
		// create variable for item 2 price then accept and store user input
		int firstItemPrice2;
		while (true) {
			System.out.print("Enter the item price: ");
			try {
				firstItemPrice2 = Integer.parseInt(user_input.next());
                break;
            } catch (NumberFormatException ne) {
                System.out.println("Input is not a number, try again");
            }
		}
		// create variable for item 2 quantity then accept and store user input
		int firstItemQuantity2;
		while (true) {
			System.out.print("Enter the item quantity: ");
			try {
				firstItemQuantity2 = Integer.parseInt(user_input.next());
                break;
            } catch (NumberFormatException ne) {
                System.out.println("Input is not a number, try again");
            }
		}
		// create item 2 object then assign previously accepted variables to
		// object as attributes
		ItemToPurchase item2 = new ItemToPurchase();
		item2.setName(firstItemName2);
		item2.setPrice(firstItemPrice2);
		item2.setQuantity(firstItemQuantity2);

		// print out a clean line
		System.out.println(user_input.nextLine());

		// print out total information as requested
		// do equations in one line
		System.out.println("TOTAL COST");
		System.out.println(item1.getName() + " " + item1.getQuantity() + " @ $"
				+ item1.getPrice() + " = $"
				+ (item1.getQuantity() * item1.getPrice()));
		System.out.println(item2.getName() + " " + item2.getQuantity() + " @ $"
				+ item2.getPrice() + " = $"
				+ (item2.getQuantity() * item2.getPrice()));
		System.out.println("Total: $"
				+ ((item1.getQuantity() * item1.getPrice()) + (item2
						.getQuantity() * item2.getPrice())));
	}
}
