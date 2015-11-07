package Request;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import Request.Image;

public class ImageDetailed extends Image {
    ArrayList<BufferedImage> fotos;

    public ImageDetailed(String nome, int id) {
        super(nome, id);
    }

    void addFoto(BufferedImage ft) {
        this.fotos.add(ft);
    }

    public ArrayList<BufferedImage> getFotos() {
        return this.fotos;
    }
}