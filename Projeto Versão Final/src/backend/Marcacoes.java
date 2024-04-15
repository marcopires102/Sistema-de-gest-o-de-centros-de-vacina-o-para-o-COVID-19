package backend;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class Marcacoes implements Serializable {

    private HashMap<LocalDateTime, ArrayList<Utente>> Marcacoes;
    private HashMap<LocalDateTime, ArrayList<Utente>> Faltas;

    public Marcacoes() {
        Marcacoes = new HashMap<>();
        Faltas = new HashMap<>();
    }

    public boolean NaoTemMarcaçoes() {
        return Marcacoes.isEmpty();
    }

    public int NumMarcaoesPorDia(LocalDate dia) {
        int total = 0;
        Set<LocalDateTime> keySet = Marcacoes.keySet();
        ArrayList<LocalDateTime> datas = new ArrayList<>(keySet);
        for (LocalDateTime data : datas) {
            if (data.toLocalDate() == dia) {
                ArrayList<Utente> agendados = Marcacoes.get(data);
                if (agendados != null) {
                    total = total + agendados.size();
                }
            }
        }
        return total;
    }

    public void VerSeExistemFaltas() {
        Set<LocalDateTime> keySet = Marcacoes.keySet();
        ArrayList<LocalDateTime> datas = new ArrayList<>(keySet);
        for (LocalDateTime data : datas) {
            if (data.isBefore(LocalDateTime.now())) {
                ArrayList<Utente> agendados = Marcacoes.get(data);
                if (agendados != null) {
                    Faltas.put(data, agendados);
                    Marcacoes.remove(data);
                }
            }
        }
    }

    public ArrayList<LocalDateTime> ListarDatasFaltas() {
        Set<LocalDateTime> keySet = Faltas.keySet();
        ArrayList<LocalDateTime> datas = new ArrayList<>(keySet);
        return datas;
    }

    public ArrayList<Utente> verFaltas(LocalDateTime data) {
        return Faltas.get(data);
    }

    public ArrayList<Utente> VerQueUtentesFaltaram() {
        ArrayList<Utente> todos = new ArrayList<>();
        ArrayList<LocalDateTime> datas = ListarDatasFaltas();
        Collections.sort(datas);
        for (LocalDateTime data : datas) {
            ArrayList<Utente> utentes = verFaltas(data);
            todos.addAll(utentes);
        }
        return todos;
    }

    public LocalDateTime VerFalta(Utente utente) {
        Set<LocalDateTime> datas = Faltas.keySet();
        for (LocalDateTime data : datas) {
            ArrayList<Utente> utentes = Faltas.get(data);
            if (utentes.contains(utente)) {
                return data;
            }
        }
        return null;
    }

    public void Marcar(LocalDateTime data, Utente utente) {
        ArrayList<Utente> agendados = Marcacoes.get(data); //Cria uma lista de utentes que ja tem marcacao para aquela data
        if (agendados == null) { //Se nao existirem utentes com Marcacoes para aquele dia
            agendados = new ArrayList<>(); //Cria a lista
            agendados.add(utente); //Adiciona o utente a lista de agendados
            Marcacoes.put(data, agendados); //Coloca essa lista nas marcaçoes
        } else if (!agendados.contains(utente)) { //Se a lista nao contiver o utente
            agendados.add(utente); //Adiciona esse utente
        }
    }

    public void Cancelar(LocalDateTime data, Utente utente) {
        ArrayList<Utente> agendados = Marcacoes.get(data);
        if (agendados != null && agendados.contains(utente)) {
            agendados.remove(utente);
            Marcacoes.replace(data, agendados);
        }
    }

    public ArrayList<Utente> VerMarcacoes(LocalDateTime data) {
        if (Marcacoes.containsKey(data)) {
            return Marcacoes.get(data);
        } else {
            return new ArrayList<Utente>();
        }
    }

    public int NumMarcacoesPorHora(LocalDateTime data) {
        ArrayList<Utente> agendados = Marcacoes.get(data);
        if (agendados != null) {
            return agendados.size();
        } else {
            return 0;
        }

    }

    public boolean Existem(LocalDateTime data, Utente utente) {
        ArrayList<Utente> agendados = Marcacoes.get(data);
        return agendados.contains(utente);
    }

    public LocalDateTime ProxMarcação(Utente utente) {
        Set<LocalDateTime> datas = Marcacoes.keySet();
        for (LocalDateTime data : datas) {
            ArrayList<Utente> utentes = Marcacoes.get(data);
            if (utentes.contains(utente)) {
                return data;
            }
        }
        return null;
    }

    public ArrayList<LocalDateTime> ListasDatas() {
        Set<LocalDateTime> keySet = Marcacoes.keySet();
        ArrayList<LocalDateTime> datas = new ArrayList<>(keySet);
        return datas;
    }

    public ArrayList<LocalDate> ListasDias() {
        Set<LocalDateTime> keySet = Marcacoes.keySet();
        ArrayList<LocalDateTime> datas = new ArrayList<>(keySet);
        ArrayList<LocalDate> dias = new ArrayList<>();
        for (LocalDateTime data : datas) {
            dias.add(data.toLocalDate());
        }
        return dias;
    }

    public ArrayList<Utente> ListasUtentesParaDia(LocalDate dia) {
        Set<LocalDateTime> keySet = Marcacoes.keySet();
        ArrayList<LocalDateTime> datas = new ArrayList<>(keySet);
        ArrayList<Utente> lista = new ArrayList<>();
        for (LocalDateTime data : datas) {
            if (data.toLocalDate().equals(dia)) {   
                lista.addAll(Marcacoes.get(data));
            }
        }
        return lista;
    }

    public Collection<ArrayList<Utente>> ListarUtentes() {
        return Marcacoes.values();
    }

    public ArrayList<Utente> ListaUtentes() {
        ArrayList<Utente> todos = new ArrayList<>();
        ArrayList<LocalDateTime> datas = ListasDatas();
        Collections.sort(datas);
        for (LocalDateTime data : datas) {
            ArrayList<Utente> utentes = VerMarcacoes(data);
            todos.addAll(utentes);
        }
        return todos;
    }

    public boolean TemMarcacao(Utente utente) {
        return ListaUtentes().contains(utente);
    }
}
