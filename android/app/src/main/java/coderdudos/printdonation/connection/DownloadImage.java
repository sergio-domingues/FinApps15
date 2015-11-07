package coderdudos.printdonation.connection;


import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class DownloadImage{
    public static void downloadImage(final ImageView imagePlace, final View view, final String name, StoredBmp bmp) {
         new DownloadImageTask(imagePlace, bmp){
            @Override
            protected void onPostExecute(final Bitmap result) {
                view.post(new Runnable() {
                    @Override
                    public void run() {
                        bmp.bmp=result;
                        getBmImage().setImageBitmap(result);
                        Log.d("Loaded Image", name);
                    }
                });
            }
        }.execute(name + "");
    }
}
