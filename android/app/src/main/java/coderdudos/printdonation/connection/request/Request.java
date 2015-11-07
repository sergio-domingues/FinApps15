package coderdudos.printdonation.connection.request;

import java.io.Serializable;

public class Request implements Serializable{
   
	private static final long serialVersionUID = 1L;
	
	type requestType;
    private String model_name = "lol";
    private int image_index;
        
	public enum type {
        menuText,
        menuImg,
        previewImg,
        bigPicture,
        payment
    }
    
    public Request() {
        this.requestType = type.menuText;
    }

    //for icone
    public Request(String modelname) {
        this.requestType = type.menuImg;
        this.image_index = 0;
        this.model_name = modelname;
    }       
    
    //for images
    public Request(type request, String name, int index) {
    	this.model_name = name;
        this.requestType = request;
        this.image_index = index;
    }
      
    public int getImage_index() {
		return image_index;
	}

	public void setImage_index(int image_index) {
		this.image_index = image_index;
	}
    
    
	public String getModel_name() {
		return model_name;
	}

	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}
    
    public type getRequestType() {
        return this.requestType;
    }

    public void setRequestType(type requestType) {
        this.requestType = requestType;
    }


}