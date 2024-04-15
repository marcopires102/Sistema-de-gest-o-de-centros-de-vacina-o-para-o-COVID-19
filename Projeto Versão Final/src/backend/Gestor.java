package backend;

import java.io.Serializable;

public class Gestor extends Utilizador implements Serializable {
    
    //Construtor
    public Gestor(String username, String nome, String password) {
        super(username, nome, password);
    }

}
