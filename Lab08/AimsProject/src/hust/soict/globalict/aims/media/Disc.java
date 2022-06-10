package hust.soict.globalict.aims.media;

public class Disc extends Media {

    private String director;
    private long length;

    public Disc() {
        super();
    }

    public Disc(String title, String category, float cost, String director, long length) {
        super(title, category, cost);
        this.director = director;
        this.length = length;
    }

    public long getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }
}
