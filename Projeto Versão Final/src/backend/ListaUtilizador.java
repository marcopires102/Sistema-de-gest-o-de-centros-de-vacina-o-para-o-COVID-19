package backend;

import java.io.Serializable;
import java.util.ArrayList;

public class ListaUtilizador implements Serializable {

    private ArrayList<Utilizador> lista;

    public ListaUtilizador() {
        lista = new ArrayList<>();

    }

    public void Adicionar(Utilizador Utilizador) {
        lista.add(Utilizador);
    }

    public void remover(Utilizador Utilizador) {
        lista.remove(Utilizador);
    }

    public boolean existe(String username) {
        for (int i = 0; i < lista.size(); i++) {
            Utilizador u = lista.get(i);
            String user = u.getUsername();
            if (user.equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }

    public Utilizador getUtilizador(String username) {
        if (existe(username)) {
            for (int i = 0; i < lista.size(); i++) {
                Utilizador u = lista.get(i);
                String user = u.getUsername();
                if (user.equalsIgnoreCase(username)) {
                    return u;
                }
            }
        }
        return null;
    }

    public Utilizador getUtilizadorNome(String nome) {
        for (int i = 0; i < lista.size(); i++) {
            Utilizador u = lista.get(i);
            String user = u.getNome();
            if (nome.equalsIgnoreCase(user)) {
                return u;
            }
        }
        return null;
    }

    public ArrayList<Gestor> getGestores() {
        ArrayList<Gestor> gestores = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            Utilizador u = lista.get(i);
            if (u instanceof Gestor) {
                gestores.add((Gestor) u);
            }
        }
        return gestores;
    }

    public ArrayList<Administrador> getAdministradores() {
        ArrayList<Administrador> administradores = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            Utilizador u = lista.get(i);
            if (u instanceof Administrador) {
                administradores.add((Administrador) u);
            }
        }
        return administradores;
    }

    public ArrayList<Utente> getUtentes() {
        ArrayList<Utente> utentes = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            Utilizador u = lista.get(i);
            if (u instanceof Utente) {
                utentes.add((Utente) u);
            }
        }
        return utentes;
    }

    public ArrayList<Utente> procurarPorCentro(Centro_Vacinacao centro) {
        ArrayList<Utente> utentes = getUtentes();
        ArrayList<Utente> utentes_centro = new ArrayList();
        for (int i = 0; i < utentes.size(); i++) {
            Utente u = utentes.get(i);
            if (u.getCentro_vacinacao() == centro) {
                utentes_centro.add(u);
            }
        }
        return utentes_centro;
    }

}
