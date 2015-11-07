package coderdudos.printdonation.connection;


import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

public class DownloadImage{
    public static void downloadImage(final ImageView imagePlace, final View view, final int id, StoredBmp bmp) {
         new DownloadImageTask(imagePlace, bmp){
            @Override
            protected void onPostExecute(final Bitmap result) {
                view.post(new Runnable() {
                    @Override
                    public void run() {
                        bmp.bmp=result;
                        getBmImage().setImageBitmap(result);
                    }
                });
            }
        }.execute(id+"");
    }
}
