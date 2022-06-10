package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Book extends Media implements Comparable {
    private ArrayList<String> authors = new ArrayList<String>();
    private String content;

    private String[] contentTokens;

    public Book() {

    }

    public Book(String title, String category, float cost, ArrayList<String> authors) {
        super(title, category, cost);
        this.authors = authors;
    }

    public String authorsInfo() {
        return authors.toString();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int compareTo(Object obj) {
        Book book = (Book) obj;
        if (this.getTitle().equals(book.getTitle())) {
            return 1;
        }
        return 0;
    }

    public void processContent(){
        List<String> contentTokens = new ArrayList<String>();
        Map<String, Integer> wordFrequency = new HashMap<>();
        this.contentTokens = this.getContent().split(" ");
    }
}
