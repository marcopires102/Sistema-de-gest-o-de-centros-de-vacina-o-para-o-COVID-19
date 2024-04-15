package backend;

import java.io.Serializable;

public class Centro_Vacinacao implements Serializable {

    private String codigo;
    private String morada;
    private String localidade;
    private int NPostosAtendimento;
    private Repositorio_Vacinas StockVacinas;
    private Marcacoes MarcacoesV;
    private Gestor gestor;
    private Repositorio_Doencas EfeitosSecRegs;
    private int NumMaxMarcacoes;
    private int VacinasAdministradas;
    
    //Construtores
    public Centro_Vacinacao(String codigo, String morada, String localidade, Gestor gestor) {
        this.codigo = codigo;
        this.morada = morada;
        this.localidade = localidade;
        this.NPostosAtendimento = 0;
        this.gestor = gestor;
        this.StockVacinas = new Repositorio_Vacinas();
        this.MarcacoesV = new Marcacoes();
        this.EfeitosSecRegs = new Repositorio_Doencas();
        this.NumMaxMarcacoes = 0; 
        this.VacinasAdministradas = 0;
    }

    public Centro_Vacinacao(String codigo, String morada, String localidade, int n_posto_atend, Gestor gestor, int n_max_marcacoes) {
        this.codigo = codigo;
        this.morada = morada;
        this.localidade = localidade;
        this.NPostosAtendimento = n_posto_atend;
        this.gestor = gestor;
        this.NumMaxMarcacoes = n_max_marcacoes;
        this.StockVacinas = new Repositorio_Vacinas();
        this.MarcacoesV = new Marcacoes();
        this.EfeitosSecRegs = new Repositorio_Doencas();
        this.VacinasAdministradas = 0;
    }

    //Seletores
    public String getCodigo() {
        return codigo;
    }

    public String getMorada() {
        return morada;
    }

    public String getLocalidade() {
        return localidade;
    }

    public int getNPostosAtendimento() {
        return NPostosAtendimento;
    }

    public Gestor getGestor() {
        return gestor;
    }

    public int getNumMaxMarcacoes() {
        return NumMaxMarcacoes;
    }

    public Repositorio_Vacinas getStockVacinas() {
        return StockVacinas;
    }

    public Marcacoes getMarcacoesV() {
        return MarcacoesV;
    }

    public Repositorio_Doencas getEfeitosSecRegs() {
        return EfeitosSecRegs;
    }

    public int getVacinasAdministradas() {
        return VacinasAdministradas;
    }
    
    //Seletores
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public void setNPostosAtendimento(int NPostosAtendimento) {
        this.NPostosAtendimento = NPostosAtendimento;
    }

    public void setStockVacinas(Repositorio_Vacinas StockVacinas) {
        this.StockVacinas = StockVacinas;
    }

    public void setGestor(Gestor gestor) {
        this.gestor = gestor;
    }

    public void setNumMaxMarcacoes(int NumMaxMarcacoes) {
        this.NumMaxMarcacoes = NumMaxMarcacoes;
    }

    public void setVacinasAdministradas(int VacinasAdministradas) {
        this.VacinasAdministradas = VacinasAdministradas;
    }
}
