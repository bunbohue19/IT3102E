package hust.soict.globalict.test.media;

import hust.soict.globalict.aims.media.*;

import java.util.ArrayList;

public class TestMediaCompareTo {
    public static void main(String[] args) {
        // Initialize some Media
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "bunbohue", 20, "mmm", 87);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "tttttttt", 30, "ooo", 124);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "yyyyyyyy", 40, "kkk", 90);

        ArrayList<Track> tracks = new ArrayList<Track>();
        tracks.add(new Track("A", 4));
        tracks.add(new Track("B", 6));
        tracks.add(new Track("C", 3));
        CompactDisc cd1 = new CompactDisc("ibm symphony", "cccccccc", 60, "qqq", 13, "aaa", tracks);
        CompactDisc cd2 = new CompactDisc("hahaha", "dddddddd", 80, "rrr", 13, "aaa", tracks);
        CompactDisc cd3 = new CompactDisc("hehehe", "eeeeeeee", 100, "kkk", 13, "aaa", tracks);

        ArrayList<String> authors = new ArrayList<String>();
        authors.add("cargo");
        authors.add("polo");
        authors.add("shirts");
        Book book1 = new Book("Sett", "Bruiser", 70, authors);
        Book book2 = new Book("Shyvana", "Dragon", 80, authors);
        Book book3 = new Book("Galio", "Colossus", 120, authors);

        java.util.Collection collection = new java.util.ArrayList();

        // Add the DVD objects to the ArrayList
        collection.add(dvd1);
        collection.add(dvd2);
        collection.add(dvd3);

        // Iterate through the ArrayList and output their titles
        // (unsorted order)
        java.util.Iterator iterator = collection.iterator();

        System.out.println("-------------------------------------");
        System.out.println("The DVDs currently in the order are: ");
        while (iterator.hasNext()) {
            System.out.println(((DigitalVideoDisc) iterator.next()).getTitle());
        }
        // Sort the collection of DVDs - based on the compareTo()
        // method
        java.util.Collections.sort((java.util.List) collection);

        // Iterate through the ArrayList and output their titles -
        // in sorted order
        iterator = collection.iterator();

        System.out.println("-------------------------------------");
        System.out.println("The DVDs in sorted order are: ");

        while (iterator.hasNext()) {
            System.out.println(((DigitalVideoDisc) iterator.next()).getTitle());
        }

        System.out.println("-------------------------------------");
    }
}
