package coderdudos.printdonation.connection.Request;


import android.graphics.Bitmap;

public class ImageMenu extends Image {
    Bitmap image;

    public ImageMenu(Bitmap image, String nome, int id) {
        super(nome, id);
        this.image = image;
    }
}
