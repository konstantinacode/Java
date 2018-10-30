class MainFileWL {

	public static void main(String[] args) {

		StoreFileWL Product = new StoreFileWL();

        Item item1 = new CD("Four","Led Zeppelin", 6, 55, (float)24.55);
		Item item2 = new DVD("Match Point ","woody allen","Jonathan Rhys Meyers",90,(float)35.70);
		Item item3 = new DVD("Anna Karenina ","Joe Wright","Keira Christina Knightley ",115,(float)34.68);
		Item item4 = new CD("the wall","pink floyd",6,115,(float)45.90);
		Item item5 = new CD("catch the rainbow","rainbow",12,89, (float) 25.50);
		Item item6 = new CD("The River","Bruce Springsteen",14,111, (float) 22.50);
		Item item7 = new DVD("Les Miserables ","Ton Hooper","Anne Hathaway",135,(float)33.90);


      //  Fill your code
		Product.add(item1);
		Product.add(item2);
		Product.add(item3);
		Product.add(item4);
		Product.add(item5);
		Product.add(item6);
		Product.add(item7);


        System.out.println("File writing...");
		Product.createFile("eidh.txt");
		System.out.println("File reading...");
		Product.printFile("eidh.txt");
		

	}//main

}//Main



