package hust.soict.globalict.aims.media.factory;

import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Track;

import java.util.ArrayList;
import java.util.Scanner;

public class CDCreation implements MediaCreation {
    private ArrayList<Track> temporaryTrack = new ArrayList<Track>();

    @Override
    public Media createMediaFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("CD Title: ");
        String title = scanner.nextLine();
        System.out.print("CD Category: ");
        String category = scanner.nextLine();
        System.out.print("CD Price: ");
        float cost = Float.parseFloat(scanner.nextLine());
        System.out.print("CD Director: ");
        String director = scanner.nextLine();
        System.out.print("CD Length: ");
        long length = Long.parseLong(scanner.nextLine());
        System.out.print("CD Artist: ");
        String artist = scanner.nextLine();

        System.out.print("Enter the number of tracks which you want to add to the CD: ");
        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < number; i++) {
            System.out.print("Enter the title of track of order " + (i + 1) + ": ");
            String trackTitle = scanner.nextLine();
            System.out.print("Enter the length of track of order " + (i + 1) + ": ");
            long trackLength = Long.parseLong(scanner.nextLine());
            temporaryTrack.add(new Track(trackTitle, trackLength));
        }
        return new CompactDisc(title, category, cost, director, length, artist, temporaryTrack);
    }
}
