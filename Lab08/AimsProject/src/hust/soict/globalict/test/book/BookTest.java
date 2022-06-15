package hust.soict.globalict.test.book;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.factory.BookCreation;
import static hust.soict.globalict.aims.Aims.createMedia;

public class BookTest {
    public static void main(String[] args) {
        BookCreation bookCreation = new BookCreation();
        Media bookMedia = createMedia(bookCreation);
        Book book = (Book) bookMedia;
        String content = "And when you get to topping I see that you've been learning And when I take you shopping You spend it like you earned it And when you popped off on your ex, he deserved it I thought you were the one from the jump that confirmed it";
        book.setContent(content);
        book.processContent();
        System.out.println(book.toString());
    }
}
