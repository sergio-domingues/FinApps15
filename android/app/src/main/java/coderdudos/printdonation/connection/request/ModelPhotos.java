package coderdudos.printdonation.connection.request;

public class ModelPhotos extends Model{
	
	private String img;
	
	public String getImg() {
		return img;
	}

	public ModelPhotos(String name, String img) {
		super(name);
		this.img = img;
	}
}
