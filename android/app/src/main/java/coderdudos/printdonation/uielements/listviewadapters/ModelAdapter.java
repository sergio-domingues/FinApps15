package coderdudos.printdonation.uielements.listviewadapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import coderdudos.printdonation.DownloadImage;
import coderdudos.printdonation.R;

public class ModelAdapter extends BaseAdapter {

    private Context context;
    private List<ModelData> data;
    private View row ;

    public static class ModelData{
        private int modelID;
        private String modelName;

        private float price;

        public ModelData(int modelID, String modelName, float price){
            this.modelID = modelID;
            this.modelName = modelName;
            this.price = price;
        }


        public int getModelID() {
            return modelID;
        }

        public void setModelID(int modelID) {
            this.modelID = modelID;
        }

        public String getModelName() {
            return modelName;
        }

        public void setModelName(String modelName) {
            this.modelName = modelName;
        }

        public float getPrice() {
            return price;
        }

        public void setPrice(float price) {
            this.price = price;
        }

    }

    public ModelAdapter(Context context){
        this.context = context;
        this.data = new ArrayList<>();
        for(int i = 0; i < 20; i++){
            this.data.add(new ModelData(i,i+1+"",i*10));
        }
    }

    public ModelAdapter(Context context, ArrayList<ModelData> data){
        this.context = context;
        this.data = data;
    }




    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return data.get(position).getModelID();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(this.context);

        row = inflater.inflate(R.layout.model_row_layout, parent, false);

        ModelData modelData = this.data.get(position);

        ImageView image = (ImageView) row.findViewById(R.id.model_image);
        //TODO alterar a interface
        DownloadImage downloadImageTask = new DownloadImage() {
            @Override
            public void downloadImage(ImageView imagePlace, View view, String url) {

            }
        };

        TextView name = (TextView) row.findViewById(R.id.model_name);
        name.setText(modelData.getModelName());

        TextView price = (TextView) row.findViewById(R.id.price);
        price.setText(modelData.getPrice() + "€");

        return row;
    }
}