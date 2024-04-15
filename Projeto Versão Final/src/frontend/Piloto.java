/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import backend.Administrador;
import backend.Marcacoes;
import backend.Repositorio_Doencas;
import backend.Repositorio_Vacinas;
import backend.Utilizador;
import backend.Utente;
import backend.Vacina;
import backend.Sistema;
import backend.Centro_Vacinacao;
import backend.Gestor;
import backend.ListaCentro_Vacinacao;
import backend.ListaUtilizador;
import backend.Serializacao;
import frontend.JanLogin;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Piloto implements Serializable{

    
    public static void main(String[] args) {
        Sistema sistema;
        Serializacao dados = new Serializacao("Dados");
        if (!dados.getFicheiro().exists()) {
            sistema = new Sistema();
            Vacina vacina1 = new Vacina("Pfizer", "01", "Pfizer", 20, 0, 30, 2, 12, 15);
            vacina1.getDoencas().adicionar("Diabtes");
            vacina1.getDoencas().adicionar("HIV");
            sistema.getVacinas().add(vacina1);
            Vacina vacina2 = new Vacina("Janssen", "02", "Janssen", 20, 18, 60, 1, 12, 15);
            vacina2.getDoencas().adicionar("Asma");
            vacina2.getDoencas().adicionar("HIV");
            sistema.getVacinas().add(vacina2);
            Vacina vacina3 = new Vacina("Sputnik V", "03", "Sputnik V", 20, 35, 100, 2, 12, 15);
            vacina3.getDoencas().adicionar("Epilepsia");
            vacina3.getDoencas().adicionar("Tuberculose");
            sistema.getVacinas().add(vacina3);
            Gestor gestor = new Gestor("g001", "Gestor 1", "1234");
            Utente utente2 = new Utente("12345678", "Utente2", "1234", "Rua Damão", "Guimaraes", LocalDate.parse("2002-04-12"), 96998214, "a@a");
            sistema.getUtilizadores().Adicionar(new Utilizador("123", "Utilizador", "1234"));
            sistema.getUtilizadores().Adicionar(utente2);
            sistema.getUtilizadores().Adicionar(new Administrador("a001", "Administrador", "admin"));
            sistema.getUtilizadores().Adicionar(gestor);
            Centro_Vacinacao centro = new Centro_Vacinacao("a", "b", "Esposende", 1, gestor, 10);
            utente2.setCentro_vacinacao(centro);
            sistema.getCentros_Vacinacao().Adicionar(centro);
            centro.getStockVacinas().adicionarQtdVacina(vacina2, 45L);
            centro.getStockVacinas().adicionarQtdVacina(vacina1, 45L);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/uuuu-HH:mm");
            LocalDateTime data1= LocalDateTime.parse("1/06/2021-15:30", formatter);
            LocalDateTime data2= LocalDateTime.parse("15/06/2021-15:30", formatter);   
            centro.getMarcacoesV().Marcar(data1, utente2); 
            centro.getMarcacoesV().Marcar(data2, utente2);
            System.out.println("Dados iniciados com sucesso");
            
        } else {
            sistema = dados.carregar();
            System.out.println("Dados carregados");
        }
        JanLogin janela = new JanLogin(sistema, dados);
        janela.setVisible(true);

        Utente locus = new Utente("123", "vira", "vira", "guimaraes", "guimaraes", LocalDate.of(2002,05,10), 966998214, "gg");
        LocalDate data1 = LocalDate.of(2002,05,02);
        System.out.println(locus.calcIdade());
        Repositorio_Doencas doencas = new Repositorio_Doencas();
        doencas.adicionar("Gripe A");
        doencas.adicionar("Covid");
        doencas.adicionar("sadasd");
        doencas.verDoencas();
        Marcacoes marcacoes = new Marcacoes();
        Utente vira4 = new Utente("123", "vira", "123", "guimaraes", "guimaraes", LocalDate.of(2002,05,10), 966998214, "gg");
        Utente vira2 = new Utente("1234", "vira2", "123", "guimaraes", "guimaraes", LocalDate.of(2002,05,10), 966998214, "gg");
        LocalDateTime data = LocalDateTime.now().plusDays(10);
        marcacoes.Marcar(data, locus);
        marcacoes.Marcar(data, vira2);
        System.out.println(marcacoes.VerMarcacoes(data));
        System.out.println(marcacoes.VerMarcacoes(data));
        marcacoes.Cancelar(data, locus);
        System.out.println(marcacoes.VerMarcacoes(data));
        System.out.println(marcacoes.ProxMarcação(vira2));
        Vacina vacina1 = new Vacina("Pfizer", "01", "Pfizer", 20, 0, 30, 2, 12, 15);
        Vacina vacina2 = new Vacina("Janssen", "02", "Janssen", 20, 18, 60, 1, 12, 15);
        Long quantidade = 500L;
        Long quantidade2 = 700L;
        
        Repositorio_Vacinas vacinas = new Repositorio_Vacinas();
        vacinas.adicionarQtdVacina(vacina1, quantidade);
        System.out.println(vacinas.stockDisponivel(vacina1));
        vacinas.adicionarQtdVacina(vacina1, quantidade2);
        System.out.println(vacinas.stockDisponivel(vacina1));
        vacinas.remover(vacina1, 500L);
        System.out.println(vacinas.stockDisponivel(vacina1));
        vacinas.remover(vacina1, 1000L);
        System.out.println(vacinas.stockDisponivel(vacina1));
        System.out.println(vacinas.existe(vacina1));
        System.out.println(vacinas.existe(vacina2));
        ListaUtilizador utilizadores = new ListaUtilizador();
        
        Gestor user2 = new Gestor("Locus123", "123", "Vira");
        Gestor user4 = new Gestor("Locus1234", "123", "Vira2");
        
        utilizadores.Adicionar(user2);

        utilizadores.Adicionar(user4);
        System.out.print(utilizadores.getGestores());
        Centro_Vacinacao CentroLocus = new Centro_Vacinacao("123", "Guimaraes", "Guimaraes", 2, user2, 3);
        Centro_Vacinacao centro2 = new Centro_Vacinacao("1234", "Guimaraes", "Guimaraes", 6, user4, 10);
        System.out.print(CentroLocus);
        ListaCentro_Vacinacao centros = new ListaCentro_Vacinacao();
        centros.Adicionar(CentroLocus);
        centros.Adicionar(centro2);
        System.out.print(centros.verCentros());
    }
    
}
