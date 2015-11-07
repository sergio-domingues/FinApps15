package coderdudos.printdonation.connection.request;

import java.util.ArrayList;

public class AllModelInfo extends Model {
	
	ArrayList<ModelInfo> modelsinfo;

	public AllModelInfo() {
		this.modelsinfo = new ArrayList<ModelInfo>();
	}

	public ArrayList<ModelInfo> getModelsinfo() {
		return modelsinfo;
	}

	public void setModelsinfo(ArrayList<ModelInfo> modelsinfo) {
		this.modelsinfo = modelsinfo;
	}
	
	public void addModelInfo( ModelInfo m){		
		this.modelsinfo.add(m);
	}
	

}
