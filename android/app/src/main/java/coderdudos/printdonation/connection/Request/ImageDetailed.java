package coderdudos.printdonation.connection.Request;

import android.graphics.Bitmap;

import java.util.ArrayList;

public class ImageDetailed extends Image {
    ArrayList<Bitmap> fotos;

    public ImageDetailed(String nome, int id) {
        super(nome, id);
    }

    void addFoto(Bitmap ft) {
        this.fotos.add(ft);
    }

    public ArrayList<Bitmap> getFotos() {
        return this.fotos;
    }
}
