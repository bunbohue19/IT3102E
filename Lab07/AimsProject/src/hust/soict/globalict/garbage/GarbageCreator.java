package hust.soict.globalict.garbage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GarbageCreator {
    public static final int MAX_GARBAGE = 1000;

    public static void main(String[] args) throws FileNotFoundException {
        String path = "C:\\Users\\bunbo\\OneDrive - X42-ZLR-IMA\\Java\\AimsProject\\src\\hust\\soict\\globalict\\garbage\\input.txt";
        File input = new File(path);
        Scanner sc = new Scanner(input);
        String garbage = "Megumin ";
        long start = System.currentTimeMillis();

        if (input.exists()) {
            while (sc.hasNext()) {
                garbage += sc.next();
            }
            System.out.println(System.currentTimeMillis() - start);
        }
        sc.close();
    }
}
