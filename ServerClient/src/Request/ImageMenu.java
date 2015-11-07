package Request;

import java.awt.image.BufferedImage;
import Request.Image;

public class ImageMenu extends Image {
    BufferedImage image;

    public ImageMenu(BufferedImage image, String nome, int id) {
        super(nome, id);
        this.image = image;
    }
}