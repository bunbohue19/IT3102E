package hust.soict.globalict.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable, Comparable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public String getArtist() {
        return artist;
    }

    public CompactDisc() {
        super();
    }

    public CompactDisc(String title, String category, float cost, String director, long length, String artist, ArrayList<Track> tracks) {
        super(title, category, cost, director, length);
        this.artist = artist;
        this.tracks = tracks;
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }

    public void tracksInfo(int i) {
        if (i == tracks.size()) {
            return;
        }
        System.out.println("Title: " + tracks.get(i).getTitle() + ", length: " + tracks.get(i).getLength());
        tracksInfo(i + 1);
    }

    public void addTrack(Track track) {
        for (Track t : tracks) {
            if (t.getTitle().equalsIgnoreCase(track.getTitle())) {
                System.out.println("The track has been already had on this CD. Cannot add!");
                return;
            }
        }
        tracks.add(track);
        System.out.println("The track has been added to this CD");
    }

    public void removeTrack(Track track) {
        for (Track t : tracks) {
            if (t.getTitle().equalsIgnoreCase(track.getTitle())) {
                tracks.remove(track);
                System.out.println("The track has been removed from this CD");
                return;
            }
        }
        System.out.println("The track has not found on this CD. Cannot remove!");
    }

    @Override
    public long getLength() {
        int sumLength = 0;
        for (Track track : tracks) {
            sumLength += track.getLength();
        }
        return sumLength;
    }

    @Override
    public void play() {
        System.out.println("Director: " + this.getDirector()
                        +  "\tLength: " + this.getLength()
                        +  "\tArtist: " + this.getArtist());
        for (Track t : tracks) {
            System.out.println("Track: " + t.getTitle() + "\tLength: " + t.getLength());
        }
    }

    @Override
    public int compareTo(Object obj) {
        CompactDisc cd = (CompactDisc) obj;
        return Long.compare(cd.getLength(), this.getLength());
    }
}
