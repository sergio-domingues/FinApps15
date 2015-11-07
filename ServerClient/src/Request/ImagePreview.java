package Request;

import java.awt.image.BufferedImage;
import Request.Image;

public class ImagePreview extends Image {
    BufferedImage printing_preview;

    public ImagePreview(BufferedImage preview, String nome, int id) {
        super(nome, id);
        this.printing_preview = preview;
    }

    public BufferedImage getPrinting_preview() {
        return this.printing_preview;
    }

    public void setPrinting_preview(BufferedImage printing_preview) {
        this.printing_preview = printing_preview;
    }
}