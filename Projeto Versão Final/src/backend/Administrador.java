package backend;

import java.io.Serializable;

public class Administrador extends Utilizador implements Serializable {
    
    //Construtor
    public Administrador(String username, String nome, String password) {
        super(username, nome, password);
    }

}
