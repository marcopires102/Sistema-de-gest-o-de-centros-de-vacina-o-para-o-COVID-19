package backend;

import java.io.Serializable;
import java.util.ArrayList;

public class ListaCentro_Vacinacao implements Serializable {

    private ArrayList<Centro_Vacinacao> lista;

    public ListaCentro_Vacinacao() {
        lista = new ArrayList<>();

    }

    public void Adicionar(Centro_Vacinacao Centro_Vacinacao) {
        lista.add(Centro_Vacinacao);

    }

    public void remover(Centro_Vacinacao Centro_Vacinacao) {
        lista.remove(Centro_Vacinacao);

    }

    public ArrayList<Centro_Vacinacao> verCentros() {
        return lista;
    }

    public int calcularNumeroCentro_Vacinacao() {
        return lista.size();

    }

    public Centro_Vacinacao procurarCentro_Vacinacao(String codigo) {
        for (int i = 0; i < lista.size(); i++) {
            Centro_Vacinacao e = lista.get(i);
            if (e.getCodigo().equalsIgnoreCase(codigo)) {
                return e;
            }
        }
        return null;
    }

    public Centro_Vacinacao getCentroPorLocalidade(String localidade) {
        for (int i = 0; i < lista.size(); i++) {
            Centro_Vacinacao e = lista.get(i);
            if (e.getLocalidade().equalsIgnoreCase(localidade)) {
                return e;
            }
        }
        return null;
    }

    public Centro_Vacinacao procurarPorGestor(Gestor gestor) {
        for (int i = 0; i < lista.size(); i++) {
            Centro_Vacinacao e = lista.get(i);
            if (e.getGestor() == gestor) {
                return e;
            }
        }
        return null;
    }

    public ArrayList<Gestor> verGestoresComCentro() {
        ArrayList<Gestor> gestores = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            Centro_Vacinacao e = lista.get(i);
            if (e.getGestor() != null) {
                gestores.add(e.getGestor());
            }
        }
        return gestores;
    }

    public boolean existeCentro(String localidade) {
        for (int i = 0; i < lista.size(); i++) {
            Centro_Vacinacao e = lista.get(i);
            if (e.getLocalidade().equalsIgnoreCase(localidade)) {
                return true;
            }
        }
        return false;
    }

    public boolean existeCentroCod(String codigo) {
        for (int i = 0; i < lista.size(); i++) {
            Centro_Vacinacao e = lista.get(i);
            if (e.getCodigo().equalsIgnoreCase(codigo)) {
                return true;
            }
        }
        return false;
    }
}
