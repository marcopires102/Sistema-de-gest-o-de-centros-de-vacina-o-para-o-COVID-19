package backend;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Sistema implements Serializable {

    private final ListaUtilizador utilizadores;
    private final ListaCentro_Vacinacao centros_vacinacao;
    private Utilizador utilizadorLigado;
    private ArrayList<Vacina> vacinas;

    public Sistema() {
        utilizadores = new ListaUtilizador();
        centros_vacinacao = new ListaCentro_Vacinacao();
        vacinas = new ArrayList<>();
    }

    public ListaUtilizador getUtilizadores() {
        return utilizadores;
    }

    public ListaCentro_Vacinacao getCentros_Vacinacao() {
        return centros_vacinacao;
    }

    public Utilizador getUtilizadorLigado() {
        return utilizadorLigado;
    }

    public ArrayList<Vacina> getVacinas() {
        return vacinas;
    }

    public boolean autenticarUtilizador(String username, String password) {
        if (utilizadores.existe(username)) {
            try {
                Utilizador u = utilizadores.getUtilizador(username);
                if (u.getPassword().equals(password)) {
                    utilizadorLigado = u;
                    return true;
                }
            } catch (Exception e) {
            }
        }
        return false;
    }

    

    public void terminar() {
        System.exit(0);
    }

}
