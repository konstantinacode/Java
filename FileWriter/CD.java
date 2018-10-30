
public class CD extends Item
{
     String artist;
    int numberOfTracks;


	public CD()
 	{
	   	super();
	}

    public CD(String theTitle, String theArtist, int tracks, int time, float price )
    {
        super(theTitle, time,price);
        artist = theArtist;
        numberOfTracks = tracks;
    }


    public String getArtist()
    {
        return artist;
    }

 	public void setArtist(String artist)
    {
        this.artist=artist;
    }



    public int getNumberOfTracks()
    {
        return numberOfTracks;
    }


 	public void setNumberOfTracks( int numberOfTracks)
    {
        this.numberOfTracks=numberOfTracks;
    }


    public void print()
    {
    	System.out.println("Cd details :");
        System.out.println("Artist    " + getArtist());
        System.out.println("Number of    tracks: " +getNumberOfTracks());
        super.print();
        System.out.println("*************************");
    }
}
