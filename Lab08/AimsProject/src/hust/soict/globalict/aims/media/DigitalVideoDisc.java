package hust.soict.globalict.aims.media;

public class DigitalVideoDisc extends Disc implements Playable, Comparable {

    public DigitalVideoDisc() {
    }

    public DigitalVideoDisc(String title, String category, float cost, String director, long length) {
        super(title, category, cost, director, length);
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    @Override
    public int compareTo(Object obj) {
        DigitalVideoDisc dvd = (DigitalVideoDisc) obj;
        return Integer.compare(this.getTitle().length(), dvd.getTitle().length());
    }
}
