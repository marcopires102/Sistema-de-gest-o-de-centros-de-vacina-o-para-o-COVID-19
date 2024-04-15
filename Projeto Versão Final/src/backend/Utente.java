package backend;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;

public class Utente extends Utilizador implements Serializable {

    private String morada;
    private String localidade;
    private LocalDate data_nasc;
    private long contacto_tel;
    private String email;
    private boolean vacina_administrada;
    private Vacina vacina;
    private int n_vacinas_tomadas;
    private ArrayList<LocalDateTime> datas_vacinacao;
    private Repositorio_Doencas doencas;
    private Centro_Vacinacao centro_vacinacao;

    public Utente(String username, String nome, String password, String morada, String localidade, LocalDate data_nasc, long contacto_tel, String email) {
        super(username, nome, password);
        this.morada = morada;
        this.localidade = localidade;
        this.data_nasc = data_nasc;
        this.contacto_tel = contacto_tel;
        this.email = email;
        this.doencas = new Repositorio_Doencas();
        this.datas_vacinacao = new ArrayList<>();
        this.vacina_administrada = false;
        this.n_vacinas_tomadas = 0;
        this.vacina = null;
    }

    public int getN_vacinas_tomadas() {
        return n_vacinas_tomadas;
    }

    public ArrayList<LocalDateTime> getDatas_vacinacao() {
        return datas_vacinacao;
    }

    public String getMorada() {
        return morada;
    }

    public String getLocalidade() {
        return localidade;
    }

    public LocalDate getData_nasc() {
        return data_nasc;
    }

    public long getContacto_tel() {
        return contacto_tel;
    }

    public String getEmail() {
        return email;
    }

    public boolean isVacina_administrada() {
        return vacina_administrada;
    }

    public Vacina getVacina() {
        return vacina;
    }

    public ArrayList<String> getDoencas() {
        return doencas.listaDoencas();
    }

    public Repositorio_Doencas getRepDoencas() {
        return doencas;
    }

    public Centro_Vacinacao getCentro_vacinacao() {
        return centro_vacinacao;
    }

    public int calcIdade() {
        LocalDate data_atual = LocalDate.now();
        return Period.between(data_nasc, data_atual).getYears();
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public void setData_nasc(LocalDate data_nasc) {
        this.data_nasc = data_nasc;
    }

    public void setContacto_tel(long contacto_tel) {
        this.contacto_tel = contacto_tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setVacina_administrada(boolean vacina_administrada) {
        this.vacina_administrada = vacina_administrada;
    }

    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }

    public void setDoencas(Repositorio_Doencas doencas) {
        this.doencas = doencas;
    }

    public void setCentro_vacinacao(Centro_Vacinacao centro_vacinacao) {
        this.centro_vacinacao = centro_vacinacao;
    }

    public void setN_vacinas_tomadas(int n_vacinas_tomadas) {
        this.n_vacinas_tomadas = n_vacinas_tomadas;
    }

}
