package coderdudos.printdonation.connection;

import java.util.ArrayList;
import java.util.Observable;

import coderdudos.printdonation.connection.request.AllModelInfo;
import coderdudos.printdonation.connection.request.ModelInfo;
import coderdudos.printdonation.connection.request.Request;
import coderdudos.printdonation.uielements.listviewadapters.ModelAdapter;

public class ModelInformationRetriever extends Observable {
    ArrayList<ModelAdapter.ModelData> modelInfo;

    public ModelInformationRetriever(){
        super();
    }
    public void init(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                modelInfo = readModelInfo();
                setChanged();
                notifyObservers(ConnectionMessages.MODELS_RECEIVED.toString());
            }
        }).start();
    }

    public ArrayList<ModelAdapter.ModelData> readModelInfo() {
        Connection.getInstance().send(new Request());
        AllModelInfo elemRetrieved = (AllModelInfo) Connection.getInstance().read();

        ArrayList<ModelAdapter.ModelData> infoParsed = new ArrayList<>();

        for (ModelInfo elem : elemRetrieved.getModelsinfo()) {
            float price = (float) elem.getPrice();
            infoParsed.add(new ModelAdapter.ModelData(elem.getName(), price));
        }

        return infoParsed;
    }

    public ArrayList<ModelAdapter.ModelData> getModelInfo(){
        return modelInfo;
    }
}
