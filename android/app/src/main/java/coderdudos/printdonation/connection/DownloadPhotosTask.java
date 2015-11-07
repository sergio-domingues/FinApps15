package coderdudos.printdonation.connection;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import android.widget.ImageView;

import coderdudos.printdonation.connection.request.ModelPhotos;
import coderdudos.printdonation.connection.request.Request;

/**
 * Created by Duarte on 07/11/2015.
 */
public class DownloadPhotosTask extends DownloadImageTask {
    public DownloadPhotosTask(ImageView bmImage, StoredBmp bmp) {
        super(bmImage, bmp);
    }

    public DownloadPhotosTask(Bitmap[] image) {
        super(image);
    }
    @Override
    synchronized protected Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];
        String name = urldisplay.substring(0,urldisplay.length()-1);
        String index = urldisplay.substring(urldisplay.length()-1);
        Log.d("Image load","name: " + name + " index: "+index);

        Request request = new Request(Request.type.bigPicture ,name, Integer.parseInt(index));
        Bitmap mIcon11 = null;

        try {
            Connection.getInstance().send(request);
            ModelPhotos model = (ModelPhotos) Connection.getInstance().read();
            byte[] base64converted = Base64.decode(model.getImg(), Base64.DEFAULT);
            mIcon11= BitmapFactory.decodeByteArray(base64converted, 0, base64converted.length);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return mIcon11;
    }
}
