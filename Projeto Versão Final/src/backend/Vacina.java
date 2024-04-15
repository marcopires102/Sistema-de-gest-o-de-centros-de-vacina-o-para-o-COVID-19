package backend;

import java.io.Serializable;

public class Vacina implements Serializable {

    private String nome;
    private String codigo;
    private String fabricante;
    private int doseIndividual;
    private int idadeMin;
    private int idadeMax;
    private int numTomas;
    private int diasMin;
    private int diasMax;
    private Repositorio_Doencas doencas;

    public Vacina(String nome, String codigo, String fabricante, int doseIndividual, int idadeMin, int idadeMax, int numTomas, int diasMin, int diasMax) {
        this.nome = nome;
        this.codigo = codigo;
        this.fabricante = fabricante;
        this.doseIndividual = doseIndividual;
        this.idadeMin = idadeMin;
        this.idadeMax = idadeMax;
        this.numTomas = numTomas;
        this.diasMin = diasMin;
        this.diasMax = diasMax;
        this.doencas = new Repositorio_Doencas();
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public int getDoseIndividual() {
        return doseIndividual;
    }

    public int getIdadeMin() {
        return idadeMin;
    }

    public int getIdadeMax() {
        return idadeMax;
    }

    public int getNumTomas() {
        return numTomas;
    }

    public int getDiasMin() {
        return diasMin;
    }

    public int getDiasMax() {
        return diasMax;
    }

    public Repositorio_Doencas getDoencas() {
        return doencas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public void setDoseIndividual(int doseIndividual) {
        this.doseIndividual = doseIndividual;
    }

    public void setIdadeMin(int idadeMin) {
        this.idadeMin = idadeMin;
    }

    public void setIdadeMax(int idadeMax) {
        this.idadeMax = idadeMax;
    }

    public void setNumTomas(int numTomas) {
        this.numTomas = numTomas;
    }

    public void setDiasMin(int diasMin) {
        this.diasMin = diasMin;
    }

    public void setDiasMax(int diasMax) {
        this.diasMax = diasMax;
    }

    public void setDoencas(Repositorio_Doencas doencas) {
        this.doencas = doencas;
    }

}
