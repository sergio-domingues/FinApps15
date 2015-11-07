package coderdudos.printdonation.connection.request;

public class ResponsePayment extends Model {
	
	String description = "Payment done successfuly\nStarted printing now\nClosing connection with user";
	
	public ResponsePayment(String name){
		super();		
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
