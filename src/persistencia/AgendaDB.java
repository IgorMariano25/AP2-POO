package persistencia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import entidades.Agenda;
import util.Arquivo;

public class AgendaDB {
    private List<Agenda> agendas = new ArrayList<>();
    private String caminho;
    
    public AgendaDB(String caminho) throws IOException {
        this.caminho = caminho;
        this.importar();
    }

    public void adicionar(String[] dadosAgenda) {
        Agenda agenda = new Agenda(dadosAgenda[0], dadosAgenda[1], dadosAgenda[2], dadosAgenda[3], dadosAgenda[4]);
        if (!this.agendas.contains(agenda)) {
            this.agendas.add(agenda);
        }
    }

    public void alterar(String[] dadosAgenda) {
        Agenda agenda = new Agenda(dadosAgenda[0], dadosAgenda[1], dadosAgenda[2], dadosAgenda[3], dadosAgenda[4]);
        int posicao = this.agendas.indexOf(agenda);
        if (posicao != -1) {
            this.agendas.set(posicao, agenda);
        }
    }

    public Agenda consultar(String diaSemana) {
        Agenda agenda = new Agenda(diaSemana);
        int posicao = this.agendas.indexOf(agenda);
        if (posicao != -1) {
            return this.agendas.get(posicao);
        }
        return null;
    }

    public void excluir(String diaSemana) {
        Agenda agenda = new Agenda(diaSemana);
        if(this.agendas.contains(agenda)){
            this.agendas.remove(agenda);
        }
    }

    public Agenda Agendar(String diaSemana) {
        Agenda agenda = new Agenda(diaSemana);
        int posicao = this.agendas.indexOf(agenda);
        if (posicao != -1) {
            return this.agendas.get(posicao);
        }
        return null;
    }


    public List<Agenda> listar() {
        return Collections.unmodifiableList(this.agendas);
    }
    
    public void importar() throws IOException{
        List<String> linhas = Arquivo.ler(this.caminho);

        for (String linha : linhas) { 
            this.adicionar(linha.split(" - "));
        }
    }

    public void exportar() throws IOException{
        List<String> linhas = new ArrayList<>();
        for (Agenda agenda : this.agendas) {
            linhas.add(agenda.toString());
        }
        Arquivo.escrever(this.caminho, linhas);
    }

    @Override
    public String toString() {
        String msg = "";
        for (Agenda agenda : this.listar()){
            msg += agenda + "\n";
        }
        return msg;
    }
    
}
