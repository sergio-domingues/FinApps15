package coderdudos.printdonation.connection;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

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

    protected Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];
        Bitmap mIcon11 = null;
        try {
            //TODO
            /*InputStream in = new java.net.URL(urldisplay).openStream();
            mIcon11 = BitmapFactory.decodeStream(in);*/
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
