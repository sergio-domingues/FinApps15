package coderdudos.printdonation.connection;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;
import android.widget.ImageView;

import coderdudos.printdonation.connection.request.ModelPhotos;
import coderdudos.printdonation.connection.request.Request;

public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

    ImageView bmImage;
    StoredBmp bmp;
    Bitmap[] image;

    public DownloadImageTask(ImageView bmImage, StoredBmp bmp) {
        this.bmImage = bmImage;
        this.bmp = bmp;
    }

    public DownloadImageTask(Bitmap[] image) {
        this.image = image;
    }

    synchronized protected Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];
        Request request = new Request(urldisplay);
        Bitmap mIcon11 = null;

        try {
            Connection.getInstance().send(request);
            ModelPhotos model = (ModelPhotos) Connection.getInstance().read();
            byte[] base64converted = Base64.decode(model.getImg(), Base64.DEFAULT);
            mIcon11=BitmapFactory.decodeByteArray(base64converted,0,base64converted.length);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return mIcon11;
    }



    public ImageView getBmImage() {
        return bmImage;
    }

    public Bitmap[] getImage() {
        return image;
    }

    protected void onPostExecute(Bitmap result) {
        if (bmImage != null) bmImage.setImageBitmap(result);
        if (image != null) image[0] = result;
    }
}
