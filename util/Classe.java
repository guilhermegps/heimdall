
package heimdall.util;

/**
 *
 * @author guilherme
 */
public class Classe {
    
    private int id;
    private String nome;
    private int tipo;

    public Classe() {
        this.id = 0;
        this.nome = null;
        this.tipo = 0;
    }
    
    public Classe(int id, String nome, int tipo) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int isTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return nome;
    }    
}
