package Object_Image;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class BigDataImage {
	
	String name, description;
	int id, price;
	ArrayList<BufferedImage> bigImages;
	BufferedImage preview;
	
	public BigDataImage(String name, String description, int id, int price,	BufferedImage preview) {
		this.name = name;
		this.description = description;
		this.id = id;
		this.price = price;
		this.preview = preview;
	}
	
	public void addBigImage(BufferedImage img){
		
		bigImages.add(img);
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public ArrayList<BufferedImage> getBigImages() {
		return bigImages;
	}
	public void setBigImages(ArrayList<BufferedImage> bigImages) {
		this.bigImages = bigImages;
	}
	public BufferedImage getPreview() {
		return preview;
	}
	public void setPreview(BufferedImage preview) {
		this.preview = preview;
	}
	
	
		

}
