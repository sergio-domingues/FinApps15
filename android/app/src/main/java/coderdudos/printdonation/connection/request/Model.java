package coderdudos.printdonation.connection.request;

import java.io.Serializable;

public abstract class Model implements Serializable {
	protected String name;
	
	protected Model(){}
	
	protected Model(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
