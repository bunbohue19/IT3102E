package hust.soict.globalict.aims.media;

import java.util.*;

public class Book extends Media implements Comparable {
    private ArrayList<String> authors = new ArrayList<String>();
    private String content;

    private String[] contentTokens;

    private Map<String, Integer> wordFrequency = new TreeMap<String, Integer>();

    public Book() {

    }
    public Book(String title, String category, float cost, ArrayList<String> authors) {
        super(title, category, cost);
        this.authors = authors;
    }

    public Book(String title, String category, float cost, ArrayList<String> authors, String content) {
        this(title, category, cost, authors);
        this.content = content;
    }
    public String authorsInfo() {
        return authors.toString();
    }

    public String getContent() {
        return content;
    }

    public void setContent() {
        this.content = content;
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
        int[] frequency = {1};
        this.contentTokens = content.split(" ");
        for (int i = 0; i < contentTokens.size(); i++) {
            for (int j = 0; j < i; j++) {
                if(contentTokens.get(i).equalsIgnoreCase(contentTokens.get(j))) {
                    wordFrequency.put(contentTokens.get(j), frequency[j]++);
                }
            }
        }
    }

    @Override
    public String toString() {
        String[] tokenList = {null};
        int i = 0;
        for (String key : wordFrequency.keySet()) {
            tokenList[i] = key;
            i++;
        }
        return  "- Title: " + getTitle() +
                "\n- Category: " + getCategory() +
                "\n- Cost: " + getCost() +
                "\n- Authors: " + authorsInfo() +
                "\n- The content length (the number of tokens): " + this.contentTokens.length +
                "\n- The token list: " + Arrays.toString(tokenList) +
                "\n- The word frequency: " + wordFrequency.toString();
    }
}
