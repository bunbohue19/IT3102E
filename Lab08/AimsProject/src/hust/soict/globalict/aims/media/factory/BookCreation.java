package hust.soict.globalict.aims.media.factory;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.Media;

import java.util.ArrayList;
import java.util.Scanner;

public class BookCreation implements MediaCreation {

    private ArrayList<String> temporaryAuthors = new ArrayList<String>();

    @Override
    public Media createMediaFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Book Title: ");
        String title = scanner.nextLine();
        System.out.print("Book Category: ");
        String category = scanner.nextLine();
        System.out.print("Book Price: ");
        float cost = Float.parseFloat(scanner.nextLine());

        System.out.print("Enter the number of authors which you want to add to the Book: ");
        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < number; i++) {
            System.out.print("Enter the name of author of order " + (i + 1) + ": ");
            String authorName = scanner.nextLine();
            temporaryAuthors.add(authorName);
        }
        return new Book(title, category, cost, temporaryAuthors);
    }
}
