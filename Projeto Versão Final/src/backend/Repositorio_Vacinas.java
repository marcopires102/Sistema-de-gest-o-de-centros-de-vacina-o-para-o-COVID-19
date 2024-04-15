package backend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Repositorio_Vacinas implements Serializable {

    private HashMap<Vacina, Long> stock;

    public Repositorio_Vacinas() {
        stock = new HashMap<>();
    }

    public void adicionarQtdVacina(Vacina vacina, Long quantidade) {
        if (stock.containsKey(vacina)) {
            Long qtd = stock.get(vacina);
            stock.replace(vacina, qtd + quantidade);
        } else {
            stock.put(vacina, quantidade);

        }
    }

    public Long stockDisponivel(Vacina vacina) {
        return stock.get(vacina);
    }

    //Verificar no front end se qtd_inicial (stockDisponivel) > quantidade
    public void remover(Vacina vacina, Long quantidade) {
        Long qtd_inicial = stock.get(vacina);
        stock.replace(vacina, qtd_inicial - quantidade);
    }

    public boolean existe(Vacina vacina) {
        return stock.containsKey(vacina);
    }

    public int getVacinas() {
        return stock.keySet().size();
    }

    public ArrayList<Vacina> listarVacinas() {
        Set<Vacina> keySet = stock.keySet();
        ArrayList<Vacina> vacinas = new ArrayList<>(keySet);
        return vacinas;
    }

    public HashMap<Vacina, Long> getStock() {
        return stock;
    }

}
