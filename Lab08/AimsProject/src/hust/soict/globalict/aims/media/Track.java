package hust.soict.globalict.aims.media;

public class Track implements Playable, Comparable {
    private String title;
    private long length;

    public Track(String title, long length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public long getLength() {
        return length;
    }

    @Override
    public void play() {
        System.out.println("Playing Track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }

    @Override
    public int compareTo(Object obj) {
        Track track = (Track) obj;

        if (track.getTitle().equals(this.getTitle()) && track.getLength() == this.getLength()) {
            return 1;
        }
        return 0;
    }
}
