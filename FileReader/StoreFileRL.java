import java.io.*;
import java.util.*;

public class StoreFileRL {

	private ArrayList <Item> StoreProducts = new ArrayList<Item>();

	 public void loadFile(String data) {
        int counter = 0;

        File f = null;
        BufferedReader reader = null;
        Item product = null;
        String line;

        try {
            f = new File(data);
        } catch (NullPointerException e) {
            System.err.println("File not found.");
        }

        try {
            reader = new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException e) {
            System.err.println("Error opening file!");
        }

        try {
			line = reader.readLine();
			while(line != null){
				if (line.trim().equals("Product")){
					line = reader.readLine();
					if (line.trim().equals("{")){
						line = reader.readLine();
						if (line.trim().startsWith("Item ")){
							if(line.trim().substring(5).trim().equals("CD")){
								product = new CD();
								line = reader.readLine();
								if (line.trim().startsWith("Name "))
									product.setTitle(line.trim().substring(5).trim());
								
								line = reader.readLine();
								if (line.trim().startsWith("Artist "))
									((CD) product).setArtist(line.trim().substring(7).trim());
									
								line = reader.readLine();
								if (line.trim().startsWith("Number of Trucks "))
									((CD) product).setNumberOfTracks(
										Integer.parseInt(line.substring(18).trim()));
										
								line = reader.readLine();
								if (line.trim().startsWith("Time ")) 
									product.setplayingTime(Integer.parseInt
															(line.substring(5).trim()));
															
								line = reader.readLine();
								if (line.trim().startsWith("Price "))
									product.setPrice(Float.parseFloat
													(line.substring(6).trim()));
								
								line = reader.readLine();
								if (line.trim().equals("}"))
									StoreProducts.add(product);
							}
						}
					}
				}
				line = reader.readLine();
			}
        } catch (IOException e) {
            System.out.println("Error reading line " + counter + ".");
        }

        try {
            reader.close();
        } catch (IOException e) {
            System.err.println("Error closing file.");
        }
    }
	public Item get(int i){
		return StoreProducts.get(i);
	}


	public int size()	{
		return StoreProducts.size();
	}

}

