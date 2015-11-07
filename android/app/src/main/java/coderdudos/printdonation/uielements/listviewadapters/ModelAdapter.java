package coderdudos.printdonation.uielements.listviewadapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import coderdudos.printdonation.R;
import coderdudos.printdonation.connection.DownloadImage;
import coderdudos.printdonation.connection.StoredBmp;

public class ModelAdapter extends BaseAdapter implements Serializable {

    private Context context;
    private List<ModelData> data;
    private View row ;

    public static class ModelData{
        private StoredBmp image;
        private String modelName;

        private float price;

        public ModelData(String modelName, float price){
            this.modelName = modelName;
            this.price = price;
            this.image = new StoredBmp(null);
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

        public StoredBmp getImage() {
            return image;
        }

        public void setImage(StoredBmp image) {
            this.image = image;
        }
    }

    public ModelAdapter(Context context){
        this.context = context;
        this.data = new ArrayList<>();
        for(int i = 0; i < 20; i++){
            this.data.add(new ModelData(i+1+"",i*10));
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
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(this.context);

        row = inflater.inflate(R.layout.model_row_layout, parent, false);

        ModelData modelData = this.data.get(position);

        ImageView image = (ImageView) row.findViewById(R.id.model_image);
        if(modelData.getImage().bmp != null){
            image.setImageBitmap(modelData.getImage().bmp);
        }else{
            DownloadImage.downloadImage(image, row, modelData.getModelName(), modelData.getImage());
    }


        TextView name = (TextView) row.findViewById(R.id.model_name);
        name.setText(modelData.getModelName());

        TextView price = (TextView) row.findViewById(R.id.price);
        price.setText(modelData.getPrice() + "€");

        return row;
    }
}