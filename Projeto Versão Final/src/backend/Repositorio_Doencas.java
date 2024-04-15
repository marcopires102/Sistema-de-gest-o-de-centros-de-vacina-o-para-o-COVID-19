package backend;

import java.io.Serializable;
import java.util.ArrayList;

public class Repositorio_Doencas implements Serializable {

    private ArrayList<String> doencas;

    public Repositorio_Doencas() {
        this.doencas = new ArrayList<>();
    }

    public String get(int index) {
        return doencas.get(index);
    }

    public void adicionar(String doenca) {
        doencas.add(doenca);
    }

    public void remover(String doenca) {
        doencas.remove(doenca);
    }

    public void verDoencas() {
        for (int i = 0; i < doencas.size(); i++) {
            System.out.println(doencas.get(i));
        }
    }

    public ArrayList<String> todas() {
        return doencas;
    }

    public boolean existeDoenca(String doenca) {
        return doencas.contains(doenca);
    }

    public int qtdDoencas() {
        return doencas.size();
    }

    public String procurarDoenca(int i) {
        return doencas.get(i);
    }

    public String procurarDoencaNome(String doenca) {
        if (doencas.contains(doenca)) {
            return doenca;
        }
        return null;
    }

    public ArrayList<String> listaDoencas() {
        return doencas;
    }
}
