package hust.soict.globalict.aims.media.factory;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;

import java.util.Scanner;

public class DVDCreation implements MediaCreation {
    @Override
    public Media createMediaFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("DVD Title: ");
        String title = scanner.nextLine();
        System.out.print("DVD Category: ");
        String category = scanner.nextLine();
        System.out.print("DVD Price: ");
        float cost = Float.parseFloat(scanner.nextLine());
        System.out.print("DVD Director: ");
        String director = scanner.nextLine();
        System.out.print("DVD Length: ");
        long length = Long.parseLong(scanner.nextLine());
        return new DigitalVideoDisc(title, category, cost, director, length);
    }
}