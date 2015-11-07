package coderdudos.printdonation.connection.request;

public class ModelInfo extends Model{
	
	private double price;
	private int numPhotos;
	
	public double getPrice() {
		return price;
	}

	public int getNumPhotos() {
		return numPhotos;
	}

	public ModelInfo(String name, double price, int numPhotos) {
		super(name);
		this.price = price;
		this.numPhotos = numPhotos;
	}
}
