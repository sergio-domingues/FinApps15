package coderdudos.printdonation.connection.Request;

public abstract class Image {
    private String nome;
    private int id;

    public Image(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
