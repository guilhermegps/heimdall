
package heimdall.Util;

/**
 *
 * @author guilherme
 */
public class Classe {
    
    private int id;
    private String nome;
    private Boolean tipo;

    public Classe() {
        this.id = 0;
        this.nome = null;
        this.tipo = null;
    }
    
    public Classe(int id, String nome, Boolean tipo) {
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

    public Boolean isTipo() {
        return tipo;
    }

    public void setTipo(Boolean tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return nome;
    }    
}
