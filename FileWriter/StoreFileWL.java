import java.io.*;
import java.util.*;

public class StoreFileWL {


	private ArrayList<Item> StoreProducts = new ArrayList<Item>();
	private static int numInstancesCD = 0;
	private static int numInstancesDVD = 0;

 public void createFile  (String data) {

		File f = null;
		BufferedWriter writer = null;

		try	{
			f = new File(data); //
		}
		catch (NullPointerException e) {
			System.out.println ("Can't create file");
		}

		try	{
			writer = new BufferedWriter(new FileWriter(f)); 
		}
		catch (IOException e){
			System.out.println("Can't write to file");
		}
		for(Item product : StoreProducts){
			try{
				if (product instanceof CD) {
					numInstancesCD++;
					writer.write ("Product"+"\n"+"{"+"\n"+"\t"+"Item CD "+"\n"+"\t"+"Title "+ product.getTitle()
								+ "\n"+"\t"+"Artist "+ ((CD) product).getArtist()
								+ "\n"+"\t"+"Number of trucks "	+ ((CD)product).getNumberOfTracks()
								+ "\n"+"\t"+"Playing time "	+ ((CD)product).getplayingTime()
								+ "\n"+"\t"+"Price " + ((CD)product).getPrice()
								+ "\n"+"}"+"\n");
				}//cd
				else if (product instanceof DVD) {
					numInstancesDVD++;
						writer.write ("Product"+"\n"+"{"+"\n"+"\t"+"Item DVD "+"\n"+"\t"+"Title "+ product.getTitle()
								+ "\n"+"\t"+"Director "+ ((DVD) product).getDirector()
								+ "\n"+"\t"+"Star "	+ ((DVD)product).getStar()
								+ "\n"+"\t"+"Playing time "	+ ((DVD)product).getplayingTime()
								+ "\n"+"\t"+"Price " + ((DVD)product).getPrice()
								+ "\n"+"}"+"\n");


				}//dvd
			}//try
			catch (IOException e) {
				System.err.println("Write error!");
			}
		}
		
		try {
			writer.write("Number of Cd's  "+numInstancesCD+'\n' );
			writer.write("Number of DVD's "+numInstancesDVD+'\n');
			writer.close();

		}
		catch (IOException e) {
			System.err.println("Error closing file.");
		}
	}

	public void printFile (String data) {
		File f = null;
		BufferedReader reader = null;
		String line;

		try	{
			f = new File(data);
		}
		catch (NullPointerException e) {
			System.out.println ("Can't open file");
		}


		try {
            reader = new BufferedReader (new FileReader(f));
        }
        catch (IOException e) {
        	System.out.println("Can't read from file");
        }


        try {
			line = reader.readLine();
			while(line != null){
				System.out.println(line);
				line = reader.readLine();
			}
        }
        catch (IOException e) {
			System.err.println("Read error!");
		}

	}


 	public void add(Item b) {
		StoreProducts.add(b);
	}


}

