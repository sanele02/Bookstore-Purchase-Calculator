import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        TreeMap<String, Double> books = new TreeMap<>();
        Scanner input = new Scanner(System.in);
        double book_price = 0.0;
        double total_price = 0;
        double discount;
        double final_price;

        //greeting
        System.out.println("Welcome to the Bookstore!");

        System.out.print("Enter the number of books you want to buy: " );
        int num_books =  input.nextInt();

        if (num_books<=0){
            System.out.println("No books purchased. Thank you!");
            return;
        }


        //use a treemap instead of an array
        //String [] book_list;

        for (int i = num_books; i >0 ; i--) {
            System.out.print("Enter book title: ");
            String book_title = input.next();
            input.nextLine();// debug problem ... if i don't add this it will crash before i add the book price
//somehow it doesn't store the whole book name into the tree map , it only stores the first word of the book
            //still trying to debug this problem
            System.out.print("Enter book price: ");
             book_price = input.nextDouble();


            //store in treemap
            books.put(book_title, book_price);
            total_price = total_price + book_price;
        }// end of for loop

// calculate discount
        if (total_price>500){
            discount = total_price * 0.10;
        }
        else {
            discount =0;
        }
        final_price = total_price - discount;

        //Receipt
        System.out.println("------------------------------");
        System.out.println("----------Receipt-----------");

        int count = 0;

        //hrough the TreeMap and print book details//dont understand this well chatgpt
        for (Map.Entry<String, Double> entry : books.entrySet()){
            // gets the book name and the price for each book from the treemap
            count++;
            System.out.println(count+" | "+entry.getKey() + " - R " + entry.getValue());
        }
        System.out.println("Total before discount: R "+total_price);
        System.out.println("Discount: R "+ discount);
        System.out.println("Final Total: R "+ final_price);
        System.out.println("--------------------------------");
        System.out.println("Thank you for shopping with us!");
        System.out.println("--------------------------------");
    }


}