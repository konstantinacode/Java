
class MainFileRL{

	public static void main(String[] args){
		StoreFileRL Product = new StoreFileRL();
		
		Product.loadFile("/Users/konstantinamatthaiou/Documents/EclipseWorkspace/FileReader/src/lines.txt");
		
		System.out.println("File loaded...");
		System.out.println();
		
		for(int i=0; i<Product.size(); i++){
			Product.get(i).print();
			System.out.println();
		}
	}
}