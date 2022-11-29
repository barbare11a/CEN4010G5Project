// This is a test class that will call functions and will depend on other functions in order to work //

import java.util.Scanner;

public class shoppingCart {

    public static void main (String[]args){

        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a value to get it's squared result.");
        n = scanner.nextInt();
        System.out.println("The result of " + n + "squared is: " + n * n);

        /* int cartId;
        int size;
        String lastUpdate;
        String products;

        create(); // calls function that creates shopping cart for user
        updateCart(); // calls function that allows user to update cart by adding or deleting books
        viewCart(); // calls function that allows user to view their current shopping cart
        getProducts (); // calls function that allows user to retrieve a list of the books they have in their shopping cart
        checkOut(); // calls function that allows users to check out and buy the books in their shopping cart */
    }
}
