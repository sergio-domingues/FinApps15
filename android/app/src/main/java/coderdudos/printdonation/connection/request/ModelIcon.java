package coderdudos.printdonation.connection.request;


public class ModelIcon extends Model {
	private String img;
	
	public String getImg() {
		return img;
	}

	public ModelIcon(String name, String img) {
		super(name);
		this.img = img;
	}
}
