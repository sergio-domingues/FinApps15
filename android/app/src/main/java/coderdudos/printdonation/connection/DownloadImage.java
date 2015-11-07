package coderdudos.printdonation.connection;


import android.view.View;
import android.widget.ImageView;

public interface DownloadImage {

    void downloadImage(ImageView imagePlace, final View view, final int id, StoredBmp bmp);
}
