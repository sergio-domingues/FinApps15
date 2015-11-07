package coderdudos.printdonation.connection.Request;


import android.graphics.Bitmap;

public class ImagePreview extends Image {
    Bitmap printing_preview;

    public ImagePreview(Bitmap preview, String nome, int id) {
        super(nome, id);
        this.printing_preview = preview;
    }

    public Bitmap getPrinting_preview() {
        return this.printing_preview;
    }

    public void setPrinting_preview(Bitmap printing_preview) {
        this.printing_preview = printing_preview;
    }
}
