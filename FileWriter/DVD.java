
public class DVD extends Item
{
     String director;
     String movieStar;

	public DVD()
 	{
	   	super();
	}

    public DVD(String theTitle, String theDirector, String star,int time,float price)
    {
        super(theTitle, time,price);
        director = theDirector;
        movieStar=star;
    }

    public String getDirector()
    {
        return director;
    }

     public void setDirector( String director)
    {
        this.director=director;
    }


	public String getStar()
    {
        return movieStar;
    }


    	public void setStar( String movieStar)
    {
        this.movieStar=movieStar;
    }





    public void print()
    {
    	System.out.println("DVD details :");
        System.out.println("director: " + getDirector());
        System.out.println("Star : " + getStar());
        super.print();
        System.out.println("**************************");
    }
}
