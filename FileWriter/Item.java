public class Item
{
   public String title;
   public int  playingTime;
   public float  price;
    public Item()
 	{

	}

    public Item(String theTitle, int time,float price)
    {
        title = theTitle;
        playingTime = time;
        this.price=price;

    }

	public void setTitle(String title)
	{
		this.title = title;
	}


    public String getTitle()
    {
        return title;
    }

   public int getplayingTime()
    {
        return playingTime;
    }


   public float getPrice()
    {
        return this.price;
    }

     public void setPrice(Float price)
    {
         this.price=price;
    }


   public void setplayingTime(int  playingTime)
    {
         this.playingTime=playingTime;
    }

    public void print()
    {
        System.out.println("title: "+getTitle() + " (  " + getplayingTime() + "   mins)");

        System.out.println("Price: "+getPrice());
    }

       public void printExp()
    	{
        	System.out.println("title: "+getTitle() + " (  " +"Price: "+getPrice()+"  )");

        }
}
